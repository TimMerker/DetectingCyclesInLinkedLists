import java.util.HashSet;

class MyLinkedList {
    Node head;
    Node tail;
    int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node temp = this.head;
        int i = 0;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        if (index >= this.length || index < 0) {
            return -1;
        } else {
            return temp.val;
        }

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            this.tail = newNode;
        }
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (this.length == index) {
            this.addAtTail(val);
        } else if (this.length < index) {
            return;
        } else if (index <= 0) {
            this.addAtHead(val);
        } else {
            Node temp = this.head;
            int i = 0;
            while (i < index - 1) {
                temp = temp.next;
                i++;
            }
            Node oldNext = temp.next;
            temp.next = newNode;
            newNode.next = oldNext;
            this.length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.head = head.next;
            this.length--;
        } else if (index > 0 && index < this.length) {
            Node temp = this.head;
            int i = 0;
            while (i < index - 1) {
                temp = temp.next;
                i++;
            }
            Node newNext = temp.next.next;
            temp.next = newNext;
            this.length--;
        } else {
            return;
        }
    }

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * Floyd's Tortoise and Hare Algorithm
         */
        public boolean hasCycle(Node head) {
            Node tortoise = head;
            Node hare = head;
            while (hare != null && hare.next != null){
                tortoise = tortoise.next;
                hare = hare.next.next;
                if (hare == tortoise){
                    return true;
                }
            }
            return false;
        }
        /**
         * Floyd's Tortoise and Hare Algorithm; Finds circle entree.
         */
        public Node detectCycle(Node head) {
            Node tortoise = head;
            Node hare = head;
            boolean hasCycle = false;
            while (hare != null && hare.next != null){
                tortoise = tortoise.next;
                hare = hare.next.next;
                if (tortoise == hare){
                    hasCycle = true;
                    break;
                }
            }
            if (!hasCycle){
                return null;
            }
            else{
                hare = head;
                while (tortoise != hare){
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(1);
        System.out.println(3);
        System.out.println();
    }

}
