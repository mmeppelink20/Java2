package final_project.data_handlers.book;

import assignments.assignmenttwo.Person;
import final_project.Book;
import final_project.MyException;
import final_project.UIUtility;
import final_project.data_access.MyDAO;
import final_project.data_handlers.MyDataHandler;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DeleteBook implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Book> list = data_source.getAll();
        int choice = 0;
        while (true) {
            String menuTitle = "Delete book";
            String prompt = "Select a book to delete";
            String[] menuOptions = new String[list.size()];
            for (int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getTitle() + " " + list.get(i).getAuthor();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if (choice == menuOptions.length + 1) {
                break;
            }
            Book book = list.get(choice - 1);
            if(data_source.remove(book)) {
                System.out.println("Book deleted");
            } else {
                System.out.println("Book not deleted");
            }
            data_source.remove(book);
            break;
        }
    }
}
