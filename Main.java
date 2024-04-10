package demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;

        n = Integer.parseInt(s.nextLine());
        String[][] augmented_str = new String[n][];
        int equation_count = 0;
        if (n == 1) {
            String input = s.nextLine();
            String trash = s.nextLine();
            String regex = "0* [1-9][0-9]*";
            if (input.matches(regex)) {
                System.out.println("No solution");
                System.exit(0);
            }
            else
            {
                System.out.println("The only solution");
            }
        }
        boolean failed=false;

        while (true) {
            String input = s.nextLine();
            Pattern p = Pattern.compile("^(0\\s)*[1-9]\\d*$");
            Matcher m = p.matcher(input);
            boolean matched=m.find();
            if (input.equals("-999")) {
                break;
            }
            if (matched) {
                failed=true;
                continue;
            }
            String[] temp;
            temp = input.split(" ");
            augmented_str[equation_count] = temp;
            equation_count++;
        }
        if(failed)
        {
            System.out.println("No solution");
            System.exit(0);
        }
        if(equation_count==1)
        {
            System.out.println("Infinite solutions");
            System.exit(0);
        }
        double[][] augmented = new double[n][n + 1];
        double[][] coefficient = new double[n][n];
        for (int i = 0; i < equation_count; i++) {
            for (int j = 0; j < n + 1; j++) {
                double temp;
                temp = Double.parseDouble(augmented_str[i][j]);
                augmented[i][j] = temp;
                if (j != n) {
                    coefficient[i][j] = temp;
                }
            }
        }
        if (equation_count != n) {
                for(int i=1;i< equation_count;i++) {
                    for(int j=0;j< n+1;j++) {
                        augmented[i][j]-=augmented[0][j];
                    }
                }
                int zeroes=0;
                for(int i=0;i<equation_count;i++) {
                    for(int j=0;j<n+1;j++) {
                        if(augmented[i][j]==0) {
                             zeroes++;
                        }
                    }
                    if(zeroes==n+1) {
                        System.out.println("Infinite solutions");
                        System.exit(0);
                    }
                }
                System.out.println("No solution");
                System.exit(0);

        }
        GaussianElimination(augmented);

        s.close();
    }

    private static void GaussianElimination(double[][] aug_matrix) {
        int rank = 0;
        int rows = aug_matrix.length;
        int cols = aug_matrix[0].length;

        //Forward Elimination
        for (int col = 0; col < cols - 1; col++) {
            //partial pivoting
            double maxVal = Math.abs(aug_matrix[col][col]);
            int maxRowindex = col;
            for (int i = col + 1; i < rows; i++) {
                if (aug_matrix[i][col] > maxVal) {
                    maxRowindex = i;
                    maxVal = aug_matrix[i][col];
                }
            }
            if (maxRowindex != col) {
                double[] temp_matrix = aug_matrix[col];
                aug_matrix[col] = aug_matrix[maxRowindex];
                aug_matrix[maxRowindex] = temp_matrix;
            }
            for (int row = col + 1; row < rows; row++) {
                double factor;
                if (aug_matrix[col][col] == 0){// if pivot=0
                    factor=1;
                }
                else {
                    factor = aug_matrix[row][col] / aug_matrix[col][col];
                }
                for (int j = 0; j < cols; j++) {
                    aug_matrix[row][j] -= factor * aug_matrix[col][j];
                }
            }
        }
        int zeroes;
        for (double[] augMatrix : aug_matrix) {
            zeroes = 0;
            for (int j = 0; j < cols; j++) {
                if (augMatrix[j] == 0) {
                    zeroes++;
                }
                else
                {
                    if(zeroes==cols-1) {
                        System.out.println("No solution");
                        System.exit(0);
                    }
                }
            }
            if (zeroes == cols) {
                System.out.println("Infinite solutions");
                System.exit(1);
            }

        }
        System.out.println("The only solution");
        return;
    }
}