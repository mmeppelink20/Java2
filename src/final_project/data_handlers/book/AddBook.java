package final_project.data_handlers.book;


import assignments.challengeone.Person;
import final_project.Book;
import final_project.MyException;
import final_project.UIUtility;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import final_project.data_handlers.MyDataHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddBook implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        Book book = new Book();
        // book id
        for(;;) {
            try {
                int userIn = UserInput.getInt("Enter the Book ID", scanner, messages);
                book.setId(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // book title
        for(;;) {
            try {
                String userIn = UserInput.getString("Enter Book Title", scanner);
                book.setTitle(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        // author name
        for(;;) {
            try {
                String userIn = UserInput.getString("Enter the Author's First and Last Name", scanner);
                book.setAuthor(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // book page count
        for(;;) {
            try {
                int userIn = UserInput.getInt("Enter the Number of Pages", scanner, messages);
                book.setNumPages(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // book publication date
        for(;;) {
            try {
                LocalDate userIn = LocalDate.from(UserInput.getDate("Enter the Publication Date", scanner, messages));
                book.setDatePublished(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        // book unit price
        for(;;) {
            try {
                double userIn = UserInput.getDouble("Enter the Book Price", scanner, messages);
                book.setUnitPrice(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        data_source.add(book);
        UIUtility.showSectionTitle("Book Added");

    }
}
