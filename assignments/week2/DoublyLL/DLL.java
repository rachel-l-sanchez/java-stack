public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void push(Node newNode) {
        // if ere is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesBackward() {
        // find the last node, aka tail.
        if (this.tail ==null) {
            System.out.println("list is empty");
        }
        Node tail = this.tail;
        // while the node exists...
        while(tail != null) {
            System.out.println(tail.value);
            // and move on to its next node.
            tail = tail.previous;
        }
    }
   
    public boolean contains(Integer value) {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner= this.head;
        while (runner.next != null) {
            if (runner.value == value) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    public int size() {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        int counter = 0;
        Node runner = this.head;
        while(runner.next!= null) {
            counter++;
            runner = runner.next;
        }
        return counter;
    }
  
    public void removeValAt(int index) {
        if (this.head == null) {
            System.out.println("list is empty");
        }
        Node runner = this.head;
        runner.previous = null;
        if (index==0) {
            this.head = runner.next;
        } else {
            int counter = 0;
            if (runner.next != null) {
                counter++;
                if (counter ==index-1) {
                    runner.next.previous = runner.previous; 
                    return;
                }
                counter++;
            }
        }
    }
    public boolean isPalindrome() {
        Node runner = this.head;
        boolean isPalin = true;
        Node tail = this.tail;
        while (runner != null) {
            if (runner.value == tail.value) {
                isPalin = true;
            }
            else {
                isPalin = false;
                break;
            }
            runner = runner.next;
        }
        return isPalin;
    }
}