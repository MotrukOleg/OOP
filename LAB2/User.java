import java.util.Scanner;

public class User {
    private int ID;
    public static String name;
    public static String surname;
    public static String phoneNumber;

    public static void Data_user(Scanner sc , String formattedDateTime) {
        System.out.println("Ваше ім'я: ");
        User.name = sc.next();
        System.out.println("Ваше прізвище: ");
        User.surname = sc.next();
        System.out.println("Ваш номер телефону: ");
        User.phoneNumber = sc.next();
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signUpUser(User.name , User.surname , User.phoneNumber , formattedDateTime);
    }
    public static  void ToHashTable(HashTable<String , ContactDetails> contacts , String VehicleType , String numOfDoors){
        ContactDetails contact  = new ContactDetails(name , surname , phoneNumber , VehicleType , numOfDoors);
        contacts.put(name + " " + surname , contact);
        System.out.println("Contact added to the hash table: " + contact);
    }
}