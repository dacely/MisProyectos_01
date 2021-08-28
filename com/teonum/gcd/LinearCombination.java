package com.teonum.gcd;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearCombination
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two positive integers: ");
        long n1 = input.nextLong();
        long n2 = input.nextLong();
        long a = Math.max(n1, n2);
        long b = Math.min(n1, n2);

        ArrayList<long[]> ea = new ArrayList<>(); // Euclidean Algorithm
        ArrayList<long[]> lc = new ArrayList<>(); // Linear Combinations

        long[] eq1;
        long[] eq2;

        do
        {
            eq1 = new long[4];
            eq1[0] = a;
            eq1[1] = b;
            eq1[2] = a / b;
            eq1[3] = a % b;
            ea.add(eq1);
            a = b;
            b = eq1[3];
        } while (b != 0);

        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("Euclidean Algorithm: \n");
        for (long[] eq: ea)
        {
            printEquation1(eq);
            System.out.println();
        }
        System.out.printf("\nGCD(%d, %d) = %d\n", n1, n2, a);

        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("GCD as a linear combination: \n");


        for (int i = ea.size() - 2; i >= 0; i--)
        {
            eq1 = ea.get(i);
            eq2 = new long[5];
            eq2[0] = eq1[3];
            eq2[1] = eq1[0];
            eq2[2] = 1;
            eq2[3] = eq1[1];
            eq2[4] = -eq1[2];
            lc.add(eq2);
        }

        printEquation2(lc.get(0));
        System.out.println();
        for (int i = 1; i < lc.size(); i++)
        {
            long[] prev = lc.get(i - 1);
            long[] curr = lc.get(i);
            curr[0] = prev[0];
            curr[2] *= prev[4];
            curr[4] *= prev[4];
            curr[4] += prev[2];
            printEquation2(curr);
            System.out.println();
        }

        input.nextLine();
        input.nextLine();
    }

    public static void printEquation1(long[] eq)
    {
        System.out.printf("%d = %d (%d) + %d", eq[0], eq[1], eq[2], eq[3]);
    }

    public static void printEquation2(long[] eq)
    {
        System.out.printf("%d = %d (%d) + %d (%d)", eq[0], eq[1], eq[2], eq[3], eq[4]);
    }
}
