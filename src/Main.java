import java.math.BigInteger;

//DESCRIPTION:
//    Reverse Number is a number which is the same when reversed.
//
//    For example, the first 20 Reverse Numbers are:
//
//    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101
//    TASK:
//
//    You need to return the nth reverse number. (Assume that reverse numbers start from 0 as shown in the example.)
//    NOTES:
//
//    1 < n <= 100000000000
public class Main {
    public static void main(String[] args) {
        long timeStart, timeEnd;
        BigInteger reversNumber;
        timeStart = System.currentTimeMillis();
        reversNumber = findReverseNumberUpdate(10_000);
        timeEnd = System.currentTimeMillis();
        System.out.println("Simple metod execution time = " + (timeEnd - timeStart) + " ms. Revers Number is " + reversNumber);

    }
    public static BigInteger findReverseNumberUpdate(long n) {
        boolean isOdd = true;
        StringBuilder answer;
        long centerNumber = 11;// first part of the polydrome number
        long koef = 10;//the coefficient that must be subtracted changes when the length of the polydrome turns from odd to even




        if(n < 11)
            return new BigInteger(Long.toString(n - 1));

        for (long i = 11; i <= n; i++) {
            if(Long.toString(centerNumber).length() < Long.toString(centerNumber+1).length()){
                isOdd = !isOdd;
                if(isOdd) {
                    koef *= 10;
                }
            }
            centerNumber = i - koef; // при всех случаях
        }

        if(isOdd) { // create full number (revers first part of number)
            answer = new StringBuilder(Long.toString(centerNumber)).append(new StringBuilder(Long.toString(centerNumber)).reverse());
        } else {
            StringBuilder stringBuilder = new StringBuilder(Long.toString(centerNumber));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            answer = new StringBuilder(Long.toString(centerNumber)).append(stringBuilder.reverse());
        }
        return new BigInteger(answer.toString());
    }
}