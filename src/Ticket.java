public class Ticket {
    // Ticket class implementation to store information of the tickets as objects.

    int row;
    int seat;
    boolean price;
    Person person;

    public Ticket(int row, int seat, boolean price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
}
