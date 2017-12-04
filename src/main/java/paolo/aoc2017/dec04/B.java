package   paolo.aoc2017.dec04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;

public class B {

    public static void main(String[] args){
        try{
        int sum = Files.readAllLines(Paths.get("/data/repositories/adventofcode2017/src/main/java/resources/04/a.txt"))
        .stream()
        .mapToInt( line -> {
            List list = Stream.of(line.split(" "))
            .map(word -> {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                return String.valueOf(chars);
            })
            .collect(Collectors.toList());
            Set set = new HashSet(list);
            
            return list.size() == set.size() ? 1 : 0;
        }).sum();
        System.out.println("sum: " + sum);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}