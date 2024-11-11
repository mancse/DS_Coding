package Graphs;
import java.util.*;
/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

Example 1:

Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
Example 3:

Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3
 

Constraints:

start.length == 8
end.length == 8
0 <= bank.length <= 10
bank[i].length == 8
start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
 * @author Manoj Kumar
 *
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        Set<String> geneBank = new HashSet<>();
        for (String gene : bank){
            geneBank.add(gene);
        }
        
        char[] choices = new char[]{'A','C','G','T'};
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                String curGene = queue.poll();
                if (curGene.equals(end)){
                    return steps;
                }             
                for (int j = 0 ; j < curGene.length(); j++){
                    String s1 = curGene.substring(0,j);
                    char c = curGene.charAt(j);
                    String s2 = curGene.substring(j + 1);
                    
                    for (int k=0; k<choices.length; k++){
                        if (choices[k] != c){
                            char c1 = choices[k];
                            String nextGene = s1 + String.valueOf(c1) + s2;
                            if (geneBank.contains(nextGene) && !visited.contains(nextGene)){
                                visited.add(nextGene);
                                queue.add(nextGene);
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
