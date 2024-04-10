package demo;

import java.util.Scanner;

public class Hw5 {
    static String s;
    public static void dfs(int x,int y,char a[][],int k){
        if (x<0 || x>=a.length || y<0 || y>=a[0].length){
            return;
        }
        if (k==s.length()){
            System.out.println("true");
            System.exit(0);
        }
        if (a[x][y] == s.charAt(k)){
            dfs(x+1,y,a,k+1);
            dfs(x-1,y,a,k+1);
            dfs(x,y+1,a,k+1);
            dfs(x,y-1,a,k+1);
        }
        return;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char a[][] = new char[n][m];
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                a[i][j] = scanner.next().charAt(0);
            }
        }
        s = scanner.next();
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                dfs(i,j,a,1);
            }
        }
        System.out.println("false");
    }
        
}
