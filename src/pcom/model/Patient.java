package pcom.model;

public class Patient {
    int id;
    String patientName;
    String contact;
    String address;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public Patient(int id, String patientName, String contact, String address, int age) {
        this.id = id;
        this.patientName = patientName;
        this.contact = contact;
        this.address = address;
        this.age = age;
    }

    public Patient() {
    }
}
