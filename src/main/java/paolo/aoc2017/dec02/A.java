package paolo.aoc2017.dec02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    public static void main(String[] args){
        List<String> lines = null;
        try{
            lines = Files.readAllLines(Paths.get("/data/repositories/adventofcode2017/src/main/java/resources/02/a.txt"));
            System.out.println("Input Loaded!");
            int sum = lines.stream()
                .mapToInt( line -> {
                    String[] arr = line.split("\\s");
                    int min = Arrays
                    .stream(arr)
                    .peek(System.out::println)
                    .mapToInt(Integer::valueOf)
                    .min().getAsInt();

                    int max = Arrays
                    .stream(arr)
                    .peek(System.out::println)
                    .mapToInt(Integer::valueOf)
                    .max().getAsInt();
                    return max - min;
                    })
                .sum();
            System.out.println("sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}