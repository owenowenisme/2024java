package demo;

import java.util.Scanner;

public class Q3 {
    static int arr[][] = new int[8][8];
    static int visited[][] = new int[8][8];
    static boolean ans = false;

    public static void dfs(int x1, int y1, int x2, int y2, int turn, int dir) {
        // System.out.printf("num:%d, x1: %d, y1: %d, dir: %d, turn: %d x2: %d y2: %d NUM: %d%n", arr[y1][x1],x1, y1, dir, turn ,x2,y2,arr[y2][x2]);
        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 || turn > 2)
            return;
        if(x1==x2 && y1==y2) {
            ans = true;
            return;
        }
        
        if(arr[x1][y1]!=0) return;
        visited[x1][y1] = 1;
        if (x1 - 1 >= 0 && visited[x1 - 1][y1]==0) {// left1
            if (dir != 1)
                dfs(x1 - 1, y1, x2, y2, turn+1, 1);
            else
                dfs(x1 - 1, y1, x2, y2, turn, 1);
            
        }
        if (y1 - 1 >= 0 && visited[x1][y1-1]==0) {// down2
            if (dir != 2)
                dfs(x1, y1 - 1, x2, y2, turn+1, 2);
            else
                dfs(x1, y1 - 1, x2, y2, turn, 2);
            
        }
        if (x1 + 1 <= 7 && visited[x1+1][y1]==0) {// right3
            if (dir != 3)
                dfs(x1+1, y1, x2, y2, turn+1, 3);
            else
                dfs(x1+1, y1, x2, y2, turn, 3);
        }
        if (y1 + 1 <= 7 && visited[x1][y1+1]==0) {// up4
            if (dir != 4)
                dfs(x1, y1 + 1, x2, y2, turn+1, 4);
            else
                dfs(x1, y1 + 1, x2, y2, turn, 4);
        }
        visited[x1][y1] = 0;
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt()+1;
            int y1 = scanner.nextInt()+1;
            int x2 = scanner.nextInt()+1;
            int y2 = scanner.nextInt()+1;
            ans = false;
            for (int k = 0; k <= 7; k++) {
                for (int j = 0; j <= 7; j++) {
                    visited[k][j] = 0;
                }
            }
            visited[x1][y1]=1;
            dfs(x1-1, y1, x2, y2, 0, 1);
            dfs(x1, y1-1, x2, y2, 0, 2);
            dfs(x1+1, y1, x2, y2, 0, 3);
            dfs(x1, y1+1, x2, y2, 0, 4);
            visited[x1][y1]=0;
            if(ans){
                arr[x1][y1]=0;
                arr[x2][y2]=0;
                System.out.println("pair matched");
            }else{
                System.out.println("bad pair");
            }

        }

    }   
}
// 2 8 5 7 2 1
// 6 9 4 4 3 7
// 8 1 6 5 4 9
// 3 7 2 2 3 8
// 5 4 9 1 3 5
// 6 1 8 9 4 2
// 6
// 0 0 4 0