package setObjectHashcode;

import java.util.HashSet;
import java.util.Set;

public class SetOfEmployee {
     static Set<Employee> employeeSet= new HashSet<>();
   public void addEmp(){

        Employee employee1= new Employee("ram",25);
        Employee employee2= new Employee("shyam",29);
        Employee employee3= new Employee("hari",22);
        Employee employee4= new Employee("ram",25);

        employeeSet.add(employee1);
        employeeSet.add(employee2);
        employeeSet.add(employee3);
        employeeSet.add(employee4);
    }

    public void printEmp(){
        for(Employee empSet: employeeSet){
             System.out.println(empSet);
        }
   }
}
