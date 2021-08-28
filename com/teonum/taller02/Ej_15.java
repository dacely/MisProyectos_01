package com.teonum.taller02;

import java.util.ArrayList;

public class Ej_15
{
    public static void main(String[] args)
    {
        ArrayList<UnorderedPair> fittingList = new ArrayList<>();

        for (int i = 24; i <= 1440; i++)
            for (int j = 24; j <= 1440; j++)
                if (gcd(i, j) == 24 && lcm(i, j) == 1440)
                {
                    UnorderedPair pair = new UnorderedPair(i, j);
                    if (!fittingList.contains(pair))
                        fittingList.add(pair);
                }

        for (UnorderedPair pair : fittingList)
            System.out.println(pair);
    }

    private static int gcd(int a, int b)
    {
        // if b=0, a is the GCD
        if (b == 0)
            return a;

            // call the gcd() method recursively by
            // replacing a with b and b with
            // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }

    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }
}
