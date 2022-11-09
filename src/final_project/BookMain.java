package final_project;

import assignments.assignmenttwo.Person;
import final_project.data_access.MyDAO;
import final_project.data_access.MyDAOBookFactory;
import final_project.data_access.MyDAOFactory;
import final_project.data_handlers.book.AddBook;
import final_project.data_handlers.book.DeleteBook;
import final_project.data_handlers.book.GetBook;
import final_project.data_handlers.book.UpdateBook;

import java.util.ResourceBundle;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        String data_source = "csv";
        MyDAO<Book> bookDAO = MyDAOBookFactory.getMyDAO(data_source);
        if(bookDAO == null) {
            System.out.println("Book data object not found");
            return;
        }
        try {
            bookDAO.readInData();
        } catch(MyException e) {
            System.out.println(e.getMessage());
            return;
        }
        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(true) {
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    "Add a Book",
                    "Get a Book",
                    "Update a Book",
                    "Delete a Book"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if(choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle(menuOptions[choice - 1]);
            try {
                switch (choice) {
                    case 1:
                        new AddBook().handleTask(bookDAO, scanner, messages);
                        break;
                    case 2:
                        new GetBook().handleTask(bookDAO, scanner, messages);
                        break;
                    case 3:
                        new UpdateBook().handleTask(bookDAO, scanner, messages);
                        break;
                    case 4:
                        new DeleteBook().handleTask(bookDAO, scanner, messages);
                        break;
                    case 5:
                        language.setMessages(scanner);
                        messages = language.getMessages();
                        break;
                }
            } catch (MyException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end"));
        scanner.close();
    }
}
