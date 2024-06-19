package demo;

import java.util.Scanner;

public class Q2 {
    // class node{
    // public int a[] = new int[4];//LU,RU,RD,LD
    // public int b[] = new int[4];//U,P,L,R

    // node(){
    // for(int i = 0;i<4;i++){
    // a[i] = 0;
    // b[i] = 0;
    // }
    // }
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char arr[][] = new char[100][100];
        char ans[][] = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                arr[i][j] = '0';
            }
        }
        for (int i = 10; i < 20; i++) {
            String s[] = scanner.nextLine().split(" ");
            for (int j = 10; j < 20; j++) {
                arr[i][j] = s[j - 10].charAt(0);
                ans[i][j] = arr[i][j];
            }
        }
        String ans1 = "01111";
        String ans2 = "10111";
        String ans3 = "11011";
        String ans4 = "11101";
        String ans5 = "11110";
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                String tmp = "";
                for (int k = 0; k < 5; k++) {
                    tmp = tmp + arr[i][j + k];
                }
                if (tmp.equals(ans1)) {

                    ans[i][j] = 'X';
                } else if (tmp.equals(ans2)) {

                    ans[i][j + 1] = 'X';
                } else if (tmp.equals(ans3)) {

                    ans[i][j + 2] = 'X';
                } else if (tmp.equals(ans4)) {

                    ans[i][j + 3] = 'X';
                } else if (tmp.equals(ans5)) {

                    ans[i][j + 4] = 'X';
                }

            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                String tmp = "";
                for (int k = 0; k < 5; k++) {
                    tmp = tmp + arr[i + k][j];
                }
                if (tmp.equals(ans1)) {

                    ans[i][j] = 'X';
                } else if (tmp.equals(ans2)) {

                    ans[i + 1][j] = 'X';
                } else if (tmp.equals(ans3)) {

                    ans[i + 2][j] = 'X';
                } else if (tmp.equals(ans4)) {

                    ans[i + 3][j] = 'X';
                } else if (tmp.equals(ans5)) {

                    ans[i + 4][j] = 'X';
                }

            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                String tmp = "";
                for (int k = 0; k < 5; k++) {
                    tmp = tmp + arr[i + k][j + k];
                }
                if (tmp.equals(ans1)) {

                    ans[i][j] = 'X';
                } else if (tmp.equals(ans2)) {

                    ans[i + 1][j + 1] = 'X';
                } else if (tmp.equals(ans3)) {

                    ans[i + 2][j + 2] = 'X';
                } else if (tmp.equals(ans4)) {

                    ans[i + 3][j + 3] = 'X';
                } else if (tmp.equals(ans5)) {

                    ans[i + 4][j + 4] = 'X';
                }

            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                String tmp = "";
                for (int k = 0; k < 5; k++) {
                    tmp = tmp + arr[i + k][j - k];
                }
                if (tmp.equals(ans1)) {

                    ans[i][j] = 'X';
                } else if (tmp.equals(ans2)) {

                    ans[i + 1][j - 1] = 'X';
                } else if (tmp.equals(ans3)) {

                    ans[i + 2][j - 2] = 'X';
                } else if (tmp.equals(ans4)) {

                    ans[i + 3][j - 3] = 'X';
                } else if (tmp.equals(ans5)) {

                    ans[i + 4][j - 4] = 'X';
                }

            }
        }
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 19; j++) {
                System.out.print(ans[i][j]);
                System.out.print(' ');
            }
            System.out.println(ans[i][19]);
        }
    }
}
	
