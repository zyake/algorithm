package my.algorithm.traverse;

import java.util.*;

public class BreadthFirstSolutionFinder implements SolutionFinder {

    @Override
    public Solution findSolution(Node firstStep, Node target) {
        Set<Node> foundNodes = new HashSet<>();
        Queue<Node> stepPath = new LinkedList<>();
        stepPath.add(firstStep);

        while ( ! stepPath.isEmpty() ) {
            Node currentStep = stepPath.poll();
            boolean targetFound = currentStep.equals(target);
            if ( targetFound ) {
                return createSolution(currentStep, foundNodes, stepPath);
            }
            foundNodes.add(currentStep);

            for ( Node nextStep : currentStep.nextSteps() ) {
                boolean isVisited = foundNodes.contains(nextStep);
                if ( isVisited ) {
                    continue;
                }

                stepPath.add(nextStep);
                foundNodes.add(nextStep);
            }
        }

        return null;
    }

    private Solution createSolution(Node step, Set<Node> foundNodes, Queue<Node> stepPath) {
        List<Node> solutionPath = new ArrayList<>();
        Node currentStep = step;
        while ( currentStep != null ) {
            solutionPath.add(currentStep);
            currentStep = currentStep.getPrevStep();
        }

        return new Solution(solutionPath, stepPath.size(), foundNodes.size());
    }
}
