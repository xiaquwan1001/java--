import java.util.Scanner;

public class RecordArrayPosition {
    public static int[] maxSubArraySum(int[] arr, int size) {
        int maxSoFar = arr[0];  // 记录最大子数组和
        int maxEndingHere = arr[0];  // 记录当前子数组的和

        int start = 0, end = 0, tempStart = 0;  // 记录最大子数组的起始和终点索引

        for (int i = 1; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;  // 可能是新的子数组起点
            } else {
                maxEndingHere += arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;  // 更新最大子数组的起点
                end = i;  // 更新最大子数组的终点
            }
        }

        return new int[]{maxSoFar, start, end}; // 返回最大子数组和及其索引
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

        int[] result = maxSubArraySum(arr, size);
        System.out.println("最大子数组和: " + result[0]);
        System.out.println("起始位置: " + result[1]);
        System.out.println("结束位置: " + result[2]);

        scanner.close();
    }
}
