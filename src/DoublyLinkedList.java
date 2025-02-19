public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head; // represents the head of the list
    private NodeType<T> tail; // represents the tail of the list



    /**
     * This class holds the linked list and what the linked list can do
     * and can be done to the linked list
     */
    public DoublyLinkedList() {

        head = null;
        tail = null;

    } // SortedLinkedList

    /**
     * returns the length of the linkedList
     * @return length of list
     */
    public int length() {
        int count = 0;
        currentPos = this.head;
        while (currentPos != null) {
            count++;
            currentPos = currentPos.next;
        }

        return count;
    } // getLength

    /**
     * This method allows you to insert items into the linked list
     * @param item is what is stored in the list
     */
    public void insertItem(T item ) {

        this.currentPos = this.head;

        if ( this.head == null ) {
            this.head = new NodeType();
            this.head.info = item;
            this.currentPos = head;
            return;
        } // if

        if (currentPos.info.compareTo(item) == 1) {
            NodeType tmp = new NodeType();
            tmp.info = item;
            tmp.next = currentPos;
            this.head = tmp;

        } // if


        if (currentPos.info.compareTo(item) == 0) {

            System.out.println("Sorry. You cannot insert the duplicate item");

        } // if

        while (currentPos.info.compareTo(item) == -1) {

            if (currentPos.next == null) {
                currentPos.next = new NodeType();
                currentPos.next.info = item;
                currentPos = currentPos.next;
            } else {
                currentPos = currentPos.next;


                if (currentPos.info.compareTo(item) == 0) {

                    System.out.println("Sorry. You cannot insert the duplicate item");

                } // if

                if (currentPos.info.compareTo(item) == 1) {
                    NodeType tmp = new NodeType();
                    if (currentPos.next != null) {
                    tmp.next = currentPos.next;
                    }
                    tmp.info = currentPos.info;
                    currentPos.info = item;
                    currentPos.next = tmp;

                } // if

            } // else


        } // while



    } // insertItem
    /**
     * allows the user to delete items by entering the number to delete
     * @param item is what is stored in the list
     */
    public void deleteItem (ItemType item) {

        NodeType prev = null;

        // handles empty case
        if (head == null) {

            System.out.println("You cannot delete from an empty list");
            return;

        } // if

        // handles deleting the first element
        if (head.info.compareTo(item) == 0) {

            head = head.next;
            return;


        } // if


        this.currentPos = this.head;

        while (currentPos != null) {

            if (currentPos.info.compareTo(item) == 0) {

                if (currentPos.next == null) {

                    prev.next = null;
                    return;

                } else if (currentPos.next != null) {

                    prev.next = currentPos.next;
                    return;

                }// else if
            } // if
            prev = currentPos;
            currentPos = currentPos.next;

        } // while

        System.out.println("Item not Found");

    } // deleteItem


    public void print () {

        this.currentPos = this.head;

        while (currentPos != null) {

            System.out.printf("%d ", currentPos.info.getValue());
            currentPos = currentPos.next;

        } // while



        System.out.println(" ");

    } // print


    public void printReverse() {

        System.out.println("print reverse");

    } // printReverse
    public void deleteSubsection() {

        System.out.println("delete subsection");

        this.currentPos = this.head;

        while (currentPos != null && currentPos.next != null) {

            currentPos.next = currentPos.next.next;
            currentPos = currentPos.next;

        } // while

    } // DeleteAlternateNodes

    public void reverseList() {

        System.out.println("reverseList");

    } // reverseList


    public void swapAlternat() {

        System.out.println("swapAlternat");

    } // swapAlternat


} // DoublyLinkedList
