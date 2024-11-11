package arrays;

public class PairNumbersWithGivenSum
{
	public static void main(String args[])
	{
		int arr[] = {1,3,5,6,7,9,11,12,14,16,17};
		findPairSum(arr,13);
		findPairSum(arr,26);
		findPairSum(arr,33);
		findPairSum(arr,31);
		findPairSum(arr,30);
		findPairSum(arr,27);
		findPairSum(arr,34);
	}
	
	private static void findPairSum(int arr[], int total)
	{
		int left = 0;
		int right = arr.length -1;
		boolean pairFound = false;
		while (left < right)
		{
			int  sum = arr[left] + arr[right];
			if (sum == total)
			{
				pairFound = true;
				break;
			}
			else if (sum < total)
			{
				left = left+1;
			}
			else if (sum > total)
			{
				right = right-1;
			}
		}
		if (pairFound)
			System.out.println("Pair found at index : "+left+" , "+right);
		else
			System.out.println("Pair not found");
	}
}