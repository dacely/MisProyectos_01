package com.combinatorics.exp01;

import java.util.Arrays;

public class MyThreeDigitNumber
{
    private int n;

    public MyThreeDigitNumber(int n)
    {
        setNumber(n);
    }

    public void setNumber(int n)
    {
        if (n >= 0 && n <= 999)
            this.n = n;
        else
            this.n = 0;
    }

    public int getInt()
    {
        return n;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyThreeDigitNumber that = (MyThreeDigitNumber) o;
        String str1 = String.format("%03d", this.n);
        String str2 = String.format("%03d", that.n);
        return sameChars(str1, str2);
    }

    private boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}
