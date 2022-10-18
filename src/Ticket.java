public class Ticket {

    private int ticketNumber;
    private int totalPurchase;
    private int accumulatedPoints;
    private User user;
    private ProductList productList;

    public Ticket(int ticketNumber, int totalPurchase, int accumulatedPoints, User user, ProductList productList) {
        this.ticketNumber = ticketNumber;
        this.totalPurchase = totalPurchase;
        this.accumulatedPoints = accumulatedPoints;
        this.user = user;
        this.productList = productList;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTotalPurchase() {
        return this.totalPurchase;
    }

    public void setTotalPurchase(int totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public int getAccumulatedPoints() {
        return this.accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductList getProductList() {
        return this.productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
}
