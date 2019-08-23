package medium;

import java.util.*;

// TODO: Investigate BFS and see what you can do to make this better.
// TODO: Also.. when you learn dynamic programming come back to this
public class PerfectSquares {
    public int numSquares(int n) {
        if (n == 0 || n == 1) return 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        int rootNumber = floorSqrt(n), steps = 0, sum = 0;
        List<Integer> root = Arrays.asList(1, 0, 0);
        queue.offer(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> currentNode = queue.poll();
                if (isSumOfPerfectSquares(currentNode, n)) {
                    return getStep(currentNode) - 1;
                }
                List<List<Integer>> neighbors =  getNeighbors(currentNode, n, rootNumber);
                for (List<Integer> neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    private List<List<Integer>> getNeighbors(List<Integer> node, int maxSum, int rootNumber) {
        List<List<Integer>> r = new ArrayList<>();
        r.addAll(getNodesInNextStep(node, maxSum, rootNumber));
        r.addAll(getNodesInCurrentStep(node, maxSum, rootNumber));
        return r;
    }

    private List<List<Integer>> getNodesInCurrentStep(List<Integer> node, int maxSum, int rootNumber) {
        int step = getStep(node);
        int sum = getSum(node);
        List<List<Integer>> r = new ArrayList<>();
        for (int i = rootNumber; i >= 1 ; i--) {
            if (sum + i * i <= maxSum) {
                List<Integer> lst = Arrays.asList(step, sum, i);
                r.add(lst);
            }
        }
        return r;
    }

    private List<List<Integer>> getNodesInNextStep(List<Integer> node, int maxSum, int rootNumber) {
        int nextStep = getStep(node) + 1;
        int nextSum = getSum(node) + getNumber(node) * getNumber(node);
        List<List<Integer>> r = new ArrayList<>();
        for (int i = rootNumber; i >= 1 ; i--) {
            if (nextSum + i * i <= maxSum) {
                List<Integer> lst = Arrays.asList(nextStep, nextSum, i);
                r.add(lst);
            }
        }
        return r;
    }

    private boolean isSumOfPerfectSquares(List<Integer> node, int n) {
        int sum = node.get(1);
        int number = node.get(2);
        return sum + number * number == n;
    }

    private int getNumber(List<Integer> node) {
        return node.get(2);
    }

    private int getSum(List<Integer> node) {
        return node.get(1);
    }

    private int getStep(List<Integer> node) {
        return node.get(0);
    }

    private int floorSqrt(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }
}
