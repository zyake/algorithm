package my.algorithm.traverse;

public interface NodeEvaluator<T extends Node> {

    int evaluate(T target, T current);
}
