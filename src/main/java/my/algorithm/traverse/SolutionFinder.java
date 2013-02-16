package my.algorithm.traverse;

/**
 * 目標のパスへ到達するためのソリューションを探索する。
 */
public interface SolutionFinder<T extends Node> {

    Solution findSolution(T firstStep, T target);
}
