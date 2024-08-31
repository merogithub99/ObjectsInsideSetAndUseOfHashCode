package pcom.service;

import pcom.model.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    void deletePatient(int id);
    List<Patient> getAllPatient();

}
