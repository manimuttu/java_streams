import java.util.*;
import java.util.stream.*;

public class TopNPerDept {
static class Department { String name; Department(String n){name = n;} String getName(){return name;} }
static class Employee {
String name; Department dept; double salary;
Employee(String n, Department d, double s){name = n; dept = d; salary = s;}
Department getDept(){return dept;} double getSalary(){return salary;} String getName(){return name;}
public String toString(){ return "Emp{name='" + name + "', salary=" + salary + "}"; }
}

public static void main(String[] args) {
Department dev = new Department("Development");
Department qa = new Department("QA");

List < Employee > employees = Arrays.asList(
new Employee("dev1", dev, 50000.0),
new Employee("dev2", dev, 60000.0),
new Employee("dev3", dev, 70000.0),
new Employee("dev4", dev, 70000.0), // tie example
new Employee("qa1", qa, 45000.0),
new Employee("qa2", qa, 65000.0),
new Employee("qa3", qa, 55000.0)
);

int N = 2; // change for top-N
Map < String, List < Employee>> topNPerDept = employees.stream()
.collect(Collectors.groupingBy(e -> e.getDept().getName(),

Collectors.collectingAndThen(
        Collectors.toList(),
        list -> list.stream()
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .limit(2)
                    .collect(Collectors.toList())
                            )
            )
        );


System.out.println(topNPerDept);
// Example output: {QA=[Emp{name='qa2', salary=65000.0}, Emp{name='qa3', salary=55000.0}], Development=[Emp{name='dev3', salary=70000.0}, Emp{name='dev4', salary=70000.0}]}
}
}
