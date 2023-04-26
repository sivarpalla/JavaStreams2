import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamTest {


    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1234, "John", "Smith", "Sales", 5000.00, 1));
        employees.add(new Employee(5678, "Jane", "Smith", "Marketing", 6000.00, 2));
        employees.add(new Employee(9012, "Bob", "Jones", "IT", 7000.00, 3));
        employees.add(new Employee(3456, "Mary", "Jones", "Finance", 8000.00, 1));
        employees.add(new Employee(7890, "Tom", "Wilson", "Marketing", 9000.00, 2));

        employees.stream().filter(employee -> employee.getEmployeeId()==1234).findFirst().ifPresent(e->System.out.println(e));
        //to print employee details based on dept
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()))
                .entrySet().forEach(e -> System.out.println(e.getKey() + "1*** " + e.getValue()));

        //count in each department
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()))
                .entrySet().forEach(e -> System.out.println(e.getKey() + "2*** " + e.getValue()));

        //2 groups division by Marketing and non marketing dept
        employees.stream().collect(Collectors.partitioningBy(emp -> emp.getDepartment().equalsIgnoreCase("Marketing")))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey() + "3*** " + e.getValue().size()));

        //Max/min salary
        System.out.println(
        employees.stream().max(Comparator.comparing(Employee::getSalary)).get());

        //Max salary for each dept
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + "5*** " + e.getValue()));

        //Other way for above
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))))
                .entrySet().forEach(e -> System.out.println(e.getKey() + "6*** " + e.getValue()));

        //sort
       List<Employee> sortedList= employees.stream().sorted((e1, e2)-> (int) (e2.getSalary()-e1.getSalary()))
               //.limit(3) //top 3 salaried
               .skip(3)//after 3rd higest salary
                .collect(Collectors.toList());
        System.out.println(sortedList);


        employees.stream().collect(Collectors.toMap(a->a.getEmployeeId(),a->a))
                .entrySet().forEach(a->System.out.println(a));

        //repeated lastnames
       List<String> lastnames= employees.stream().map(e->e.getLastName()).collect(Collectors.toList());
       Set<String> uniqueNames=new HashSet<>();
        lastnames.stream().filter(n-> !uniqueNames.add(n)).forEach(l->System.out.println("RepeatedNames:"+l));
        //another way
        lastnames.stream().filter(x->Collections.frequency(lastnames,x)>1).collect(Collectors.toSet()).stream().forEach(l->System.out.println("2RepeatedNames:"+l));
    }
}
