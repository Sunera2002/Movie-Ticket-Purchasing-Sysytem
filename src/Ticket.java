public class Ticket {
    int row; int seat; double price; Person person;

    public Ticket(int row ,int seat ,double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person =person;
    }

    public void print(){
        System.out.println("Person name: " + person.name);
        System.out.println("Surname: " + person.surname);
        System.out.println("Email: " + person.email);
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
    }

    double getPrice() {
        return this.price;
    }
}
