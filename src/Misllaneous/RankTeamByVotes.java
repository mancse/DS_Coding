package Misllaneous;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
class RankTeamByVotes {
    public String rankTeams(String[] votes) {
        int size = votes[0].length();
        int[][] map= new int[26][size];
        
        for (String vote : votes){
            for (int i=0; i< vote.length(); i++){
                map[vote.charAt(i) -'A'][i]++;
            }
        }
        
        Character[] arr = new Character[size];
        for (int i=0; i < size; i++){
            arr[i] = votes[0].charAt(i);
        }

        Arrays.sort(arr,(x,y)->{
            /**
            ** This loop is to check compare count of each position vote
            ** of participant. 
             */
            for (int i=0; i<size; i++){
                if (map[x - 'A'][i] != map[y -'A'][i]){
                     return map[y -'A'][i] - map[x - 'A'][i];
                }
            }
            return x - y;
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
