package LinkedList;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    SinglyLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        if(tail == null){
            tail = head;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
        }
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        tail = node;
        size++;
        
    }

    public Node get(int idx){
        Node temp = head;
        for(int i = 1; i < idx; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean find(int key){
        Node temp = head;
        while(temp != null){
            if(temp.val == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public void insert(int val, int idx){
        if(idx == 0) insertFirst(val);
        if(idx == size) insertLast(val);
        
        Node temp = get(idx);
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertRec(int val, int idx){
        head = insertRec(val,idx, head);
        
    }

    public Node insertRec(int val,int idx, Node node){
        if(idx == 0){
            Node temp = new Node(val, node);
            return temp;
        }
        node.next = insertRec(val, idx - 1, node.next);
        return node;

    }

    public int deleteFirst(){
        int value = head.val;
        head = head.next;
        size--;
        if(head == null) tail = null;
        return value;

    }

    public int deleteLast(){
        if(size <= 1) deleteFirst();
        int value = tail.val;
        Node secondLast = get(size - 2);
        secondLast.next = null;
        tail = secondLast;
        size--;
        return value;
    }

    public int delete(int idx){
        int value = tail.val;
        Node temp = get(idx - 1);
        temp.next = temp.next.next;
        size--;
        return value;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val +" -> ");
            temp = temp.next;
        }
        System.out.print("END");

    }

    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args){
        SinglyLinkedList s = new SinglyLinkedList();
        // Insert at beginning
        s.insertFirst(2);
        s.insertFirst(3);
        s.insertFirst(4);
        System.out.print("After insertFirst: ");
        s.display();
        System.out.println();

        // Insert at end
        s.insertLast(5);
        System.out.print("After insertLast: ");
        s.display();
        System.out.println();

        // Insert at index
        s.insert(10, 2); // Insert 10 at index 2
        System.out.print("After insert at index 2: ");
        s.display();
        System.out.println();

        // Find element
        System.out.println("Find 3: " + s.find(3));
        System.out.println("Find 99: " + s.find(99));

        // Get element at index
        System.out.println("Get at index 2: " + s.get(2).val);

        // Insert recursively
        s.insertRec(20, 1);
        System.out.print("After insertRec at index 1: ");
        s.display();
        System.out.println();

        // Delete first
        System.out.println("Delete first: " + s.deleteFirst());
        s.display();
        System.out.println();

        // Delete last
        System.out.println("Delete last: " + s.deleteLast());
        s.display();
        System.out.println();

        // Delete at index
        System.out.println("Delete at index 2: " + s.delete(2));
        s.display();
        System.out.println();
    }
}


