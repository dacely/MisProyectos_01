package com.combinatorics.exp02;

public class StudentsAndDoors
{
    public static void main(String[] args)
    {
        int[] rooms = new int[5];
        boolean[] door = new boolean[5]; // false = close
        boolean endGame = false;

        for (int student = 0; student < 35; student++)
        {
            for (int i = 0; i < 5; i++)
            {
                if (door[i])
                {
                    door[i] = false;
                    if (i == 4)
                    {
                        endGame = true;
                    }
                }
                else
                {
                    door[i] = true;
                    rooms[i]++;
                    break;
                }
            }

            System.out.println("Student # " + (student + 1));
            System.out.println("===================================================");

            System.out.print("Num  ");
            for (int i = 0; i < 5; i++)
                System.out.printf("|%3d", rooms[i]);
            System.out.println("|");

            System.out.print("Door ");
            for (int i = 0; i < 5; i++)
                System.out.print(door[i] ? "|   " : "|***");
            System.out.println("|");
            System.out.println();

            if (endGame)
            {
                System.out.printf("All doors were open, student %d" +
                        "\nclose them and leaves first!!!\n", student + 1);
                break;
            }
        }
    }
}
