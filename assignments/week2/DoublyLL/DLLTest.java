public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(43);
        Node n2 = new Node(27);
        Node n3 = new Node(11);
        Node n4 = new Node(99);
        Node n5 = new Node(27);
        Node n6= new Node(43);
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        System.out.println("print values backward");
        dll.printValuesBackward();

        System.out.println("remove value at index2");
        dll.removeValAt(2);
        dll.printValuesBackward();
      
        
        System.out.println("contains 25?");
        System.out.println(dll.contains(25));

        System.out.println("size?");
        System.out.println(dll.size());

        System.out.println("isPalindrome:" + dll.isPalindrome());
    }
}
