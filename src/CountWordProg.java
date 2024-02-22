

import java.io.*;
import java.util.*;

public class CountWordProg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[4];

        
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        scanner.close();

        
        Random random = new Random();
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            String randomName = names[random.nextInt(names.length)];
            content.append(randomName).append(System.lineSeparator());
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
            writer.write(content.toString());
            System.out.println("Input file created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating input file: " + e.getMessage());
        }

        
        Map<String, Integer> nameCount = new HashMap<>();
        try (Scanner fileScanner = new Scanner(new File("input.txt"))) {
            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }

        
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
                writer.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println("Name count is done and saved in output.txt file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error creating output file: " + e.getMessage());
        }
    }
}
