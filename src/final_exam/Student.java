package final_exam;

import assignments.assignmenttwo.Person;

public class Student extends Person /*implements Comparable<Student>*/{
    private String id;
    private double gpa;

    public Student() {
        id = "k0000000";
        gpa = 0;
    }

    public Student(String id, double gpa) {
        setGPA(gpa);
        setID(id);
    }

    public void setID(String id){
        if(id.equals("")){
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if(!(id.length() == 8)){
            throw new IllegalArgumentException("ID must be 8 character exactly");
        }
        if(id.indexOf(0) != 'k'){
            throw new IllegalArgumentException("ID must begin with the character \'K\'");
        }
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public void setGPA(double gpa){
        if(gpa < 0) {
            throw new IllegalArgumentException("GPA cannot be less than 0");
        }
        if(gpa > 4) {
            throw new IllegalArgumentException("GPA cannot be greater than 4");
        }
        this.id = id;
    }

    public double getGPA() {
        return gpa;
    }

    public String toString() {
        return this.getFirstName() + "\nStudent ID: " + this.getID() + "\nGPA: " + this.getGPA();
    }

//    @Override
//    public int compareTo(Student student) {
//        int result = this.gpa.compareTo(student.getGPA()); //couldn't figure out how to compare doubles :\
//        if(result == 0) {
//            result = this.gpa.compareTo(student.getGPA());
//        }
//        return result;
//    }
}
