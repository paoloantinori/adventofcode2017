package paolo.aoc2017.dec05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class A {

    public static void main(String[] args){
        try{
            List<Integer> list = new ArrayList<>();;
        Files.readAllLines(Paths.get("/data/repositories/adventofcode2017/src/main/java/resources/05/a.txt"))
        .stream()
        .forEach(s->list.add(Integer.valueOf(s)));

        int counter = 0;
        int result = 0;
        while(counter < list.size()){
            int oldIdx = counter;
            int oldVal = list.get(counter);
            counter = counter + oldVal;
            list.set(oldIdx, oldVal+1);
            result++ ;
        }
        System.out.println("Result: " + result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}