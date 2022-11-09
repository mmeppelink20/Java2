package final_project.data_handlers;

import assignments.assignmenttwo.Person;
import final_project.MyException;
import final_project.UIUtility;
import final_project.data_access.MyDAO;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DeletePerson implements MyDataHandler {
    @Override
    public void handleTask(MyDAO data_source, Scanner scanner, ResourceBundle messages) throws MyException {
        List<Person> list = data_source.getAll();
        int choice = 0;
        while (true) {
            String menuTitle = "Delete person";
            String prompt = "Select a person to delete";
            String[] menuOptions = new String[list.size()];
            for (int i = 0; i < menuOptions.length; i++) {
                menuOptions[i] = list.get(i).getFirstName() + " " + list.get(i).getLastName();
            }
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            if (choice == menuOptions.length + 1) {
                break;
            }
            Person person = list.get(choice - 1);
            if(data_source.remove(person)) {
                System.out.println("Person deleted");
            } else {
                System.out.println("Person not deleted");
            }
            data_source.remove(person);
            break;
        }
    }
}

