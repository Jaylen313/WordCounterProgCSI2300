

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CountWordProg 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(inputFile)) 
        {
            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine().toLowerCase().trim();
                if (!line.isEmpty()) 
                { 
                    wordCount.put(line, wordCount.getOrDefault(line, 0) + 1);
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(outputFile)) 
        {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) 
            {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
        }
        System.out.println("Word count is done and saved in output.txt file.");
    }
}
