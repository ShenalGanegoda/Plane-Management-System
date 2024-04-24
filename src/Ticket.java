public class Ticket {
    // Ticket class implementation to store information of the tickets as objects.

    String row;
    int seat;
    int price;
    Person person;

    public Ticket(String row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public String toString() {
        return "Ticket Information: ," + "Row - " + row + ", Seat - " + seat + ", Price - " + price + " ," + person;
    }
}
