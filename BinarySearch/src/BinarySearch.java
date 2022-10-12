import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Enter :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = {1,2,3,5,8,13,21,34,55};
        int l = 0;
        int h = array.length - 1;
        int result = BinaryRecursion(array, l, h, n );
        if (result == -1) {
            System.out.println("There is no such digit in the array");
        } else {
            System.out.println("The digit " + n + " position in the array is: " + result);
        }
    }

    public static int BinaryRecursion(int[] a, int l, int h, int key) {
        if (l == h) {
            if (key == a[l]) {
                return l;
            } else {
                return -1;
            }
        } else if (l > h) {
            return -1;
        }
        int mid = (l + h)/2;
        if (key == a[mid]) {
            return mid;
        } else if (key > a[mid]) {
            return BinaryRecursion(a, mid+1, h, key);
        } else {
            return BinaryRecursion(a, l, mid-1, key);
        }
    }
}
