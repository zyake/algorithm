package my.algorithm.traverse;

import java.util.*;

public class Solution {

    private List<Node> path;

    private int openCount;

    private int closeCount;

    public Solution(Collection<Node> nodes, int openCount, int closeCount) {
        this.path = Collections.unmodifiableList(new ArrayList<>(nodes));
        this.openCount = openCount;
        this.closeCount = closeCount;
    }

    public List<Node> getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "open=" + openCount + ", close=" + closeCount + ", " + path;
    }

    public int getOpenCount() {
        return openCount;
    }

    public int getCloseCount() {
        return closeCount;
    }
}
