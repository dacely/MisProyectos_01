package com.teonum;

import java.math.BigInteger;

public class MyPrimes
{
    private static BigInteger[] basicPrimes;
    private static BigInteger[] relativePrimes;
    private static BigInteger step;

    static { setNumberOfBasicPrimes(6); }

    public static void setNumberOfBasicPrimes(int numBasicPrimes)
    {
        basicPrimes = new BigInteger[numBasicPrimes];

        int count = 0;
        int i = 2;
        while (count < numBasicPrimes)
        {
            if (isPrime(i))
                basicPrimes[count++] = BigInteger.valueOf(i);
            i++;
        }

        step = BigInteger.ONE;
        for (BigInteger p : basicPrimes)
            step = step.multiply(p);

        relativePrimes = new BigInteger[step.intValue()];
        count = 0;

        for (BigInteger j = BigInteger.TWO; j.compareTo(step) < 0; j = j.add(BigInteger.ONE))
        {
            boolean isRelativePrime = true;

            for (BigInteger p : basicPrimes)
            {
                if (j.remainder(p).equals(BigInteger.ZERO))
                {
                    isRelativePrime = false;
                    break;
                }
            }

            if (isRelativePrime)
                relativePrimes[count++] = j;
        }

        BigInteger[] temp = new BigInteger[count];
        System.arraycopy(relativePrimes, 0, temp, 0, count);
        relativePrimes = temp;
    }

    public static boolean isPrime(int n)
    {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        int sqrtN = (int) Math.sqrt(n) + 1;

        for (int i = 6; i <= sqrtN; i += 6)
        {
            if (n % (i - 1) == 0 || n % (i + 1) == 0)
                return false;
        }

        return true;
    }

    public static boolean isPrime(long n)
    {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        long sqrtN = (long)Math.sqrt(n) + 1;

        for (long i = 6L; i <= sqrtN; i += 6)
        {
            if (n % (i - 1) == 0 || n % (i + 1) == 0)
                return false;
        }

        return true;
    }

    public static boolean isPrime(BigInteger n)
    {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger three = BigInteger.valueOf(3);
        BigInteger six = BigInteger.valueOf(6);

        if (n.compareTo(two) < 0)
            return false;

        if (n.equals(two) || n.equals(three))
            return true;

        if (n.remainder(two).equals(zero) || n.remainder(three).equals(zero))
            return false;

        BigInteger sqrtN = n.sqrt().add(one);

        for (BigInteger i = six; i.compareTo(sqrtN) <= 0; i = i.add(six))
        {
            if (n.remainder(i.subtract(one)).equals(zero)
                    || n.remainder(i.add(one)).equals(zero))
                return false;
        }

        return true;
    }

    public static boolean isBigPrime(BigInteger n)
    {
        for (BigInteger p : basicPrimes)
        {
            if (n.remainder(p).equals(BigInteger.ZERO))
                return false;
        }

        for (BigInteger rp : relativePrimes)
        {
            if (n.remainder(rp).equals(BigInteger.ZERO))
                return false;
        }

        BigInteger sqrtN = n.sqrt().add(BigInteger.ONE);

        for (BigInteger j = step; j.compareTo(sqrtN) <= 0 ; j = j.add(step))
        {
            if (n.remainder(j.add(BigInteger.ONE)).equals(BigInteger.ZERO))
                return false;

            for (BigInteger rp : relativePrimes)
                if (n.remainder(j.add(rp)).equals(BigInteger.ZERO))
                    return false;
        }

        return true;
    }


}
