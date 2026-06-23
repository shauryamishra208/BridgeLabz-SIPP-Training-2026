public class MovieTicket {
    private final String movieName;
    private int seatNumber;
    private double price;
    private boolean isBooked;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = 0;
        this.price = 0.0;
        this.isBooked = false;
    }

    public String getMovieName() { return movieName; }
    public int getSeatNumber() { return seatNumber; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }

    public void bookTicket(int seatNumber, double price) {
        if (isBooked) {
            System.out.println("This ticket is already booked for seat " + this.seatNumber);
            return;
        }
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = true;
        System.out.println("Ticket booked successfully!");
    }

    public void displayTicketDetails() {
        System.out.println("===== Movie Ticket Details =====");
        System.out.println("Movie Name  : " + movieName);
        System.out.println("Seat Number : " + (isBooked ? seatNumber : "Not Assigned"));
        System.out.printf("Price       : ₹%.2f%n", price);
        System.out.println("Status      : " + (isBooked ? "Booked " : "Available"));
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Kalki 2898 AD");
        MovieTicket ticket2 = new MovieTicket("Pushpa 2");

        ticket1.displayTicketDetails();
        System.out.println();

        ticket1.bookTicket(14, 250.00);
        ticket1.displayTicketDetails();
        System.out.println();

        ticket1.bookTicket(15, 250.00);
        System.out.println();

        ticket2.bookTicket(7, 180.00);
        ticket2.displayTicketDetails();
    }
}
