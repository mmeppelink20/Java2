package assignments.challengeone;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Book implements Comparable<Book> {
    private String title;
    private Person author;
    private int numPages;
    private boolean read;
    public static final String DEFAULT_TITLE = "Undefined";
    private static int bookCount = 0;
    private LocalDate datePublished;




    private double unitPrice;
    public Book() {
        title = DEFAULT_TITLE;
        author = new Person();
        numPages = 1;
        read = false;
        bookCount++;
        datePublished = LocalDate.now();
        unitPrice = 1.00;
    }

    public Book(String title, Person author, int numPages, boolean read, LocalDate datePublished, double unitPrice) {
        setTitle(title);
        setAuthor(author);
        setNumPages(numPages);
        this.read = read;
        bookCount++;
        setDatePublished(datePublished);
        setUnitPrice(unitPrice);
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals("")) {
            throw new IllegalArgumentException("The title is required.");
        } else {
            this.title = title;
        }
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        if (author == null) {
            throw new IllegalArgumentException("The author is required.");
        } else {
            this.author = author;
        }
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        if (numPages < 1) {
            throw new IllegalArgumentException("There must be at least one page.");
        }
        this.numPages = numPages;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", read=" + read +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        int result = (this.numPages - o.numPages) * -1;
        if(result == 0) { // if the books have the same number of pages
            this.title.compareTo(o.title);
        }
        return result;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        if(datePublished.isAfter(LocalDate.now())){
            throw new DateTimeException("publication date can not be in the future.");
        }
        this.datePublished = datePublished;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) {
            throw new IllegalArgumentException("unit price can not be less than 0");
        }
        this.unitPrice = unitPrice;
    }
}


