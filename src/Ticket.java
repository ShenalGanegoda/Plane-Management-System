public class Ticket {
    // Ticket class implementation to store information of the tickets as objects.

    int row;
    int seat;
    boolean price;
    Person person;
    String status;

    public Ticket(int row, int seat, boolean price, Person person ,String status) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
        this.status = status;
    }
}
