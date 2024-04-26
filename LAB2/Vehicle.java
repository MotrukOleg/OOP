import java.util.Scanner;

abstract class Vehicle {
    protected  String typeOfVehicle;
    protected  String name;
    protected  String model;

    public abstract void inputData(Scanner sc);

    protected abstract String getVehicleType();
}

class Car extends  Vehicle{

    public static String numOfDoors;

    @Override
    public void inputData(Scanner sc){
        System.out.println("Марка машини: ");
        name = sc.next();
        System.out.println("Модель машини: ");
        model = sc.next();
        System.out.println("к-ть дверей: ");
        Car.numOfDoors = sc.next();
        System.out.println(name + " " + model + " " + numOfDoors);
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signUpCar(name ,  model , numOfDoors , getVehicleType());
    }

    @Override
    protected String getVehicleType(){
        return "Машина";
    }

    protected String getNumOfDoors(){return numOfDoors;}
}
class Motorcycle extends  Vehicle{
    public  static String typeOfMoto;

    @Override
    protected String getVehicleType(){
        return "Мотоцикл";
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Марка мотоцикла: ");
        name = sc.next();
        System.out.println("Модель мотоцикла: ");
        model = sc.next();
        System.out.println(name + " " + model + " " + typeOfMoto);
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signUpMoto(name , model, "0" ,getVehicleType());
    }
}