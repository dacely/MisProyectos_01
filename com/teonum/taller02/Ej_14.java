package com.teonum.taller02;

public class Ej_14
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 216; i++)
        {
            if (lcm(i, 216 - i) == 480)
            {
                System.out.println(new UnorderedPair(i, 216 - i));
            }
        }
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
