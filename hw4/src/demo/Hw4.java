package demo;

import java.util.Scanner;

public class Hw4 {
    public static class Equation{
        public int variable[];
        public int constant;
        public Equation(int n,int m[]){
            variable = new int[n];
            for(int i = 0; i < n; i++){
                variable[i] = m[i];
            }
            constant = m[n];
        }
    }
    public static void gaussian_elimination(int n,Equation eq[],int eq_num){
        for(int i = 0 ; i < eq_num ; i++){
            for(int j = i+1 ; j < eq_num ; j++){
                int a = eq[j].variable[i];
                int b = eq[i].variable[i];
                for(int k = 0 ; k < n ; k++){
                    eq[j].variable[k] = eq[j].variable[k]*b - eq[i].variable[k]*a;
                }
                eq[j].constant = eq[j].constant*b - eq[i].constant*a;
            }
        }
    }
    public static boolean checkIfAllZero(int n,Equation eq){
        for (int i=0;i<n;i++){
            if (eq.variable[i] != 0){
                return false;
            }
        }
        if (eq.constant != 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Equation eq[] = new Equation[11];
        int eq_num = 0;
        for (int i = 0;i<n;i++){
            int m[] = new int[n+1];
            for (int j = 0;j<n+1;j++){
                m[j] = scanner.nextInt();
                if ( m[j] == -999) {
                    break;
                }
            }
            if (m[0] == -999) {
                break;
            }
            eq_num++;
            eq[i] = new Equation(n,m);
        }
        scanner.close();
        gaussian_elimination(n,eq,eq_num);
        if (eq[eq_num-1].variable[n-1] != 0 && eq[eq_num-1].constant != 0){
            System.out.println("The only solution");
        }else{
            int q = eq_num-1;
            while (checkIfAllZero(n,eq[q])){
                q--;
            }
            for (int i = 0;i<n;i++){
                if (eq[q].variable[i] != 0){
                    System.out.println("Infinite solutions");
                    return;
                }
            }
            System.out.println("No solution");
        }
    }
}
