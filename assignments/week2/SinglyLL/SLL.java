public class SLL {
    Node head;
    int size;

    public SLL() {
        this.head = null;
        this.size = 0;
    }

    public void addToList(int val) {
        Node newNode = new Node(val);
        if (this.head ==null) {
            this.head = newNode;
            this.size++;
        }
        else {
            Node runner = this.head;
            while(runner.next != null) {
                runner = runner.next;

            }
            runner.next = newNode;
            this.size++;
        }
    }
    public void displayList() {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner = this.head;
        int counter = 0;
        while(runner != null) {
            if (counter <1) {
                System.out.println("root" + runner);
                counter++;
                runner = runner.next;
            }
            else {
                System.out.println("Node:" + counter + ":" + runner.value);
                runner = runner.next;
                counter++;
            }
        }
    }
    public boolean searchList(int value) {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner= this.head;
        while (runner != null) {
            if (runner.value == value) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }
    public void removeValFromEnd() {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner = this.head;
        while(runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;
    }
    public void removeValAt(int n) {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner = this.head;
        if (n==0 && this.size >1) {
            this.head = runner.next;
        } else {
            int counter = 0;
            while(runner.next != null) {
                if (counter ==n-1) {
                    runner.next = runner.next.next;
                    return;
                }
                runner = runner.next;
                counter++;
            }
        }
    }
}