import java.io.*;
class Heap
{
	private int capacity;
	private int heapSize;
	private int[] arr;
	Heap(int[] arr)
	{
		this.arr = arr;
		this.capacity = arr.length;
		this.heapSize = arr.length;
	}
	public int left(int i){return 2*i+1;}
	public int right(int i){return 2*i+2;}
	public int parent(int i){return (i-1)/2;}
	public void buildHeap()
	{
		for(int i=(heapSize/2)-1;i>=0;i--)maxHeapify(i);
	}
	public void minHeapify(int i)
	{
		int min = i;
		if(left(i)<heapSize && arr[min]>arr[left(i)])min = left(i);
		if(right(i)<heapSize && arr[min]>arr[right(i)])min = right(i);
		if(min != i)
		{
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			minHeapify(min);
		}
	}public void maxHeapify(int i)
	{
		int max = i;
		if(left(i)<heapSize && arr[max]<arr[left(i)])max = left(i);
		if(right(i)<heapSize && arr[max]<arr[right(i)])max = right(i);
		if(max != i)
		{
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			maxHeapify(max);
		}
	}
	public void sort(int arr[])
	{
		for(int i=heapSize-1;i>=0;i--)
		{
			arr[i] = remove();
		}
	}
	public int extractMax()
	{
		return arr[0];
	}
	public int remove()
	{
		int victim = arr[0];
		arr[0] = arr[heapSize-1];
		arr[heapSize-1] = 0;
		heapSize--;
		maxHeapify(0);
		return victim;
	}
}
class Sort
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter an element :");
			arr[i]=Integer.parseInt(br.readLine());
		}
		Heap heap = new Heap(arr);
		heap.buildHeap();
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		heap.sort(arr);
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]+" ");
		}
	}
}