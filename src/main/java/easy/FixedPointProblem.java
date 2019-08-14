package easy;

import evs_algorithms.BinarySearch;

public class FixedPointProblem {
    private BinarySearch bs;

    public FixedPointProblem(){
        bs = new BinarySearch();
    }

    public int fixedPoint(int[] A) {
        int index = bs.binarySearchAndReturnExpectedIndexLocationIfNotFound(A, 0, A.length - 1, 0);
        while(index < A.length) {
            if(A[index] == index) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
