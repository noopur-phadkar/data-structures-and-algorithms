package searching_algorithms.binary_search;

public class Main {

    public static boolean binary_search(int[] arr, int num){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] == num){
                return true;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8,9,10,13};
        System.out.println(binary_search(arr, 13));
        System.out.println(binary_search(arr, 1));
    }
}
