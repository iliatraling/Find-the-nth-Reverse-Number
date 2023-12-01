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

        long index = 10_000;

        System.out.println("Index of polindrom is " + index);
        timeStart = System.currentTimeMillis();
        reversNumber = findReverseNumberSimple(index);
        timeEnd = System.currentTimeMillis();
        System.out.println("Simple metod execution time = " + (timeEnd - timeStart) + " ms. Revers Number is " + reversNumber + ". Index is " + index);

        index = 19_000_000;
        timeStart = System.currentTimeMillis();
        reversNumber = findReverseNumberUpdate(index);
        timeEnd = System.currentTimeMillis();
        System.out.println("Update metod execution time = " + (timeEnd - timeStart) + " ms. Revers Number is " + reversNumber + ". Index is " + index);

        index = 19_000_000l;
        timeStart = System.currentTimeMillis();
        reversNumber = findReverseNumberUpdate2(index);
        timeEnd = System.currentTimeMillis();
        System.out.println("Update 2 metod execution time = " + (timeEnd - timeStart) + " ms. Revers Number is " + reversNumber + ". Index is " + index);

    }

    public static BigInteger findReverseNumberUpdate2(long n) {
        boolean isOdd = true;
        StringBuilder answer;
        long centerNumber;// first part of the polydrome number
        long interval = 0; //the maximum palindrome index at which the length of the polyndrome does not increase
        long koef = 9;//coefficient to add when palindrome length goes from odd to even

        if (n < 11) {
            return new BigInteger(Long.toString(n - 1));
        }

        for (long i = 11; i <= n;) {

            isOdd = !isOdd;

            interval = i;
            if(isOdd) {
                koef *= 10;
                if(n < 20){
                    i = 9;
                }
            }
            i += koef;
        }
        //System.out.println("k= " + koef + " i= " + interval + " isOdd " + isOdd);
        if(isOdd)
            centerNumber = (long) (n - Math.pow(10, (double) (Long.toString(koef).length() - 1)));
        else
            centerNumber = (long) (n - Math.pow(10, (double) (Long.toString(n).length() - 1)));



        if(!isOdd) { // create full number (revers first part of number)
            answer = new StringBuilder(Long.toString(centerNumber)).append(new StringBuilder(Long.toString(centerNumber)).reverse());
        } else {
            StringBuilder stringBuilder = new StringBuilder(Long.toString(centerNumber));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            answer = new StringBuilder(Long.toString(centerNumber)).append(stringBuilder.reverse());
        }
        return new BigInteger(answer.toString());
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