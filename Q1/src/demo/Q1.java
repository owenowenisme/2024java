package demo;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String eq = scanner.next();
            int sign = 1;
            int xnum = 0;
            int constnum = 0;
            int tmpSign = 1;
            int tmp = 0;
            String[] eqs = eq.split("=");
            for (String s : eqs) {
                // System.out.println(s);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '-' || s.charAt(j) == '+') {
                        constnum += tmp * sign * tmpSign;
                        tmp = 0;
                        if (s.charAt(j) == '-') {
                            tmpSign = -1;
                        } else {
                            tmpSign = 1;
                        }
                    } else if (s.charAt(j) == 'x') {
                        if (tmp == 0)
                            tmp++;
                        
                        // System.out.println(tmp * tmpSign);

                        xnum += tmp * sign * tmpSign;
                        tmp = 0;
                    } else {
                        tmp *= 10;
                        tmp += s.charAt(j) - '0';
                    }

                }
                if (tmp>0){
                    constnum += tmp * sign * tmpSign;
                }
                tmp = 0;
                tmpSign = 1;
                sign = -1;
            }
            if (tmp>0){
                constnum += tmp * sign * tmpSign;
            }
            // System.out.println(xnum);
            // System.out.println(constnum);
            if(xnum==constnum){
                System.out.println("Infinite solutions");
            }else if (xnum==0 && constnum != 0){
                System.out.println("No solution");
            }else{
                int ans = constnum/xnum;
                System.out.println("x="+ans*-1);
            }
        }
        
    }
}