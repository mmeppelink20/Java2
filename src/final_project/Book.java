package final_project;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String authorName;
    private int numPages;
    public static final String DEFAULT_TITLE = "Undefined";
    private static int bookCount = 0;
    private LocalDate datePublished;




    private double unitPrice;
    public Book() {
        id = 000000000;
        title = DEFAULT_TITLE;
        numPages = 1;
        bookCount++;
        datePublished = LocalDate.now();
        unitPrice = 1.00;
    }

    public Book(int id, String title, String authorName, int numPages, LocalDate datePublished, double unitPrice) {
        setId(id);
        setTitle(title);
        setAuthor(authorName);
        setNumPages(numPages);
        bookCount++;
        setDatePublished(datePublished);
        setUnitPrice(unitPrice);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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



    public void setAuthor(String authorName) {
        if (authorName == null) {
            throw new IllegalArgumentException("The author is required.");
        } else {
            this.authorName = authorName;
        }
    }

    public String getAuthor() {
        return authorName;
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



    @Override
    public String toString() {
        return "\nTitle: " + title + "\nAuthor: " + authorName + "\nPage Count: " + numPages + "\n";
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


