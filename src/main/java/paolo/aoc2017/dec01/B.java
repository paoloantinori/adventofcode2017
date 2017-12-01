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
public class B
{
    public static void main( String[] args )
    {
        try {
            String str = Files.lines(Paths.get("/data/repositories/adventofcode2017/java/src/main/java/resources/01/a.txt")).findFirst().get();
            //String str = "1212";
            System.out.println(str);
            int tot = IntStream.range(0, str.length() )
                .mapToObj(i -> {
                    int offset = str.length() / 2;
                    if(i+offset >= str.length()){
                        return ""+str.charAt(i) + str.charAt(i+offset-str.length());
                    }else {
                        return "" + str.charAt(i) + str.charAt( i+offset);
                    }
                })
                .peek(System.out::println)
                .mapToInt(s -> s.charAt(0)==s.charAt(1)? Integer.valueOf(s.substring(0,1)) : 0)
                .sum();
            System.out.println("tot: " + tot);
        } catch (Exception e){
            System.out.println("wrong file?");
            e.printStackTrace();;
        }
        
    }
}
