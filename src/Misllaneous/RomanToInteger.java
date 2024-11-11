package Misllaneous;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static int romanToInt(String s) {
        Map<Character,Integer> map = getRomanMap();
        char[] romans = s.toCharArray();
        int first=0;
        int second=0;
        int result=0;
        
        for (int i=0; i<romans.length-1; i++){
            first = map.get(romans[i]);
            second= map.get(romans[i+1]);
            
            if (first < second){
                result = result - first;
            }
            else{
                result = result + first;
            }
        }
        
        int last = map.get(romans[romans.length-1]);
        result = result + last;
        
        return result;
    }
    
    private static Map<Character,Integer> getRomanMap(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
    
    public static void main(String args[]){
    	System.out.println("Integer value of LVIII is: "+romanToInt("LVIII"));
    	System.out.println("Integer value of MCMXCIV is: "+romanToInt("MCMXCIV"));
    }
}
