package final_exam;

import final_project.Language;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        System.out.println(messages.getString("usa"));

        messages = ResourceBundle.getBundle("messages_fr");
        System.out.println(messages.getString("usa"));

        messages = ResourceBundle.getBundle("messages_de");
        System.out.println(messages.getString("usa"));

        ParkingSpace<Car> parkingSpace1 = new ParkingSpace<>();
        ParkingSpace<Motorcycle> parkingSpace2 = new ParkingSpace<>();
        // ParkingSpace<Book> parkingSpace3 = new ParkingSpace<>();
    }
}
