package com.teonum.ecprim;

import com.teonum.MyPrimes;

public class PrimeEquation
{
    public static void main(String[] args)
    {
        String header = "";
        header += formatDiv("a-----b-------------b----------c\n");
        header += formatRow("|  x  | x² - x + 41 | Is Prime |\n");
        header += formatDiv("d-----e-------------e----------f\n");
        System.out.print(header);

        for (int x = 2; x <= 41; x++)
        {
            int y = primeEquation(x);
            String str1 = String.format("| %3d | %11d | %8b |", x, y, MyPrimes.isPrime(y));
            System.out.println(formatRow(str1));
        }

        System.out.println(formatDiv("g-----h-------------h----------i"));
    }

    public static int primeEquation(int x)
    {
        return (x*x) - x + 41;
    }

    public static String formatRow(String str)
    {
        return str.replace('|', '\u2502');
    }

    public static String formatDiv(String str)
    {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
}
