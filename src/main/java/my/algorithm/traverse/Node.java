package my.algorithm.traverse;

import java.util.List;

public interface Node {

    int currentDepth();

    List<Node> nextSteps();

    Node getPrevStep();

    int getScore();

    void setScore(int score);
}
