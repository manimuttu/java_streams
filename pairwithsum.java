import java.util.*;
import java.util.stream.*;


public class pairwithsum {
    
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        // List<List<Integer>> output = list
        // .stream()
        // .flatMap(n -> list.stream()
        //                     .filter(m -> (n + m) == 10 && n < m)
        //                     .map(m -> List.of(n,m)))
        // .collect(Collectors.toList());
        
        // System.out.println(output);
        
        
        List<List<Integer>> output = list.stream()
        .flatMap(n -> list
                    .stream()
                    .filter(m -> n<m && n+m == 10)
                    .map(m -> List.of(n,m)))
        .collect(Collectors.toList());
        
                System.out.println(output);
        
        // output -- [[1, 9], [2, 8], [3, 7], [4, 6]]
    }
}
