import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamIntermediateOperationsExample {
    public static void main(String[] args) {
        
String str = "hello world java";
      
      
String[] strArr = str.split("\\s+");
      
List<String> list = Arrays.asList(strArr);
      
System.out.println(list);   
System.out.println(new StringBuffer(str).reverse());
      
String reverse = 
  Arrays.stream(str.split("\\s+"))
        .map(s -> new StringBuffer(s).reverse())
        .collect(
                  Collectors.joining(" each_", "each_", ""));

      System.out.println(reverse);
    }
}
