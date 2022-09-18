package assignments.challengeone;

import assignments.assignmentintro.Version;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void getNumPagesTest() {
        Book book = new Book();
        assertEquals(1, book.getNumPages());
        book = new Book("test", new Person(), 100, true, LocalDate.now(), 1);
        assertEquals(100, book.getNumPages());
        assertThrows(IllegalArgumentException.class, () -> new Book("test", new Person(), -1, true, LocalDate.now(), 1));
    }

    @Test
    void setNumPagesTest(){
        Book book = new Book();
        book.setNumPages(5);
        assertEquals(5, book.getNumPages());
        assertThrows(IllegalArgumentException.class, () -> new Book("test", new Person(), -1, true, LocalDate.now(), 1));
    }

    @Test
    void getTitleTest(){
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> new Book("", new Person(), 1, true, LocalDate.now(), 1));
        assertThrows(NullPointerException.class, () -> new Book(null, new Person(), 1, true, LocalDate.now(), 1));
        book = new Book("test", new Person(), 1, true, LocalDate.now(), 1);
        assertEquals("test", book.getTitle());
    }

    @Test
    void setTitleTest(){
        Book book = new Book();
        assertEquals("Undefined", book.getTitle());
        book = new Book("test", new Person(), 1, true, LocalDate.now(), 1);
        assertEquals("test", book.getTitle());
        assertThrows(IllegalArgumentException.class, () -> new Book("", new Person(), 1, true, LocalDate.now(), 1));
    }

    @Test
    void getAuthorTest() {
        Book book = new Book("test", new Person(), 1, true, LocalDate.now(), 1);
        assertEquals("Person{firstName='John', lastName='Doe'}", book.getAuthor().toString());
    }

    @Test
    void setAuthor() {
        Book book = new Book("test", new Person("asdf", "fdsa"), 1, true, LocalDate.now(), 1);
        assertEquals("Person{firstName='asdf', lastName='fdsa'}", book.getAuthor().toString());
    }

    @Test
    void compareToTest() {
        Book book = new Book("test", new Person("asdf", "fdsa"), 100, true, LocalDate.now(), 1);
        Book book1 = new Book("test", new Person("asdf", "fdsa"), 101, true, LocalDate.now(), 1);
        assertTrue(book.compareTo(book1) > 0);

        book = new Book("test", new Person("asdf", "fdsa"), 100, true, LocalDate.now(), 1);
        book1 = new Book("test", new Person("asdf", "fdsa"), 100, true, LocalDate.now(), 1);
        assertTrue(book.compareTo(book1) == 0);

        book = new Book("test", new Person("asdf", "fdsa"), 101, true, LocalDate.now(), 1);
        book1 = new Book("test", new Person("asdf", "fdsa"), 100, true, LocalDate.now(), 1);
        assertTrue(book1.compareTo(book) > 0);
    }

    @Test
    void getDatePublishedTest() {
        Book book = new Book("test", new Person("asdf", "fdsa"), 100, true, LocalDate.now(), 1);
        assertEquals(LocalDate.now(), book.getDatePublished());

        book = new Book();
        assertEquals(LocalDate.now(), book.getDatePublished());
    }

    @Test
    void setDatePublishedTest() {
        Book book = new Book();
        assertThrows(DateTimeException.class, () -> book.setDatePublished(LocalDate.now().plusDays(5)));

        book.setDatePublished(LocalDate.now());
        assertEquals(LocalDate.now(), book.getDatePublished());

        book.setDatePublished(LocalDate.of(2002, 1, 9));
        assertEquals(LocalDate.of(2002, 1, 9), book.getDatePublished());
    }

    @Test
    void getUnitPrice() {
        Book book = new Book();
        assertEquals(1.0001, book.getUnitPrice(), 2);

        assertThrows(IllegalArgumentException.class, () -> new Book("", new Person(), 1, true, LocalDate.now(), -1));

        book = new Book("asdf", new Person(), 1, true, LocalDate.now(), 100.2142);
        assertEquals(100.2141234123, book.getUnitPrice(), 2);
    }

    @Test
    void setUnitPrice() {
        Book book = new Book();

        book = new Book();
        book.setUnitPrice(2.21341324);
        assertEquals(2.21, book.getUnitPrice(), 2);
    }






}