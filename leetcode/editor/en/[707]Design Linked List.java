package leetcode.editor.en;

/**
 * Design your implementation of the linked list. You can choose to use a singly
 * or doubly linked list. A node in a singly linked list should have two attributes:
 * val and next. val is the value of the current node, and next is a pointer/
 * reference to the next node. If you want to use the doubly linked list, you will need
 * one more attribute prev to indicate the previous node in the linked list. Assume
 * all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexᵗʰ node in the linked list. If
 * the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of
 * the linked list. After the insertion, the new node will be the first node of the
 * linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the
 * linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexᵗʰ
 * node in the linked list. If index equals the length of the linked list, the
 * node will be appended to the end of the linked list. If index is greater than the
 * length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexᵗʰ node in the linked list, if
 * the index is valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex",
 * "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 * <p>
 * <p>
 * Related Topics Linked List Design 👍 1878 👎 1332
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    private int currSize;
    Node head, tail;

    public MyLinkedList() {
        currSize = 0;
        head = tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= currSize)
            return -1;

        int currIndex = 0;
        Node currNode = head;

        while (currNode != null) {

            if (currIndex == index) {
                return currNode.getVal();
            }
            currNode = currNode.getNext();
            currIndex++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);

        if (currSize == 0)
            tail = head;

        currSize++;
    }

    public void addAtTail(int val) {
        if (currSize == 0) {
            head = tail = new Node(val, null);
        } else {
            tail.setNext(new Node(val, null));
            tail = tail.getNext();
        }
        currSize++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > currSize) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == currSize) {
            addAtTail(val);
        } else {
            int currIndex = 0;
            Node temp = head;

            while (currIndex != index - 1){
                temp = temp.getNext();
                currIndex++;
            }

            Node newNode = new Node(val, temp.getNext());
            temp.setNext(newNode);
            currSize++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= currSize)
            return;

        if(index == 0){
            head = head.getNext();
        } else {
            int currIndex = 0;
            Node temp = head;

            while (currIndex != index - 1){
                temp = temp.getNext();
                currIndex++;
            }

            temp.next = temp.next.next;
            if(index == currSize - 1)
                tail = temp;
        }

        currSize--;
    }

    private class Node {
        private int val;
        private Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node() {
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
