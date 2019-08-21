package medium;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;
        int steps = -1;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String seq = queue.poll();
                if (seq.equals(target)) {
                    return steps;
                }
                for (String nextSeq : getAdjacentSequences(seq)) {
                    if (!visited.contains(nextSeq)) {
                        visited.add(nextSeq);
                        queue.offer(nextSeq);
                    }
                }
            }
        }
        return -1;
    }
    private String[] getAdjacentSequences (String seq){
        int numberOfAdjSeq = 8;
        String[] adjSeqs = new String[numberOfAdjSeq];
        StringBuilder sb = new StringBuilder(seq);
        for (int i = 0, j = 0; i < seq.length(); i++) {
            sb.setCharAt(i, getNextChar(seq.charAt(i)));
            adjSeqs[j++] = sb.toString();
            sb.setCharAt(i, getPrevChar(seq.charAt(i)));
            adjSeqs[j++] = sb.toString();
            sb.setCharAt(i, seq.charAt(i));
        }
        return adjSeqs;
    }
    private char getNextChar ( char c){
        return c < '9' ? (char) (c + 1) : '0';
    }
    private char getPrevChar ( char c){
        return c > '0' ? (char) (c - 1) : '9';
    }
}

