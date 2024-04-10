package demo;

import java.util.Scanner;

public class Hw6 {
    static char s[][] = new char[3][3];
    public static boolean winChecker(char c){
        if (s[0][0] == c && s[1][1] == c && s[2][2] == c){
            return true;
        }
        if (s[0][2] == c && s[1][1] == c && s[2][0] == c){
            return true;
        }
        for (int i = 0;i<3;i++){
            if (s[i][0] == c && s[i][1] == c && s[i][2] == c){
                return true;
            }
            if (s[0][i] == c && s[1][i] == c && s[2][i] == c){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        int x=0;
        int o=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                s[i][j] = tmp.charAt(i*3+j);
                if (s[i][j] == 'X'){
                    x++;
                }
                else if (s[i][j] == 'O'){
                    o++;
                }
            }
        }
        if (x<o || x>o+1){
            System.out.println("invalid");
            System.exit(0);
        }   
        boolean xwin = winChecker('X');
        boolean owin = winChecker('O');
        if(xwin && owin){
            System.out.println("invalid");
            System.exit(0);
        }
        if(xwin && x == o){
            System.out.println("invalid");
            System.exit(0);
        }
        if(owin && x > o){
            System.out.println("invalid");
            System.exit(0);
        }
        System.out.println("valid");
        System.exit(0);
    }
}
