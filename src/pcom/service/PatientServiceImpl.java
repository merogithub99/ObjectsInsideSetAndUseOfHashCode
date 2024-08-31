package pcom.service;

import pcom.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientServiceImpl implements PatientService {
    static List<Patient> patientList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addPatient(Patient patient) {

        patientList.add(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientList.remove(id);

    }

    @Override
    public List<Patient> getAllPatient() {
        return  patientList;
    }
}
