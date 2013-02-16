package my.algorithm.traverse;

import java.util.*;

public class DepthFirstSolutionFinder implements SolutionFinder {

    private final int maxDepth;

    public DepthFirstSolutionFinder(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    @Override
    public Solution findSolution(Node firstStep, Node target) {
        Set<Node> foundNodes = new HashSet<>();
        Stack<Node> stepPath = new Stack<>();
        stepPath.push(firstStep);

        while ( ! stepPath.empty() ) {
            Node currentStep = stepPath.pop();
            boolean targetFound = currentStep.equals(target);
            if ( targetFound ) {
                return createSolution(currentStep, foundNodes, stepPath);
            }
            foundNodes.add(currentStep);

            for ( Node nextStep : currentStep.nextSteps() ) {
                boolean reachToMaxDepth = maxDepth == nextStep.currentDepth();
                if ( reachToMaxDepth ) {
                    continue;
                }

                boolean isVisited = foundNodes.contains(nextStep);
                if ( isVisited ) {
                    continue;
                }

                stepPath.push(nextStep);
                foundNodes.add(nextStep);
            }
        }

        return null;
    }

    private Solution createSolution(Node step, Set<Node> foundNodes, Stack<Node> stepPath) {
        List<Node> solutionPath = new ArrayList<>();
        Node currentStep = step;
        while ( currentStep != null ) {
            solutionPath.add(currentStep);
            currentStep = currentStep.getPrevStep();
        }

        return new Solution(solutionPath, stepPath.size(), foundNodes.size());
    }
}
