package final_project.data_handlers.book;

import assignments.assignmenttwo.Person;
import final_project.Book;
import final_project.MyException;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import final_project.data_handlers.MyDataHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GetBook implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        String userIn = UserInput.getString("Search for a book by its ID, name, or its author", scanner);
        try {
            // Search by id
            int id = Integer.parseInt(userIn);
            Book book = (Book)data_source.get(id);
            if(book == null) {
                System.out.println("No person found with id '" + id + "'.");
            } else {
                System.out.println("\nRetrieved:");
                System.out.println(book);
            }
        } catch (NumberFormatException e2) {
            // Search by name
            List<Book> list = (List<Book>) data_source.get(userIn);
            if (list.size() == 0) {
                System.out.println("No book found with name containing '" + userIn + "'.");
            } else {
                System.out.println("Retrieved:");
                for (Book book : list) {
                    System.out.println(book);
                }
            }
        }
    }
}

