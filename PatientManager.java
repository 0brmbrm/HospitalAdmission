import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private static List<Patient> patients = new ArrayList<>();
    
    public PatientManager() {}
    
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getFirstName() + " " + patient.getSurname());
    }
    
    public List<Patient> getAllPatients() {
        return patients;
    }
    
    public Patient findPatientByName(String surname, String firstName) {
        for (Patient patient : patients) {
            if (patient.getSurname().equalsIgnoreCase(surname) && 
                patient.getFirstName().equalsIgnoreCase(firstName)) {
                return patient;
            }
        }
        return null;
    }
}

