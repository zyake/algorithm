package my.algorithm.traverse;

import java.util.*;

public class AStartSolutionFinder<T extends Node> implements SolutionFinder<T> {

    private static  final Comparator<Node> SCORE_COMPARATOR = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getScore() - o2.getScore();
        }
    };

    private NodeEvaluator<T> evaluator;

    public AStartSolutionFinder(NodeEvaluator<T> evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public Solution findSolution(T firstStep, T target) {
        HashMap<T, T> foundNodes = new HashMap<>();
        List<T> path = new ArrayList<>();
        int score = evaluator.evaluate(target, firstStep);
        firstStep.setScore(score);
        path.add(firstStep);

        while ( ! path.isEmpty() ) {
            Collections.sort(path, SCORE_COMPARATOR);
            T node = path.remove(0);
            foundNodes.put(node, node);
            boolean targetFound = node.equals(target);
            if ( targetFound ) {
                return createSolution(node, foundNodes.values(), path);
            }

            for ( Node obj : node.nextSteps() ) {
                T next = (T) obj;
                int newScore = evaluator.evaluate(target, next);
                next.setScore(newScore);
                boolean exists = foundNodes.containsKey(next);
                if  ( exists ) {
                    T prior = foundNodes.get(next);
                    boolean scoreImproved = prior.getScore() > next.getScore();
                    if ( scoreImproved ) {
                        foundNodes.remove(next);
                        path.add(next);
                    }
                } else {
                    foundNodes.put(next, next);
                    path.add(next);
                }
            }
        }

        return null;
    }

    private Solution createSolution(Node step, Collection<T> foundNodes, List<T> stepPath) {
        List<Node> solutionPath = new ArrayList<>();
        Node currentStep = step;
        while ( currentStep != null ) {
            solutionPath.add(currentStep);
            currentStep = currentStep.getPrevStep();
        }

        return new Solution(solutionPath, stepPath.size(), foundNodes.size());
    }
}
