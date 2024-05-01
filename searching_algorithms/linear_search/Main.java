package searching_algorithms.linear_search;

public class Main {

    public static boolean linearSearch(int[] arr, int num){
        for (int n : arr) {
            if (n == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,7,3,5,8,2,9,10};
        System.out.println(linearSearch(arr, 5));
        System.out.println(linearSearch(arr, 15));
    }
}