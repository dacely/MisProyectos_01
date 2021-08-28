package com.combinatorics.exp01;

import java.util.ArrayList;

public class UnorderedWithReplacement
{
    public static void main(String[] args)
    {
        ArrayList<MyThreeDigitNumber> myList = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
        {
            MyThreeDigitNumber temp = new MyThreeDigitNumber(i);
            if (!myList.contains(temp))
            {
                myList.add(temp);

                System.out.printf("  %03d", temp.getInt());

                if (myList.size() % 20 == 0)
                    System.out.println();
            }
        }

        System.out.println("\nTotal numbers: ");
        System.out.println(myList.size());
    }
}
