import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class dupCount {
    public static void main(String[] args) {
      

//IntStream.of(1,2,3,4,4,5,6,6)
      Map<Integer, Long> dupCount = 
        List.of(1,2,3,4,4,5,6,6)
        .stream()
        .collect(Collectors.groupingBy(n -> n,
                 					   Collectors.counting()
                                      )
                );
      
      System.out.println(dupCount);

//output - {1=1, 2=1, 3=1, 4=2, 5=1, 6=2}
    }
}
