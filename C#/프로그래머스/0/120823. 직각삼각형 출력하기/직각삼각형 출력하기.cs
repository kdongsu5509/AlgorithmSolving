using System;

public class Example
{
    public static void Main()
    {
        int s; // Changed from String[] to int for the size of the pattern

        Console.Clear();
        s = int.Parse(Console.ReadLine()); // Corrected the parsing of integer input

        string pr = "*";
        for(int i = 0 ; i < s ; i++){
            Console.WriteLine(pr);
            pr += "*";
        }
    }
}
