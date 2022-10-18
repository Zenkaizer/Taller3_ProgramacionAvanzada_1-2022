public class UserList {

    private UserNode head;
    private int userQuantity;

    public UserList() {
        this.head = null;
        this.userQuantity = 0;
    }

    public UserNode getHead() {
        return this.head;
    }

    public void setHead(UserNode head) {
        this.head = head;
    }

    public int getUserQuantity() {
        return this.userQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        this.userQuantity = userQuantity;
    }

    public void addUser(User user){

        if (this.head == null){
            this.head = new UserNode(user);
            this.userQuantity++;
            return;
        }

        UserNode newUser = new UserNode(user);
        UserNode aux = this.head;

        while (aux.getNext() != null){
            aux = aux.getNext();
        }

        aux.setNext(newUser);
        this.userQuantity++;
    }

    public User getUserFromList(String rut){

        if (this.head == null){
            return null;
        }

        UserNode aux = this.head;

        while (!aux.getUser().getRut().equals(rut)){
            aux = aux.getNext();
            if (aux == null){
                return null;
            }
        }
        return aux.getUser();
    }

    public User getUserFromList(int position){

        if (this.head == null){
            return null;
        }

        if (position >= this.userQuantity || position < 0){
            return null;
        }

        UserNode aux = this.head;

        for (int i = 0; i < position; i++) {
            aux = aux.getNext();
        }

        return aux.getUser();
    }
}
