package final_project;

import assignments.assignmenttwo.Person;
import final_project.data_access.MyDAO;
import final_project.data_access.MyDAOFactory;
import final_project.data_handlers.AddPerson;
import final_project.data_handlers.DeletePerson;
import final_project.data_handlers.GetPerson;
import final_project.data_handlers.UpdatePerson;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data_source = "csv"; // mysql
        MyDAO<Person> personDAO = MyDAOFactory.getMyDAO(data_source);
        if(personDAO == null) {
            System.out.println("Person data object not found");
            return;
        }
        try {
            personDAO.readInData();
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
                    messages.getString("add-person")
                    , messages.getString("get-person")
                    , messages.getString("update-person")
                    , messages.getString("delete-person")
                    , messages.getString("change-language")
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
                        new AddPerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 2:
                        new GetPerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 3:
                        new UpdatePerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 4:
                        new DeletePerson().handleTask(personDAO, scanner, messages);
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
