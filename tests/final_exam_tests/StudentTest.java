package final_exam_tests;

import assignments.challengeone.Book;
import assignments.challengeone.Person;
import final_exam.Student;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    void getIDTest() {
        Student student = new Student();
        assertEquals("k0000000", student.getID());
        student = new Student();
        assertThrows(IllegalArgumentException.class, () -> new Student("asdf", -1));
    }

    @Test
    void setIDTest() {
        Student student = new Student();
        assertThrows(IllegalArgumentException.class, () -> student.setID("asdf"));
    }

    @Test
    void getGPATest() {
        Student student = new Student();
        assertEquals(0, student.getGPA());
        student = new Student();
        assertEquals(0, student.getGPA());
        assertThrows(IllegalArgumentException.class, () -> new Student("asdf", -1));
    }

    @Test
    void setGPATest() {
        Student student = new Student();
        assertThrows(IllegalArgumentException.class, () -> student.setGPA(-2));
    }

    @Test
    void studentToStringTest() {
        Student student = new Student();
        student.setFirstName("yo");
        assertEquals("yo\nStudent ID: k0000000\nGPA: 0.0", student.toString());

    }


//    @Test
//    void getNumPagesTest() {
//        Book book = new Book();
//        assertEquals(1, book.getNumPages());
//        book = new Book("test", new Person(), 100, true, LocalDate.now(), 1);
//        assertEquals(100, book.getNumPages());
//        assertThrows(IllegalArgumentException.class, () -> new Book("test", new Person(), -1, true, LocalDate.now(), 1));
//    }

}
