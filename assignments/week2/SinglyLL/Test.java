public class Test {
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.addToList(19);
        sll.addToList(5);
        sll.addToList(25);
        sll.addToList(35);
        sll.addToList(23);
        sll.addToList(47);
        sll.addToList(99);

        sll.displayList();
        sll.removeValFromEnd();
        sll.displayList();

        System.out.println(sll.searchList(19));
        System.out.println(sll.searchList(32));

        sll.removeValAt(3);
        sll.displayList();
    }
}
