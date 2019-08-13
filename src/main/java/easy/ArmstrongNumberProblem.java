package easy;

public class ArmstrongNumberProblem {
    public boolean isArmstrong(int N) {
        int sum = 0;
        String strNumber = Integer.toString(N);
        int numberOfDigits = strNumber.length();
        for(int i = 0; i < numberOfDigits; i++) {
            int currentDigit = convertCharToDigit(strNumber.charAt(i));
            sum += pow(currentDigit, numberOfDigits);
        }
        return N == sum;
    }

    private int pow(int a, int b) {
        int re = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                re *= a;
            }
            b >>= 1;
            a *= a;
        }
        return re;
    }

    private int convertCharToDigit(char charDigit) {
        return charDigit - 48;
    }
}
