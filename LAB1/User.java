import java.util.Scanner;

public class User {
    private int ID;
    public static String name;
    public static String surname;
    public static String Phone_number;

    public static void Data_user(Scanner sc , String formattedDateTime) {
        System.out.println("Ваше ім'я: ");
        User.name = sc.next();
        System.out.println("Ваше прізвище: ");
        User.surname = sc.next();
        System.out.println("Ваш номер телефону: ");
        User.Phone_number = sc.next();

        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signUpUser(User.name , User.surname , User.Phone_number , formattedDateTime);
    }
}
