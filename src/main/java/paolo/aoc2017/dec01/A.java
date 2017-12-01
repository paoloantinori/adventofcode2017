package paolo.aoc2017.dec01;

import java.awt.Desktop.Action;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */ 
public class A 
{
    public static void main( String[] args )
    {
        try {
            String str = Files.lines(Paths.get("/data/repositories/adventofcode2017/java/src/main/java/resources/01/a.txt")).findFirst().get();
            System.out.println(str);
            int tot = IntStream.range(0, str.length() )
                .mapToObj(i -> {
                    if(i == str.length() -1){
                        return ""+str.charAt(str.length()-1) + str.charAt(0);
                    }else {
                        return str.substring(i, i+2);
                    }
                })
                .mapToInt(s -> s.charAt(0)==s.charAt(1)? Integer.valueOf(s.substring(0,1)) : 0)
                .peek(System.out::println)
                //.reduce(0, (a,b)-> a+b);
                .sum();
            System.out.println(tot);
        } catch (Exception e){
            System.out.println("wrong file?");
            e.printStackTrace();;
        }
        
    }
}
