package pcom.view;

import pcom.model.Patient;
import pcom.service.PatientService;
import pcom.service.PatientServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        addBtn();
        delBtn();
        getAllBtn();

    }

    static void addBtn() {
        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();
        PatientService patientService = new PatientServiceImpl();
        char flag = 'y';
        System.out.println("do you want to add the patient>?y/n");
        flag = scanner.nextLine().charAt(0);
        if(flag=='y'){
            do {
                System.out.println("Enter the id of patient");
                patient.setId(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Enter the name of patient");
                patient.setPatientName(scanner.nextLine());
                System.out.println("Enter the address of patient");
                patient.setAddress(scanner.nextLine());
                System.out.println("Enter the contact number of patient");
                patient.setContact(scanner.nextLine());
                System.out.println("Enter the age of the patient");
                patient.setAge(scanner.nextInt());
                patientService.addPatient(patient);
                System.out.println("added");
                System.out.println("do you want to add more?y/n");
                flag =scanner.next().charAt(0);
            } while (flag == 'y');
        }


    }

    static void delBtn() {
        PatientService patientService = new PatientServiceImpl();
        Scanner scanner = new Scanner(System.in);
        char flag='y';
        System.out.println("do you want to delete the patient");
        flag= scanner.nextLine().charAt(0);
       if (flag=='y'){
           System.out.println("Enter the id of the patient");
           patientService.deletePatient(scanner.nextInt());
       }

    }

    static void getAllBtn() {
        PatientService patientService = new PatientServiceImpl();
        Scanner scanner = new Scanner(System.in);
        List<Patient>  patientList= patientService.getAllPatient();
        System.out.println("patient list:");
        patientList.forEach((patient -> System.out.println(patient)));

    }
}
