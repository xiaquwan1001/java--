import java.util.Scanner;

public class MaxSubarraySum {
    public static int maxSubArraySum(int[] arr, int size) {
        int maxSoFar = arr[0]; // 记录全局最大子数组和
        int maxEndingHere = arr[0]; // 记录当前子数组最大和

        for (int i = 1; i < size; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入数组大小: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("输入数组元素: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("最大子数组和: " + maxSubArraySum(arr, size));
        scanner.close();
    }
}