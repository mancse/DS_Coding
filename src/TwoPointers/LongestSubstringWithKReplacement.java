package TwoPointers;

public class LongestSubstringWithKReplacement {
	public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int freq[] = new int[26];
        int maxCharFreq = 0;
        int result = 0;
        for (right=0; right < s.length(); right++){
            
        	//Maintain the character frequency map. 
        	freq[s.charAt(right) - 'A']++;

            //maxCharFreq variable will maintain maximum frequency of any character in window of K
            maxCharFreq = Math.max(maxCharFreq,freq[s.charAt(right) - 'A']);
            
            //Characters to replace would be the difference of substring between left and right pointer
            // and the length of character which are repeated maximum so far i.e maxCharFreq
            int charsToReplace = (right - left + 1) - maxCharFreq;
            
            //Now check if length of chars to replace is becoming greater than K then shrink the window to 
            //to maintain K sized window and hence increment left pointer. 
            if (charsToReplace > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            //Maintain the longest matching character length so far. 
            result = (right - left + 1);
        }

        return result;
    }
}
