package   paolo.aoc2017.dec06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class A {

    public static void main(String[] args){
        try{
        Files.readAllLines(Paths.get("/data/repositories/github/personal/adventofcode2017/src/main/java/resources/06/a.txt"))
        .stream()
        .forEach( line -> {
            Set<String> set = new HashSet<>();
            String[] a= line.split("\\s+");
            int[] arr = new int[a.length];
            IntStream.range(0, a.length).forEach(x->arr[x] = Integer.parseInt(a[x])); 
            System.out.println(str(arr));
            int counter = 0;
            while(!set.contains(str(arr))){
                set.add(str(arr));
                counter++;
                Function<Integer, IntStream> shiftedIntStreamFunction = (Integer i) -> IntStream.iterate(i, f -> f+1==arr.length?0:f+1);
                
                int max = IntStream.range(0, arr.length).reduce(0, (acc, el)->  arr[el]>arr[acc]?el:acc);

                System.out.println("max: " + arr[max] );
                shiftedIntStreamFunction.apply(max).limit(arr[max]+1 ).forEach(x-> {
                    arr[max] = arr[max]-1;
                    arr[x] = arr[x] +1;
                });
                System.out.println("End of step: " + str(arr));
                    

                
            }
            System.out.println("counter? "+ counter);

            
        });
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    static String str(int[] arr){
        return Arrays.stream(arr).mapToObj(String::valueOf).reduce("", (acc, x)->acc+x);
    }
}