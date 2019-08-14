package evs_algorithms;

public class BinarySearch {
    public int binarySearchAndReturnExpectedIndexLocationIfNotFound(int[] arr, int l, int r, int elementToSearch) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if( arr[mid] == elementToSearch ) {
                return mid;
            }
            else if( elementToSearch < arr[mid] ) {
                return binarySearchAndReturnExpectedIndexLocationIfNotFound(arr, l, mid - 1, elementToSearch);
            }
            else {
                return binarySearchAndReturnExpectedIndexLocationIfNotFound(arr, mid + 1, r, elementToSearch);
            }
        }
        return arr.length > l ? l : arr.length - 1;
    }
}
