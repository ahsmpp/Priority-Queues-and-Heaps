import java.util.*;

public class PriorityQueueADT {
    public static void PQimplement(int[] arr, int M){
	// It creates a priority queue and inserts all array elements
        // into the priority queue.
	PriorityQueue<Integer> priorqueue = new PriorityQueue<>();
	for (int x : arr){
            //Add element in priority queue
            priorqueue.add(x);
        }
		
	//Print smallest element
        System.out.println(priorqueue.peek());

	while (M-- > 0){
            //Print top M elements which are going to be removed.
            System.out.println(priorqueue.poll());
	}

        //Print remaining elements
	Iterator itr = priorqueue.iterator();  
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int arr[] = getArrayInput(N, scanner);
        PQimplement(arr, M);
    }
}