package setObjectHashcode;

public class Main {

    public static void main(String[] args) {
        SetOfEmployee setOfEmployee = new SetOfEmployee();
        SetOfDog setOfDog = new SetOfDog();
        setOfEmployee.addEmp();
        setOfDog.addDog();


        System.out.println("set of employees");
        setOfEmployee.printEmp();
        System.out.println("---------------------------------------");
        System.out.println("set of dogs");
        setOfDog.printDog();
    }
}
