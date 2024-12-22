package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**
** https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * ou are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
**
*/
public class KPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> queue = new PriorityQueue<int[]>((a1, a2) -> Integer.compare(a1[0],a2[0]));
        //Insert pair of each element from nums1 and first element of nums2 initially
        for (int i=0; i < nums1.length; i++){
            queue.offer(new int[]{nums1[i] + nums2[0], i,0});
        }
        int count = 0;
        while(!queue.isEmpty()){
            int[] elem = queue.poll();
            List<Integer> list = new ArrayList<>();
            int i = elem[1];
            int j = elem[2];
            list.add(nums1[i]);
            list.add(nums2[j]);
            res.add(list);
            if (count == k-1){
                return res;
            }
            count++;
            if (count < k && i < nums1.length && j < nums2.length-1){
                int sum2 = nums1[i] + nums2[j+1];
                queue.offer(new int[]{sum2, i,j+1});
            }
        }
        return res;
    }
}
