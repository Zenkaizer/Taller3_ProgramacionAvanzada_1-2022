public class TicketNode {

    private Ticket ticket;
    private TicketNode next;

    public TicketNode(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketNode getNext() {
        return this.next;
    }

    public void setNext(TicketNode next) {
        this.next = next;
    }
}
