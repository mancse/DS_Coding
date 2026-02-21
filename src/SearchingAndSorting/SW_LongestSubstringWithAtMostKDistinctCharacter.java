/**
** Problem: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/?envType=company&envId=coupang&favoriteSlug=coupang-all
**
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size() > k){
                char ch1 = s.charAt(left);
                map.put(ch1, map.get(ch1) - 1);
                if (map.get(ch1) == 0){
                    map.remove(ch1);
                }
                left++;
            }
            
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}
