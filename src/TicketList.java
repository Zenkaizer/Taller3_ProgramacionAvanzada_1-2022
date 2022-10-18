public class TicketList {

    private TicketNode head;
    private int ticketQuantity;

    public TicketList() {
        this.head = null;
        this.ticketQuantity = 0;
    }

    public TicketNode getHead() {
        return this.head;
    }

    public void setHead(TicketNode head) {
        this.head = head;
    }

    public int getTicketQuantity() {
        return this.ticketQuantity;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
