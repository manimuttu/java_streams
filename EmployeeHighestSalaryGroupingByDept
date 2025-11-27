import java.util.*;
import java.util.stream.*;

class Employee {
    private Department dept;
    private Double salary;

    public Employee(Department dept, Double salary) {
        this.dept = dept;
        this.salary = salary;
    }

    public Department getDept() { return dept; }
    public Double getSalary() { return salary; }
}

class Department {
    private String name;

    public Department(String name) { this.name = name; }
    public String getName() { return name; }
}

public class EmployeeHighestSalaryGroupingByDept {
    public static void main(String[] args) {

        Department dev = new Department("Development");
        Department qa  = new Department("QA");

        List<Employee> employees = Arrays.asList(
                new Employee(dev, 50000.0),
                new Employee(qa, 45000.0),
                new Employee(dev, 70000.0)
        );
//===========================================================================
        // Optional<Double> in map value
      Map<String, Optional<Double>>  map = employees.stream()
        .collect(Collectors.groupingBy(
          e -> e.getDept().getName(),
          
          //Collectors.collectingAndThen(
          	Collectors.mapping(e -> e.getSalary(),
	          	Collectors.maxBy(Double::compare)
                               )
          //, Optional::get)
          
        ));
//output - {QA=Optional[45000.0], Development=Optional[70000.0]}
//===========================================================================

        // Double in map value
      Map<String, Double>  map = employees.stream()
        .collect(Collectors.groupingBy(
          e -> e.getDept().getName(),
          
          Collectors.collectingAndThen(
          	
                                Collectors.mapping(e -> e.getSalary(),
                    	          	                    Collectors.maxBy(Double::compare)
                                                   )
          , Optional::get)
          
        ));
// output - {QA=45000.0, Development=70000.0}
//===========================================================================
// Optional<Employee> in map value
      Map<String, List<Employee>>  map = employees.stream()
        .collect(Collectors.groupingBy(
          e -> e.getDept().getName()
        ));
//output - {QA=[Employee@4e0e2f2a], Development=[Employee@73d16e93, Employee@659e0bfd]}
//===========================================================================
// using reducing method
      Map<String, Double>  map = employees.stream()
        .collect(Collectors.groupingBy(
          e -> e.getDept().getName(),
          Collectors.reducing(0.0, Employee::getSalary, Double::max)
         // Collectors.collectingAndThen(
          	
           // Collectors.mapping(e -> e.getSalary(),
	        //  	Collectors.maxBy(Double::compare)
            //                   )
         // , Optional::get)
          
        ));
//output - {QA=45000.0, Development=70000.0}
//===========================================================================
//using maxBy and Comparator.comparing
      Map<String, Optional<Employee>>  map = employees.stream()
        .collect(Collectors.groupingBy(
          e -> e.getDept().getName(),
          //Collectors.reducing(0.0, Employee::getSalary, Double::max)
         // Collectors.collectingAndThen(
          	
           // Collectors.mapping(e -> e.getSalary(),
	        //  	Collectors.maxBy(Double::compare)
            //                   )
         // , Optional::get)
          
          Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ));
//output - {QA=Optional[Employee@232204a1], Development=Optional[Employee@4aa298b7]}

//===========================================================================
// error message to look for
//    equality constraints: Double
  //  lower bounds: Employee,T#2
//  where T#1,T#2,K,A,D are type-variables:

// see this is the error message when we try to put 
// Double in map like  Map<String, Optional<Double>>,  instead of Map<String, Optional<Employee>>,

//===========================================================================

      System.out.println(map);
    }
}
