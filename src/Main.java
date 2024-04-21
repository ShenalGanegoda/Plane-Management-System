public class Main {
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
    }

    public static void buyASeat(){}
    public static void cancelASeat(){}
    public static void findFirstAvailableSeat(){}
    public static void showSeatingPlan(){}
    public static void printTicketInformation(){}
    public static void searchTickets(){}
    public static void quit(){}

}