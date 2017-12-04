package paolo.aoc2017.dec03;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;

public class A {
    static final int OFFSET =1000;
    static int counter = 2;
    static int[] arr = new int[]{1,0};
    static int curSquare = 3;
    public static void main(String[] args){
        List<String> st = null;
        try{
            st = Files.readAllLines(Paths.get("/data/repositories/adventofcode2017/src/main/java/resources/03/a.txt"));
            int input = Integer.parseInt(st.get(0));
            System.out.println(input);
            int target = input;
            while( counter < target){
                up(target);
                left(target);
                down(target);
                right(target);
                nextSquare();
            }

    System.out.println("output: " + (Math.abs(arr[0]) + Math.abs(arr[1])));
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
     }

    static int nextSquare(){
        curSquare = curSquare + 2;
        return curSquare;
    }
    static void up(int i) {
        
        while(counter < i && arr[1] < curSquare/2){
            System.out.println("up");
            arr[1] = arr[1] + 1;
            incrementCounter();
            System.out.println("counter: " + counter);
            System.out.println("Arr: " + arr[0] + " : " + arr[1]);
        }
    }

    static void left(int i) {
        
        int localCounter = 0;
        while(counter < i && localCounter < curSquare-1){
            System.out.println("left");
            // System.out.println("local counter: " + localCounter);
            // System.out.println("cur square: " + curSquare);
            arr[0] = arr[0] - 1;
            incrementCounter();
            localCounter++;
            System.out.println("counter: " + counter);
            System.out.println("Arr: " + arr[0] + " : " + arr[1]);
        }
    }

    static void down(int i) {
        
        int localCounter = 0;
        while(counter < i && localCounter < curSquare-1){
            System.out.println("down");
            // System.out.println("local counter: " + localCounter);
            // System.out.println("cur square: " + curSquare);
            arr[1] = arr[1] - 1;
            incrementCounter();
            localCounter++;
            System.out.println("counter: " + counter);
            System.out.println("Arr: " + arr[0] + " : " + arr[1]);
        }
    }

    static void right(int i) {
        
        int localCounter = 0;
        while(counter < i && localCounter < curSquare){
            System.out.println("right");
            // System.out.println("local counter: " + localCounter);
            // System.out.println("cur square: " + curSquare);
            arr[0] = arr[0] + 1;
            incrementCounter();
            localCounter++;
            System.out.println("counter: " + counter);
            System.out.println("Arr: " + arr[0] + " : " + arr[1]);
        }
    }

    static void incrementCounter(){
        counter++;
    }
              
    //  - parto da 2, alla posizione (1,0)
    //  lato =3
    //  su = floor(lato/2)
    //  muovo su
    //  sx = lato -1
    //  giu = lato -1
    //  dx = lato
     

}