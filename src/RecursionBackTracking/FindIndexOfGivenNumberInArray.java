package RecursionBackTracking;

public class FindIndexOfGivenNumberInArray 
{
   public static void main(String args[])
   {
	   int arr[] = {3,4,5,6,7,8,7,9,6};
	   int findex = firstIndexOfGivenNumber(arr,0,7); 
	   int lindex = lastIndexOfGivenNumber(arr,0,7,-1);
	   System.out.println("First idx: "+findex);
	   System.out.println("Last idx: "+lindex);
   }
   
   
   public static int firstIndexOfGivenNumber(int arr[],int idx,int num)
   {
	   if (arr[idx] == num)
	   {
		   return idx;
	   }
	   return firstIndexOfGivenNumber(arr,idx+1,num);
   }
   public static int lastIndexOfGivenNumber(int arr[],int idx,int num,Integer index)
   {
	   if (idx == arr.length)
		   return index;
	   if ( arr[idx] == num)
	   {
		   index = Math.max(idx, index);
	   }
	   index = lastIndexOfGivenNumber(arr,idx+1,num,index);
	   
	   return index;
   }
   public static int lastIndexOfGivenNumber1(int arr[],int idx,int num)
   {
	   if (idx == arr.length)
	   {
		   return -1;
	   }
	   int lIdxSub = lastIndexOfGivenNumber1(arr,idx+1,num);
	   if (lIdxSub == -1)
	   {
		   if (arr[idx] == num)
			   lIdxSub = idx;
	   }
	   return lIdxSub;
   }
}


