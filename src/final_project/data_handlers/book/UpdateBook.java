package final_project.data_handlers.book;

import assignments.assignmenttwo.Person;
import final_project.Book;
import final_project.MyException;
import final_project.UIUtility;
import final_project.UserInput;
import final_project.data_access.MyDAO;
import final_project.data_handlers.MyDataHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UpdateBook implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Book> list = data_source.getAll();
        int choice = 0;
        while (true) {
            String menuTitle = "Update person";
            String prompt = "Select a person to update";
            String[] menuOptions = new String[list.size()];
            for (int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getTitle() + "By: " + list.get(i).getAuthor();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if (choice == menuOptions.length + 1) {
                break;
            }
            UIUtility.showSectionTitle("Updating " + menuOptions[choice - 1]);
            Book book = list.get(choice - 1);
            updateBook(data_source, book, choice - 1, scanner, messages);
            break;
        }
    }

    private void updateBook(MyDAO data_source, Book book, int choice, Scanner scanner, ResourceBundle messages) throws MyException {
        String keep = "(Press Enter to keep the current value)";
        System.out.println("Title: " + book.getTitle());
        for (; ; ) {
            try {
                String userIn = UserInput.getString("New title", scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setTitle(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Last name: " + book.getAuthor());
        for (; ; ) {
            try {
                String userIn = UserInput.getString("New Author", scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setAuthor(userIn);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }
        System.out.println("Number of Pages: " + book.getNumPages());
        for (; ; ) {
            try {
                String userIn = UserInput.getString("New Number of Pages", scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setNumPages(Integer.parseInt((userIn)));
                break;

            } catch (NumberFormatException e) {
                UIUtility.showErrorMessage("Invalid number", scanner, messages);
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }


        }
        System.out.println("Date of Publication: " + book.getDatePublished());
        for (; ; ) {
            try {
                String userIn = UserInput.getString("New date of birth", scanner);
                if (userIn.equals("")) {
                    break;
                }
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(userIn, formatterInput);
                book.setDatePublished(date);
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            } catch (DateTimeParseException e) {
                UIUtility.showErrorMessage("Invalid date", scanner, messages);
            }
        }
        System.out.println("Book Price: " + book.getUnitPrice());
        for (; ; ) {
            try {
                String userIn = UserInput.getString("New Price", scanner);
                if (userIn.equals("")) {
                    break;
                }
                book.setUnitPrice(Double.parseDouble(userIn));
                break;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        data_source.set(choice, book);
        UIUtility.showSectionTitle("Person updated");

    }

}
