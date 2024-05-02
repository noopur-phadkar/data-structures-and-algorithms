package searching_algorithms.sentinel_search;

public class Main {

    public static boolean sentinel_search(int[] arr, int num){
        int current_index = 0;
        arr[arr.length - 1] = num;
        while (arr[current_index] != num) {
            current_index += 1;
        }
        if (arr[current_index] == num && current_index != arr.length - 1) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {2,5,7,3,5,8,2,9,10};
        System.out.println(sentinel_search(arr, 5));
        System.out.println(sentinel_search(arr, 15));
    }
}
