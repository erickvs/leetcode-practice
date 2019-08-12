package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/find-anagram-mappings/
public class FindAnagramMappingsProblem {

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] anagramMapping = new int[A.length];
        for(int b = 0; b < B.length; b++) map.put(B[b], b);
        for(int a = 0; a < A.length; a++) anagramMapping[a] = map.get(A[a]);
        return anagramMapping;
    }

    // this solution is wrong because only those indexes that exists as values in the map become
    // part of the anagramMapping array. So say that there are duplicate values in the array that we use
    // to create the map, then when we put the key value pair in a hashmap the second time the first value
    // will be lost, that value is an index for the result and since we don't have taht index that value stays as
    // 0 in the result array. so we get anagramMapping[lostValue] = 0 which is more likely than not wrong. A solution to
    // this would be to make sure that the value is not lost. In the solution below this wrong solution a queue is created
    // that makes sure tht the indices are not lost. This leads to a correct result, but it's slow...
    public int[] anagramMappingsWrong(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] anagramMapping = new int[A.length];
        for (int a = 0; a < A.length; a++) map.put(A[a], a);
        for (int b = 0; b < B.length; b++) anagramMapping[map.get(B[b])] = b;
        return anagramMapping;
    }

    public int[] anagramMappingsLongAnswer(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            final int index = i;
             map.compute(A[i], (key, value) -> value == null
                     ? createQueueWithSingleElement(index)
                     : createQueueWithNewElement(value, index));
        }
        for (int i = 0; i < B.length; i++) result[map.get(B[i]).remove()] = i;
        return result;
    }

    private Queue<Integer> createQueueWithSingleElement(int element) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(element);
        return queue;
    }

    private Queue<Integer> createQueueWithNewElement(Queue<Integer> queue, int newElement) {
        queue.add(newElement);
        return queue;
    }
}
