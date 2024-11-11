package arrays;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        
        printGCDAndLCM(n1,n2);
     }
     
     private static void printGCDAndLCM(int n1, int n2){
        int on1 = n1;
        int on2 = n2;
        while(n1 % n2 > 0){
            int rem = n1 % n2;
            n1= n2;
            n2 = rem;
        }
        
        int gcd = n2;
        int lcm = (on1 * on2)/gcd;
        System.out.println(n2);
        
        //LCM * GCD = n1 * n2;
        System.out.println(lcm);
     }
}
