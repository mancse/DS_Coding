package SearchingAndSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find if there is a subarray with 0 sum
 * @author Manoj.K
 * 
 * input[] ={1, 2, -5, 1, 2, -1}
 * 
 * Idea:
 * sum=0
 * i=0
 * sum =sum+input[0]=0+1=1
 * map.containsKey(sum)=map.containsKey(1)=false
 * map.put(sum,i)=map(1,0)
 * 
 * i=1
 * sum=sum+input[1]=1+2=3
 * map.containsKey(sum)=map.containsKey(3)=false
 * map.put(sum,i)=map(3,1)
 * 
 * i=2
 * sum=sum+input[2]=3+-5=-2
 * map.containsKey(sum)=map.containsKey(-2)=false
 * map.put(sum,i)=map(-2,2)
 * 
 * i=3
 * sum=sum+input[3]=-2+1=-1
 * map.containsKey(sum)=map.containsKey(-1)=false
 * map.put(sum,i)=map(-1,3)
 * 
 * i=4
 * sum=sum+input[4]=-1+2=1
 * map.containsKey(1)=true so,
 * 
 * start=map.get(sum)+1=map.get(1)+1=0+1=1
 * end=i=4
 * 
 * So, Desired array= {2,-5,1,2}
 * 
 */
public class SubArrayWithSumZero {
	public static void main(String args[]){
		int a[]={1, 4, -2, -2, 5, -4,0,0,3,-1};
		int res[] = subArraySumZero(a);
		
		System.out.println("Sub array lies between: "+res[0]+" and "+res[1]);
		
		List<int[]> result = findAllSubArraySumZero(a);
		
		System.out.println("All subarrays: ");
		
		for (int[] r : result){
			System.out.println(" "+r[0]+" and"+" "+r[1]);
			
		}
	}
	
	public static int[] subArraySumZero(int a[]){
		int res[] = new int[2];
		
		Map<Integer,Integer> map = new HashMap<>();
		int sum=0;
		for (int i=0; i<a.length;i++){
			
			sum = sum +a[i];
			if (map.containsKey(sum)){
				res[0] = map.get(sum) + 1;
				res[1] = i;
				
				break;
			}
			else if (a[i] == 0){
				res[0] = i;
				res[1] = i;
				break;
			}
			map.put(sum, i);
		}
		
		return res;
	}
	
	
	public static List<int[]> findAllSubArraySumZero(int a[]){
		
		List<int[]> result = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		int sum=0;
		
		for (int i=0; i<a.length;i++){
			sum = sum +a[i];
			if (map.containsKey(sum)){
				int res[] = new int[2];
				res[0] = map.get(sum) + 1;
				res[1] = i;
				result.add(res);
			}
			else if (a[i] == 0){
				int res[] = new int[2];
				res[0] = i;
				res[1] = i;
				result.add(res);
			}
			map.put(sum, i);
		}
		
		return result;
	}
}
