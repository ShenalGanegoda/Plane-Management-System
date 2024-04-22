import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in); // Scanner object to get inputs from the user.

    // Integer arrays that holds the seat status, Available - "0" | Sold - "1"
    public int[] seatingA = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
    public int[] seatingB = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0};
    public int[] seatingC = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0};
    public int[] seatingD = { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Hello,\nWelcome to the Plane management application");
        menuOptionPrint();
    }

    public static void menuOptionPrint(){
        // Separate method for printing out the Menu options
        System.out.println("********************************");
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
        switch (choice){ // Switch case to choose the method.
            case 1: buyASeat();
                System.out.println("Buy a seat option chosen!");
                break;
            case 2: cancelASeat();
                System.out.println("Cancel a seat option chosen!");
                break;
            case 3: findFirstAvailableSeat();
                System.out.println("Find first available seat option chosen!");
                break;
            case 4: showSeatingPlan();
                System.out.println("Show seating plan option chosen!");
                break;
            case 5: printTicketInformation();
                System.out.println("Print ticket information option chosen!");
                break;
            case 6: searchTickets();
                System.out.println("Search tickets option chosen!");
                break;
            case 0: quit();
                System.out.println("Quit option chosen!");
                break;
            default:
                System.out.println("Invalid Input\nTry again..");
        }
    }
    public static void buyASeat(){
        boolean controlRowWhile = true; //Boolean value to control the while loop.
        while (controlRowWhile){ // While loop to loop till the user enters valid input.

            // Receiving row number from the user.
            System.out.print("Enter Row number: ");
            int selectedRowNumber = scn.nextInt();

            if (validRowNumber(selectedRowNumber)){
                controlRowWhile = false;
                System.out.println("Input recorded");
                System.out.println();
            } else {
                System.out.println("Invalid input. Enter again");
                System.out.println();
            }
        }


        boolean controlRSeatWhile = true; //Boolean value to control the while loop.
        while (controlRSeatWhile){ // While loop to loop till the user enters valid input.

            // Receiving seat from the user.
            System.out.print("Enter seat: ");
            String selectedSeat = scn.next();

            if (validSeat(selectedSeat)){
                controlRSeatWhile = false;
                System.out.println("Input recorded");
                System.out.println();
            } else {
                System.out.println("Invalid input. Enter again");
                System.out.println();
            }
        }
    }

    public static boolean validRowNumber(int rowNumber){
        boolean flag = true; // Boolean value to check and store validation for return.
        if ((rowNumber <= 0) || (rowNumber > 14)) flag = false;
        // Condition to check if Row number is within the valid range.

        return flag;
    }

    public static boolean validSeat(String seat){
        seat.toUpperCase(); // Converting value to uppercase.
        boolean flag = true; // Boolean value to check and store validation for return.
        if (!seat.equals("A") || !seat.equals("B") || !seat.equals("C") || !seat.equals("D")) flag = false;
        // Condition to check if Row number is within the valid range.

        return flag;
    }
    public static void cancelASeat(){}
    public static void findFirstAvailableSeat(){}
    public static void showSeatingPlan(){}
    public static void printTicketInformation(){}
    public static void searchTickets(){}
    public static void quit(){
        // Method to terminate the JVM.
        System.out.println("Quitting program.. ");
        System.exit(0); // System classes exit method used for terminating the JVM.
    }

}