import java.util.*;

public class SmallestRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //int arr[][] = {{1,4,7,9},{2,5,11,12},{2,4,5,6},{8,12,14,19}};
        int arr[][] = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        getSmallestRange(arr, k, n);
    }

    private static void getSmallestRange(int arr[][], int row, int col) {
        PriorityQueue<HeapIndex> priorityQueue = new PriorityQueue<>(row, new Comparator<HeapIndex>() {
            @Override
            public int compare(HeapIndex o1, HeapIndex o2) {
                return o1.val.compareTo(o2.val);
            }
        });
        int min = Integer.MIN_VALUE, max = Integer.MIN_VALUE, range = Integer.MAX_VALUE, start = 0, end = 0;
        for (int i = 0; i < row; i++) {
            HeapIndex heapIndex = new HeapIndex(arr[i][0], i, 0);
            priorityQueue.add(heapIndex);
            max = Math.max(arr[i][0], max);
        }

        while (true) {
            HeapIndex minHeapIndex = priorityQueue.poll();
            min = minHeapIndex.val;
            if (range > max - min) {
                range = max - min;
                start = max;
                end = min;
            }
            if(minHeapIndex.column < (col - 1)) {
                int nextColumn = minHeapIndex.column + 1;
                HeapIndex nextHeapIndex = new HeapIndex(arr[minHeapIndex.row][nextColumn], minHeapIndex.row, nextColumn);
                max = Math.max(nextHeapIndex.val, max);
                priorityQueue.add(nextHeapIndex);
            } else {
                break;
            }
        }
        System.out.println("[" + end + ", " + start + "]");
        System.out.println("Smallest range is : " + (start - end));
    }

    private static class HeapIndex {
        Integer val;
        int row;
        int column;

        HeapIndex(Integer val, int row, int column) {
            this.val = val;
            this.row = row;
            this.column = column;
        }
    }
}