public class UserNode {

    private User user;
    private UserNode next;

    public UserNode(User user) {
        this.user = user;
        this.next = null;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserNode getNext() {
        return this.next;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }
}
