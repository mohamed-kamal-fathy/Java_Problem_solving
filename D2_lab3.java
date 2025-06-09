package src.Main;

import java.util.Scanner;

public class D2_lab3
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of pyramid: ");
        int size = input.nextInt();

        for (int i = 0; i < size; i++)
        {

            for (int j = 0; j < size - i - 1; j++)
            {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++)
            {
                System.out.print("*");
            }

            System.out.println();
        }

        input.close();
    }
}
