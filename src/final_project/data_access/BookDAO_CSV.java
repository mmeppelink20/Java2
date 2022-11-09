package final_project.data_access;

import assignments.assignmenttwo.Person;
import final_project.Book;
import final_project.MyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO_CSV implements MyDAO<Book> {

    private static final String FILE_NAME = "src/main/resources/csv_files/book.csv";

    private List<Book> list;

    @Override
    public void readInData() throws MyException {
        try(Scanner scanner = new Scanner(new File(FILE_NAME))) {
            list = new ArrayList<Book>();
            String line = "";
            int lineCount = 1;
            String[] fields;
            int id;
            String title;
            String author;
            int numPages;
            LocalDate datePublished;
            double unitPrice;
            line = scanner.nextLine(); // reads in header row
            while(scanner.hasNextLine()) {
                lineCount++;
                line = scanner.nextLine();
                fields = line.split(",");
                try {
                    id = Integer.parseInt(fields[0]);
                    title = fields[1];
                    author = fields[2];
                    numPages = Integer.parseInt(fields[3]);
                    datePublished = LocalDate.parse(fields[4]);
                    unitPrice = Double.parseDouble(fields[5]);

                } catch(NumberFormatException e) {
                    throw new MyException("Number error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                } catch(DateTimeParseException e) {
                    throw new MyException("Date error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                }
                Book book = new Book();
                for(Book b : list) {
                    if(b.getId() == id) {
                        throw new MyException("Duplicate id error occurred on line " + lineCount + " in file '" + FILE_NAME + "'.");
                    }
                }
                book.setId(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setNumPages(numPages);
                book.setDatePublished(datePublished);
                book.setUnitPrice(unitPrice);
                list.add(book);
            }

        } catch(FileNotFoundException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }

    }

    @Override
    public void add(Book obj) throws MyException {
        list.add(obj);
        saveToFile();
    }

    private void saveToFile() throws MyException{
        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            String line = "title,author,numPages,datePublished,unitPrice";
            writer.write(line + "\n");
            for(Book book: list) {
                line =  book.getId() + ","
                        + book.getTitle() + ","
                        + book.getAuthor() + ","
                        + book.getNumPages() + ","
                        + book.getDatePublished() + ","
                        + book.getUnitPrice();
                writer.write(line + "\n");
            }
        } catch(IOException e) {
            throw new MyException("File '" + FILE_NAME + "' not found");
        }
    }

    @Override
    public Book get(int id) throws MyException {
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                if(id == Integer.parseInt(fields[0])) {
                    Book book = new Book();
                    book.setId(id);
                    book.setTitle(fields[1]);
                    book.setAuthor(fields[2]);
                    book.setNumPages(Integer.parseInt(fields[3]));
                    book.setDatePublished(LocalDate.parse(fields[4]));
                    book.setUnitPrice(Double.parseDouble(fields[5]));
                    return book;
                }
            }
        } catch(FileNotFoundException e){

        }
        return null;
    }

    @Override
    public List<Book> get(String str) throws MyException {
        List<Book> result = new ArrayList<>();
        try(Scanner in = new Scanner(new File(FILE_NAME))){
            String line = in.nextLine();
            while(in.hasNextLine()){
                line = in.nextLine();
                String[] fields = line.split(",");
                String bookName = fields[1].toLowerCase();
                String authorName = fields[2].toLowerCase();
                if(bookName.contains(str.toLowerCase()) || authorName.contains(str.toLowerCase())) {
                    Book book = new Book();
                    book.setId(Integer.parseInt(fields[0]));
                    book.setTitle(fields[1]);
                    book.setAuthor(fields[2]);
                    book.setNumPages(Integer.parseInt(fields[3]));
                    book.setDatePublished(LocalDate.parse(fields[4]));
                    book.setUnitPrice(Double.parseDouble(fields[5]));
                    result.add(book);
                }
            }
        } catch(FileNotFoundException e){

        }
        return result;
    }

    @Override
    public List<Book> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Book> getAll() throws MyException {
        verifyData();
        return list;
    }

    @Override
    public void verifyData() throws MyException {
        if(list == null){
            readInData();
        }
    }

    @Override
    public void set(int id, Book obj) throws MyException {
        list.set(id, obj);
        saveToFile();
    }

    @Override
    public boolean remove(Book obj) throws MyException {
        boolean result = list.remove(obj);
        saveToFile();
        return result;
    }
}
