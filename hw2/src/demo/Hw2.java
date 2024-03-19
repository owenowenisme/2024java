package demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Hw2 {
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int t = keyboard.nextInt();
        for (int j = 0; j < t; j++) {
            if (!keyboard.hasNext())
                break;
            String a = keyboard.next();
            String b = keyboard.next();

            BigDecimal aBigDecimal = new BigDecimal(a);
            BigDecimal bBigDecimal = new BigDecimal(b);
            int aInt = aBigDecimal.intValue();
            int bInt = bBigDecimal.intValue();

            int aScale = aBigDecimal.scale();
            int bScale = bBigDecimal.scale();

            int aFraction = aBigDecimal.subtract(new BigDecimal(aInt))
                    .multiply(BigDecimal.valueOf(Math.pow(10, aScale))).intValue();
            int bFraction = bBigDecimal.subtract(new BigDecimal(bInt))
                    .multiply(BigDecimal.valueOf(Math.pow(10, bScale))).intValue();
            ;
            int LCM = lcm(aScale, bScale);

            StringBuilder tmp = new StringBuilder("0.");

            for (int i = 0; i < LCM / aScale; i++) {
                tmp.append(aFraction);
            }

            BigDecimal new_a = new BigDecimal(tmp.toString());
            tmp = new StringBuilder("0.");

            for (int i = 0; i < LCM / bScale; i++) {
                tmp.append(bFraction);
            }

            BigDecimal new_b = new BigDecimal(tmp.toString());
            BigDecimal Fraction = new_a.add(new_b);
            if (Fraction.intValue() >= 1)
                Fraction = new BigDecimal(Math.pow(10, -LCM) * 1.5).add(Fraction);

            Fraction = Fraction.setScale(LCM, RoundingMode.FLOOR)
                    .add(new BigDecimal(aInt)).add(new BigDecimal(bInt));
            String frString = Fraction.toPlainString();
            char lastDigit = frString.charAt(frString.length() - 1);
            boolean check = true;
            for (int i = frString.length() - 1; i > 0; i--) {
                if (frString.charAt(i) == '.')
                    break;
                if (frString.charAt(i) != lastDigit) {
                    check = false;
                    break;
                }
            }
            if (check)
                frString = String.valueOf(Fraction.intValue()) + '.' + lastDigit;
            if (check && lastDigit == '9')
                frString = String.valueOf(Fraction.intValue() + 1);
            System.out.println(frString);
        }
        keyboard.close();
    }
}
