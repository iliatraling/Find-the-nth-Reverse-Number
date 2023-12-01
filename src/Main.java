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
        reversNumber = findReverseNumberSimple(10_000);
        timeEnd = System.currentTimeMillis();
        System.out.println("Simple metod execution time = " + (timeEnd - timeStart) + " ms. Revers Number is " + reversNumber);

    }
    public static BigInteger findReverseNumberSimple(long n) {
        long answer = 0;
        for (long i = 0, count = 1; count <= n; i++) {

            String str = Long.toString(i);
            String strReverse = new StringBuilder(str).reverse().toString();
            if (str.equals(strReverse)) {
                //System.out.println(str + " " + count);
                count++;
                answer = i;
            }

        }
        //System.out.println(" ");
        return new BigInteger(Long.toString(answer));
    }
}