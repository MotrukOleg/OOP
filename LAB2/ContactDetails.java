public class ContactDetails {
    private String name;
    private String surname;
    private String phoneNumber;
    private String carType;
    private String numOfDoors;

    public ContactDetails(String name , String surname , String phoneNumber , String carType , String numOfDoors){
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.carType = carType;
        this.numOfDoors = numOfDoors;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return  surname;
    }
    public String getPhoneNumber(){
        return  phoneNumber;
    }
    public String getCarType(){
        return  carType;
    }
    public  String getNumOfDoors(){
        return  numOfDoors;
    }

    @Override
    public String toString(){
        return "Name: " + name + " " + surname + ", Phone: " + phoneNumber + ", Car:" + carType + ", Doors: " + numOfDoors;
    }

}