package demo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Hw1 {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        while (true){
            if (!keyboard.hasNext()) break;
            String a = keyboard.next();
            String b = keyboard.next();
            BigDecimal aBigDecimal = new BigDecimal(a);
            BigDecimal bBigDecimal = new BigDecimal(b);
            BigDecimal sum = aBigDecimal.add(bBigDecimal);
            System.out.println(sum.toPlainString());
        }
        keyboard.close();
    }
}
