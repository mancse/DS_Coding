import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
          Set<Integer> uniqSortedScores = new TreeSet<>(Collections.reverseOrder());
          uniqSortedScores.addAll(ranked);
          
          List<Integer> sortedScores = new ArrayList<>(uniqSortedScores); 
          List<Integer> result = new ArrayList<>();
          int index = sortedScores.size()-1;
          for (int score : player){
              while (index >= 0 && score >= sortedScores.get(index)) {
                index--;
            }
            // Rank is index + 2 because index starts from 0
            result.add(index + 2);
          }
          return result;
    }

}

