package arrays;

import java.util.Scanner;

public class FaultyKeyboard {
    public static boolean isPossible(String name, String typed) {
        int i=0;
        int j=0;
        
        while(i < name.length() && j < typed.length()){
            if (name.charAt(i) == typed.charAt(j))
            {
                i++;
                j++;
            }
            else{
                if (i > 0 && name.charAt(i-1) == typed.charAt(j))
                {
                    j++;
                }
                else 
                {
                	break;
                }
            }
            System.out.println("i: "+i+" j:"+j+" name.length(): "+name.length()+" typed.length(): "+typed.length());
        }
        
        if (i==name.length() && name.charAt(i-1) == typed.charAt(j))
           return true;
        return false;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String name = scn.next();
        String typed = scn.next();

        boolean res = isPossible(name, typed);

        System.out.println(res);
    }
}
