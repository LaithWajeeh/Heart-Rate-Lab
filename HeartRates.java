//package lab2;

import java.time.LocalDate;
import java.util.Scanner;
//Heart Rate Class for all your Heart rate aggrigating and caculating needs!
public class HeartRates {
    private String firstName;
    private String lastName;
    private int month;
    private int day;
    private int year;
    //constructor; takes in relevant user information.
    public HeartRates(String firstName, String lastName, int month, int day, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.month = month;  
        this.day = day;  
        this.year = year;
    }


    //gets first name
    public String getFirstName() {

        return this.firstName;
    }

    //gets last name
    public String getLastName() {

        return this.lastName;
    }

    //gets birth month
    public int getMonth() {

        return this.month;
    }

    //gets birth day
    public int getDay() {

        return this.day;
    }

    // gets birth year
    public int getYear() {

        return this.year;
    }

    // gets age
    public int getAge() {
        //compares todays date with that of birth to determine age   
        return LocalDate.now().compareTo(LocalDate.of(this.year,this.month,this.day));
    }

    //gets max heart rate with some math
    public int getMaxHeartRate() {  
        return 220 - this.getAge();
    }

    //returns target heart rate as double array
    public double[] getTargetHeartRate() {
        //creates new double object with the following contents; the content is some math to callculate min and max target heartrate  
        return new double[] { (this.getMaxHeartRate() * 0.50), (this.getMaxHeartRate() * 0.85) };
    }


    //sets first name.
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    //sets last name.
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    //sets month.
    public void setMonth(int month) {

        this.month = month;
    }

    //sets day
    public void setDay(int day) {

        this.day = day;
    }

    //sets year.
    public void setYear(int year) {

        this.year = year;
    }

    //sub run class
    public class Main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            System.out.print("First Name: ");
            String first = scan.next();

            System.out.print("Last Name: ");
            String last = scan.next();

            System.out.print("Birth Month: ");
            int month = scan.nextInt();

            System.out.print("Birth Day: ");
            int day = scan.nextInt();

            System.out.print("Birth Year: ");
            int year = scan.nextInt();

            HeartRates rate = new HeartRates(first, last, month, day, year);
            
            System.out.println("");
            System.err.println("--------------------------------------");
            
            System.out.println("");
            System.out.println("First Name: " + rate.getFirstName());
            System.out.println("Last Name: " + rate.getLastName());
            System.out.println("Age: " + rate.getAge());
            System.out.println("Max Heart Rate: " + rate.getMaxHeartRate() + " BPM");
            //some cursed escape charater formating/printing for the target heart rate range.
            System.out.println("Target Heart Rate:" + "\n\tMimimum: " + rate.getTargetHeartRate()[0] + " BPM" + "\n\tMaximum: " + rate.getTargetHeartRate()[1] + " BPM");
        }
    }
}
