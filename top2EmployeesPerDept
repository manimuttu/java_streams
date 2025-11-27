import java.util.*;
import java.util.stream.*;

class Employee {
    private Department dept;
    private Double salary;
   private String name;

    public Employee(String name, Department dept, Double salary) {
        this.dept = dept;
        this.salary = salary;
      this.name = name;
    }

    public Department getDept() { return dept; }
    public Double getSalary() { return salary; }
  	public String getName() { return name; }
  
	@Override
    public String toString() {
        return "Emp{name='" + name + "', salary=" + salary + "}";
    }
}

class Department {
    private String name;

    public Department(String name) { this.name = name; }
    public String getName() { return name; }
}

public class StreamCreation {
    public static void main(String[] args) {

        Department dev = new Department("Development");
        Department qa  = new Department("QA");

        List<Employee> employees = Arrays.asList(
                new Employee("dev1", dev, 50000.0),
                new Employee("dev2", dev, 60000.0),
                new Employee("dev3", dev, 70000.0),
          
          new Employee("qa1", qa, 45000.0),
          new Employee("qa2", qa, 65000.0),
          new Employee("qa3", qa, 55000.0)
        );

    // Top 2 Employees per Department (by salary)
Map<String, List<Employee>> top2EmployeesPerDept =
    employees.stream()
        .collect(Collectors.groupingBy(
            e -> e.getDept().getName(),                   // group by dept
            
Collectors.collectingAndThen(
                Collectors.toList(),                      // collect employees in each dept
                
                list -> list.stream()
                            .sorted(Comparator.comparing(Employee::getSalary)
                                             .reversed()) // high → low salary
                            .limit(2)
                            .toList()
            )
        ));
      
      
      System.out.println(top2EmployeesPerDept);
    }
}


//output - {QA=[Emp{name='qa2', salary=65000.0}, Emp{name='qa3', salary=55000.0}], Development=[Emp{name='dev3', salary=70000.0}, Emp{name='dev2', salary=60000.0}]}
