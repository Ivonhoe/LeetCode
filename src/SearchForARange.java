import data.YLog;

/**
 * Created by ivonhoe on 14-10-28.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        binarySearch(A, 0, A.length - 1, target, result);

        return result;
    }

    private void binarySearch(int[] A, int left, int right, int target, int[] result) {
        // not exist
        if (left > right) {
            result[0] = -1;
            result[1] = -1;
            return;
        }

        int middle = (left + right) / 2;
        if (target == A[middle]) {
            int start = middle;
            int end = middle;
            while (start > 0) {
                if (target == A[start - 1]) {
                    start--;
                } else {
                    break;
                }
            }

            while (end < A.length - 1) {
                if (target == A[end + 1]) {
                    end++;
                } else {
                    break;
                }
            }
            result[0] = start;
            result[1] = end;
        } else if (target < A[middle]) {
            binarySearch(A, left, middle - 1, target, result);
        } else if (target > A[middle]) {
            binarySearch(A, middle + 1, right, target, result);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[1];
        A[0] = 5;
//        A[1] = 7;
//        A[2] = 7;
//        A[3] = 8;
//        A[4] = 8;
//        A[5] = 10;
        SearchForARange searchForARange = new SearchForARange();
        YLog.d(searchForARange.searchRange(A, 5));
    }
}
