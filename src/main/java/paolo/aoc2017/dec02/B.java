package paolo.aoc2017.dec02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class B {

    public static void main(String[] args){
        List<String> lines = null;
        try{
            lines = Files.readAllLines(Paths.get("/data/repositories/adventofcode2017/src/main/java/resources/02/a.txt"));
            System.out.println("Input Loaded!");
            int sum = lines.stream()
                .mapToInt( line -> {
                    String[] arr = line.split("\\s");
                    return IntStream.range(0, arr.length)
                        .mapToObj(i -> {
                            return IntStream.range(0, arr.length)
                            .filter(j -> j != i)
                            .mapToObj(j -> {
                                return new int[]{i, j};
                            }); //return stream of array
                        })//return stream of stream of array
                        .flatMap(st -> {
                            return st.map(a -> new int[]{Integer.parseInt(arr[a[0]]), Integer.parseInt(arr[a[1]])})
                            .filter(a -> (a[0] % a[1])==0)
                            .peek(a -> System.out.println("kept only: [" + a[0] + ", " + a[1] + "]"))
                            .map(a -> a[0] / a[1]);
                        })
                        .mapToInt(x->x.intValue())
                        .peek(s->System.out.println("Dvision result: " + s))
                        .findAny().getAsInt()
                        ;
  

                    })
                    .peek(s->System.out.println("is this needed? " + s))
                .sum();
            System.out.println("sum: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}