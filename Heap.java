import java.io.*;
class MainHeap
{
	private int type;
	private int capacity;
	private int heapSize;
	private int[] arr;
	public MainHeap(int type,int capacity,int arr[])
	{
		this.type = type;
		this.capacity = capacity;
		this.heapSize = arr.length;
		this.arr = new int[capacity];
		for(int i=0;i<heapSize;i++)
		{
			this.arr[i] = arr[i];
		}
		buildHeap();
	}
	public int left(int i){return 2*i+1;}
	public int right(int i){return 2*i+2;}
	public int parent(int i){return (i-1)/2;}
	public int getCapacity()
	{
		return this.capacity;
	}
	public int[] getArray()
	{
		return this.arr;
	}
	public void insert(int data)
	{
		heapSize++;
		if(heapSize>capacity)
		{
			capacity*=2;
			int newArray[] = new int[capacity];
			for(int i=0;i<capacity/2;i++)
			{
				newArray[i] = arr[i];
			}
			arr = newArray;
		}
		int i=heapSize-1;
		arr[i] = data;
		if(type==1)
		{
			while(arr[parent(i)]<arr[i])
			{
				int temp=arr[parent(i)];
				arr[parent(i)]=arr[i];
				arr[i]=temp;
				i=parent(i);
			}
		}
		else
		{
			while(arr[parent(i)]>arr[i])
			{
				int temp=arr[parent(i)];
				arr[parent(i)]=arr[i];
				arr[i]=temp;
				i=parent(i);
			}
		}
	}
	public void buildHeap()
	{
		if(type == 1)
		{
			for(int i=((heapSize)/2)-1;i>=0;i--)
			{
				maxHeapify(i);
			}
		}
		else
		{
			for(int i=((heapSize)/2)-1;i>=0;i--)
			{
				minHeapify(i);
			}
		}
	}
	public int remove()
	{
		int victim = arr[0];
		arr[0] = arr[heapSize-1];
		arr[heapSize-1] = 0;
		heapSize--;
		if(type==1)
		{
			maxHeapify(0);
		}
		else
		{
			minHeapify(0);
		}
		return victim;
	}
	public void maxHeapify(int i)
	{
		int max=i;
		if(left(i)<arr.length && arr[max]<arr[left(i)])
		{
			max = left(i);
		}
		if(right(i)<arr.length && arr[max]<arr[right(i)])
		{
			max = right(i);
		}
		if(max!=i)
		{
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			maxHeapify(max);
		}
	}
	public void minHeapify(int i)
	{
	int min = i;
		if(left(i)<arr.length && arr[min]>arr[left(i)])
		{
			min = left(i);
		}
		if(right(i)<arr.length && arr[min]>arr[right(i)])
		{
			min = right(i);
		}
		if(min!=i)
		{
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			minHeapify(min);
		}	
	}
}
class Heap
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1 if MAX else -1: ");
		int type = Integer.parseInt(br.readLine());
		System.out.println("Enter the maximum capacity: ");
		int capacity = Integer.parseInt(br.readLine());
		System.out.println("Enter the number of elements: ");
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter an element: ");
			arr[i]=Integer.parseInt(br.readLine());
		}
		int root = 0;
		MainHeap mainHeap = null;
		boolean flag = true;
		int choice = 0;
		while(flag)
		{
			System.out.println("Enter your choice \n 1 for create\n2 for insert\n3 for remove\n4 for printing\nany other value for exit ");
			choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
				mainHeap = new MainHeap(type,Math.max(capacity,size),arr);
				break;
				case 2:
				System.out.println("Enter the element you want to insert : ");
				int data = Integer.parseInt(br.readLine());
				mainHeap.insert(data);
				break;
				case 3:
				System.out.println("Removed Element is : "+mainHeap.remove());
				break;
				case 4:
				System.out.println(mainHeap.getCapacity());
				int array[]=mainHeap.getArray();
				for(int i=0;i<mainHeap.getCapacity();i++)
				{
					System.out.print(array[i]+" ");
				}
				System.out.println();
				break;
				default:
				flag = false;
				break;
			}
		}
	}
}