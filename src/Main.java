import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in); // Scanner object to get inputs from the user.
    // Integer arrays that holds the seat status, Available - "0" | Sold - "1"
    public static int[] seatingA = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
    public static int[] seatingB = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0};
    public static int[] seatingC = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0};
    public static int[] seatingD = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
    public static int[][] allSeats = {seatingA , seatingB , seatingC , seatingD};
    // Multidimensional Array for storing all arrays for traversing.
    public static Ticket[] ticketsArray = {}; // Array to hold Ticket objects.
    public static int buyCount = -1; // Integer variable to hold ticket count.


    public static void main(String[] args) {
        System.out.println();
        System.out.println("Hello,\nWelcome to the Plane management application");

        while (true){ // Loop to recursively print out the menu option.
            menuOptionPrint();
        }

    }

    public static void menuOptionPrint(){
        // Separate method for printing out the Menu options
        System.out.println();
        System.out.println("\n********************************");
        System.out.println("         Menu Options:");
        System.out.println("********************************");
        System.out.println();
        System.out.println("1) Buy a seat");
        System.out.println("2) Cancel a seat");
        System.out.println("3) Find first available seat");
        System.out.println("4) Show seating plan");
        System.out.println("5) Print ticket information and total sales");
        System.out.println("6) Search tickets");
        System.out.println("0) Quit");
        System.out.println();

        System.out.print("Enter option number here: "); // Print statement for the user to choose option.
        int option = scn.nextInt(); // Saving the input using the scanner object.
        System.out.println();
        chooseMethod(option); // Method call for the chooseMethod() and passing of the Integer value - "option".
    }

    public static void chooseMethod(int choice){
        // Separate method to choose the option for the user
        switch (choice) { // Switch case to choose the method.
            case 1 -> {
                System.out.println("01) Buy a seat option chosen!");
                buyASeat();
            }
            case 2 -> {
                System.out.println("02) Cancel a seat option chosen!");
                cancelASeat();
            }
            case 3 -> {
                System.out.println("03) Find first available seat option chosen!");
                findFirstAvailableSeat();
            }
            case 4 -> {
                System.out.println("04) Show seating plan option chosen!");
                showSeatingPlan();
            }
            case 5 -> {
                System.out.println("05) Print ticket information option chosen!");
                printTicketInformation();
            }
            case 6 -> {
                System.out.println("06) Search tickets option chosen!");
                searchTickets();
            }
            case 0 -> quit();
            default -> System.out.println("Invalid Input\nTry again..");
        }
    }
    public static void buyASeat(){
        int seatNumberChosen = getSeatNumberFromUser();
        String rowChosen = getRowNumberFromUser();
        int ticketPrice = calculateTicketPrice(seatNumberChosen);

        collectPersonInformation(rowChosen , seatNumberChosen , ticketPrice);
        // Collecting person information and creating Person + Ticket objects.

        int indicateBooking = 0; // Variable to pass to the method to indicate it's a Booking.
        System.out.println();
        switch (rowChosen){
            // Switch case to book using separate methods.
            case "A" -> bookOrCancelRowA(seatNumberChosen , indicateBooking);
            case "B" -> bookOrCancelRowB(seatNumberChosen , indicateBooking);
            case "C" -> bookOrCancelRowC(seatNumberChosen , indicateBooking);
            case "D" -> bookOrCancelRowD(seatNumberChosen , indicateBooking);
        }
    }

    private static int calculateTicketPrice(int seatNumber) {
        int calculatedPrice = 0;

        if ((seatNumber >= 1) || (seatNumber <= 5)){
            // Checks for the seats in between seat number 1 - 5.
            calculatedPrice = 200;
        } else if (seatNumber >= 6 || seatNumber <= 9 ) {
            // Checks for the seats in between seat number 6 - 9.
            calculatedPrice = 150;
        } else calculatedPrice = 180; // Seats in between seat number 10 - 14.

        return calculatedPrice;
    }

    public static void collectPersonInformation(String row , int seat , int ticketPrice) {
        //  Separate method to get information of the person.
        System.out.print("Enter name: ");
        String name = scn.next();
        System.out.print("Enter surname: ");
        String surname = scn.next();
        System.out.print("Enter Email: ");
        String email = scn.next();

        Person person = new Person(name , surname , email);
        // Creating a Person object with the received inputs.

        Ticket ticket = new Ticket(row , seat , ticketPrice , person);
        // Creating a Ticket object with the received inputs.

        buyCount++; // Incrementing the buy Count to keep track of sold tickets.
        addToArray(ticketsArray , buyCount , ticket); // Method to Add new Ticket to an Array.
    }

    private static Ticket[] addToArray(Ticket[] arrayOfTickets , int elementsOfTheArray , Ticket newValue) {
        Ticket[] newTicketArray = new Ticket[elementsOfTheArray + 1];
        // Creating new array with one index added to the original Array for new value addition.

        for (int i = 0; i < elementsOfTheArray; i++) {
            newTicketArray[i] = arrayOfTickets[i]; // Creating new array with Original array.
        }
        newTicketArray[elementsOfTheArray] = newValue; // Adding the new value to the last index.
        return newTicketArray;
    }

    public static int getSeatNumberFromUser(){
        // Separate method to get seat number from the user.
        int seatNumberChosen = 0;

        boolean controlSeatWhile = true; //Boolean value to control the while loop.
        while (controlSeatWhile){ // While loop to loop till the user enters valid input.

            // Receiving row number from the user.
            System.out.print("Enter seat number: ");
            int selectedSeatNumber = scn.nextInt();

            if (validSeatNumber(selectedSeatNumber)){
                controlSeatWhile = false;
                seatNumberChosen = selectedSeatNumber;
            } else {
                System.out.println("Invalid input. Enter again");
                System.out.println();
            }
        }

        return seatNumberChosen;
    }



    public static String getRowNumberFromUser(){
        // Separate method to get Row from the user.
        String rowChosen = "";

        boolean controlRowWhile = true; //Boolean value to control the while loop.
        while (controlRowWhile){ // While loop to loop till the user enters valid input.

            // Receiving seat from the user.
            System.out.print("Enter row(A , B , C , D): ");
            String selectedRow = scn.next().toUpperCase();

            if (validRow(selectedRow)){
                controlRowWhile = false;
                rowChosen = selectedRow;
            } else {
                System.out.println("Invalid input. Enter again");
                System.out.println();
            }
        }

        return rowChosen;
    }

    public static void bookOrCancelRowA(int seatNumber , int bookOrCancel){
        // Separate method to trave
        // rse through specific row for booking.

        // 0 - Book
        // 1 - Cancel

        if (bookOrCancel == 0){ // Checks if this method call is for booking or canceling.
            if (seatingA[seatNumber - 1] == 1){
                System.out.println("Seat not available");
            } else {
                seatingA[seatNumber - 1] = 1;
                System.out.println("Seat booked!");
            }
        } else {
            if (seatingA[seatNumber - 1] == 1){
                System.out.println("Booking canceled");
                seatingA[seatNumber - 1] = 0;
            } else {
                System.out.println("Seat is available!\nWrong Input");
            }
        }

    }

    public static void bookOrCancelRowB(int seatNumber, int bookOrCancel){
        // Separate method to traverse through specific row for booking.

        // 0 - Book
        // 1 - Cancel

        if (bookOrCancel == 0){ // Checks if this method call is for booking or canceling.
            if (seatingB[seatNumber - 1] == 1){
                System.out.println("Seat not available");
            } else {
                seatingB[seatNumber - 1] = 1;
                System.out.println("Seat booked!");
            }
        } else {
            if (seatingB[seatNumber - 1] == 1){
                System.out.println("Booking canceled");
                seatingB[seatNumber - 1] = 0;
            } else {
                System.out.println("Seat is available!\nWrong Input");
            }
        }
    }

    public static void bookOrCancelRowC(int seatNumber , int bookOrCancel){
        // Separate method to traverse through specific row for booking.

        // 0 - Book
        // 1 - Cancel

        if (bookOrCancel == 0){ // Checks if this method call is for booking or canceling.
            if (seatingC[seatNumber - 1] == 1){
                System.out.println("Seat not available");
            } else {
                seatingC[seatNumber - 1] = 1;
                System.out.println("Seat booked!");
            }
        } else {
            if (seatingC[seatNumber - 1] == 1){
                System.out.println("Booking canceled");
                seatingC[seatNumber - 1] = 0;
            } else {
                System.out.println("Seat is available!\nWrong Input");
            }
        }
    }

    public static void bookOrCancelRowD(int seatNumber , int bookOrCancel){
        // Separate method to traverse through specific row for booking.

        // 0 - Book
        // 1 - Cancel

        if (bookOrCancel == 0){ // Checks if this method call is for booking or canceling.
            if (seatingD[seatNumber - 1] == 1){
                System.out.println("Seat not available");
            } else {
                seatingD[seatNumber - 1] = 1;
                System.out.println("Seat booked!");
            }
        } else {
            if (seatingD[seatNumber - 1] == 1){
                System.out.println("Booking canceled");
                seatingD[seatNumber - 1] = 0;
            } else {
                System.out.println("Seat is available!\nWrong Input");
            }
        }
    }

    public static boolean validSeatNumber(int rowNumber){
        // Method for seat number input validation.
        boolean flag = true; // Boolean value to check and store validation for return.
        if ((rowNumber <= 0) || (rowNumber > 14)) flag = false;
        // Condition to check if Row number is within the valid range.

        return flag;
    }

    public static boolean validRow(String seat){
        // Method for row input validation.
        boolean flag = false; // Boolean value to check and store validation for return.
        if (seat.equals("A") || seat.equals("B") || seat.equals("C") || seat.equals("D")) flag = true;
        // Condition to check if Row number is within the valid range.

        return flag;
    }
    public static void cancelASeat(){
        // Separate method to cancel a seat booking.
        int seatNumberChosen = getSeatNumberFromUser();
        String rowChosen = getRowNumberFromUser();


        int indicateCancel = 1; // Variable to pass to the method to indicate it's a cancelation.
        switch (rowChosen){
            // Switch case to book using separate methods.
            case "A" -> bookOrCancelRowA(seatNumberChosen , indicateCancel);
            case "B" -> bookOrCancelRowB(seatNumberChosen , indicateCancel);
            case "C" -> bookOrCancelRowC(seatNumberChosen , indicateCancel);
            case "D" -> bookOrCancelRowD(seatNumberChosen , indicateCancel);
        }
    }
    public static void findFirstAvailableSeat(){
        int count = 0; // Count variable to track which array inside the for-each loop.
        for(int[] individualArrays : allSeats){
            count++; //Increment count on each array.
            for (int i = 0; i < individualArrays.length; i++) {
                if (individualArrays[i] == 0){
                    System.out.println(
                            "Available row: " + getRowFromNumber(count)
                                    + " \nAvailable seat number: " + (i + 1));
                    break;
                }
            }
            break;
        }
    }

    public static String getRowFromNumber(int countedNumber){
        // Separate method to check which Row is according to the number in the findFirstAvailableSeat() loop traversal.
        String row = "";
        switch (countedNumber){
            case 1 -> row = "A";
            case 2 -> row = "B";
            case 3 -> row = "C";
            case 4 -> row = "D";
        }

        return row;
    }
    public static void showSeatingPlan(){

        for(int[] individualArrays : allSeats){
            System.out.println();
            for (int i = 0; i < individualArrays.length; i++) { // Iterating through each individual Array.
                if (individualArrays[i] == 1){
                    System.out.print("X" + " ");
                } else System.out.print(individualArrays[i] + " ");
            }
        }

    }
    public static void printTicketInformation(){}
    public static void searchTickets(){}
    public static void quit(){
        // Method to terminate the JVM.
        System.out.println("06) Quitting program.. ");
        System.exit(0); // System classes exit method used for terminating the JVM.
    }

}