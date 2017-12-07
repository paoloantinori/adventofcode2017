package paolo.aoc2017.dec07;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.regex.*;

public class B {
    
    static Map<String,N> map = new HashMap<>();

    static N nFromLine(String s){
        N result;
        String root;
        String children = null;
        if(s.contains("->")){
            String[] split = s.split("->");
            root = split[0];
            children = split[1];
        } else {
            root = s;
        }

        String[] arrRoot = root.split("\\s");
        String id = arrRoot[0];
        String w = arrRoot[1];
        Pattern pattern = Pattern.compile("\\((.*)\\)");
        Matcher match = pattern.matcher(w);
        match.matches();
        w = match.group(1);

        result = new N(id,Integer.parseInt(w));

        return result;
    }

    static N nAddChildren(String s){
        
        String children = null;
        N rootNode = null;
        if(s.contains("->")){
            String[] split = s.split("->");
            String root = split[0];
            String[] arrRoot = root.split("\\s");
            String id = arrRoot[0];
            children = split[1];
            String[] arrChildren = children.split(",\\s?");
            
            rootNode = map.get(id);
            for(String child : arrChildren){
                N childNode = map.get(child.trim());
                rootNode.list.add(childNode);
            }
        } 
        return rootNode;
    }

    public static void main(String[] str){
        try{
            Files.readAllLines(Paths.get("src/main/resources/07/a.txt")).stream()
            .forEach( l ->{
                N n = nFromLine(l);
                map.put(n.id, n);
            });
            Files.readAllLines(Paths.get("src/main/resources/07/a.txt")).stream()
            .forEach( l ->{
                nAddChildren(l);
            });
            N root = map.values().stream().reduce(new N(), (acc, el) -> el.childrenNumber() > acc.childrenNumber()? el:acc);
            
            N node = root;
            N father = null;
            while(node.list.size() >0){
                father = node;
                if(node.subtreeW() < node.list.stream().mapToInt(N::subtreeW).sum()){
                    // look for the smallest
                    N next = node.list.stream().reduce(new N("", Integer.MAX_VALUE), (acc, el) -> el.subtreeW() < acc.subtreeW()?el:acc);
                    node = next;
                } else {
                    // look for the largest
                    N next = node.list.stream().reduce(new N("", Integer.MIN_VALUE), (acc, el) -> el.subtreeW() > acc.subtreeW()?el:acc);
                    node = next;
                }
                int sample = node.list.get(0).subtreeW();
                if(node.list.stream().allMatch(n->n.subtreeW()==sample))
                    break;
            }

            final N finalNode = node;
            N brother = father.list.stream().filter(n->!n.equals(finalNode)).findAny().get();
            int nodeSub = node.subtreeW();
            int broSub = brother.subtreeW();
            int result = node.w +  broSub - nodeSub;
            System.out.println("result: " +  result  );
            
        } catch(Exception e){
            e.printStackTrace();
        }
        



    }
}

class N{
    String id;
    int w;
    List<N> list = new ArrayList<>();

    public N(){}
    public N(String id, int w){ this.id=id;this.w=w;}

    public int childrenNumber(){
        return  list.size() + list.stream().mapToInt(n-> n.childrenNumber()).sum();
    }

    public int subtreeW(){
        return  w + list.stream().mapToInt(n-> n.subtreeW()).sum();
    }

    public String toString(){
        String base = String.format( "%s (%d)", id, w);
        if(list.size()>0)
            base += " -> " + list;
        return base;
    }

    @Override
    public boolean equals(Object o){
        return ((N)o).id.equals(this.id);
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}