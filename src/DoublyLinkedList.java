public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head; // represents the head of the list
    private NodeType<T> tail; // represents the tail of the list
    private NodeType<T> currentPos;


    /**
     * This class holds the Doubly linked list and what the Doubly linked
     list can do and can be done to the Doubly linked list
     */
    public DoublyLinkedList() {

        head = null;
        tail = null;
        currentPos = null;
    } // DoublyLinkedList


    /**
     * This method allows you to insert items into the linked list
     * @param item is what is stored in the list string int or double
     * @output the output for this function is an updated double linked list
     */
    public void insertItem(T item ) {

        this.currentPos = this.head;

        if ( this.head == null ) {
            this.head = new NodeType<T>(item);
            this.currentPos = head;
            this.tail = this.head;
            return;
        } // if


        if (currentPos.info.compareTo(item) == 1) {
            NodeType<T> tmp = new NodeType<T>(item);
            tmp.next = currentPos;
            currentPos.back=tmp;
            this.head = tmp;

        } // if


        if (currentPos.info.compareTo(item) == 0) {

            System.out.println("Sorry. You cannot insert the duplicate item");

        } // if

        while (currentPos.info.compareTo(item) == -1) {

            if (currentPos.next == null) {
                currentPos.next = new NodeType<T>(item);
                currentPos.next.info = item;
                currentPos.next.back = currentPos;
                currentPos = currentPos.next;
                this.tail = currentPos;
            } else {
                currentPos = currentPos.next;


                if (currentPos.info.compareTo(item) == 0) {

                    System.out.println("Sorry. You cannot insert the duplicate item");

                } // if

                if (currentPos.info.compareTo(item) == 1) {
                    NodeType<T> tmp = new NodeType<T>(item);
                    if (currentPos.next != null) {
                        tmp.next = currentPos.next;
                    }
                    tmp.info = currentPos.info;
                    currentPos.info = item;
                    currentPos.next = tmp;
                    currentPos.next.back = currentPos;

                } // if

            } // else


        } // while



    } // insertItem




    /**
     * allows the user to delete items by entering the element to delete
     * @param item is what is stored in the list
     * @output is the list with the specified element removed
     */
    public void deleteItem (T item) {

        NodeType<T> prev = null;
        currentPos = new NodeType<T>(item);
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
                    currentPos.back = prev;
                    prev.next = currentPos.next;
                    return;

                }// else if
            } // if


            prev = currentPos;
            currentPos = currentPos.next;

        } // while

        System.out.println("Item not Found");

    } // deleteItem


    /**
     * returns the length of the linkedList
     * @input is the specified double linked list
     * @return length of list
     */
    public int length() {

        int count = 0;
        this.currentPos = this.head;
        while (currentPos != null) {
            count++;
            currentPos = currentPos.next;
        }

        return count;
    } // getLength




    /**
     * The print method cycles through the list and prints out its contents
     *
     */
    public void print () {

        this.currentPos = this.head;

        while (currentPos != null) {

            //System.out.printf("%d ", currentPos.info);
            //currentPos = currentPos.next;

            System.out.print(currentPos.info);
            System.out.print(" ");
            System.out.println();
            currentPos = currentPos.next;

        } // while



        System.out.println(" ");

    } // print


    public void printReverse() {

        this.currentPos = this.head;

        while (currentPos.next != null) {

            currentPos = currentPos.next;

        } // while

        while (currentPos != null) {

            System.out.print(currentPos.info);
            System.out.print(" ");
            System.out.println();
            currentPos = currentPos.back;

        } // while

        System.out.println("print reverse");

    } // printReverse


    /**
     * the node that contains the item is removed from the list. If the
     * item is not present in the list, print the message that is
     * shown in the example output.
     */
    public void deleteSubsection(T start, T end ) {

                    this.currentPos = this.head;
                    NodeType<T> lowerBound = null;
                    NodeType<T> upperBound = null;

                    while (currentPos.info.compareTo(start) < 0) {

                        currentPos = currentPos.next;

                    } //while

                    lowerBound = currentPos;

                    currentPos = tail;

                    while (currentPos.info.compareTo(end) > 0) {

                        currentPos = currentPos.back;

                    } // while

                    upperBound = currentPos;

                    if (lowerBound.back != null && upperBound.next != null) {

                        lowerBound.back.next = upperBound.next;
                        upperBound.next.back = lowerBound.back;

                    } else if (upperBound.next != null && lowerBound.back == null){ // if

                        this.head = upperBound.next;
                        upperBound.back = null;

                    } else if (upperBound.next == null && lowerBound.back != null){ // else

                        this.tail = lowerBound.back;
                        lowerBound.next = null;



                    } else if (upperBound.next == null && lowerBound.back == null) {
                        head = null;
                        tail = null;
                    } // else if
    } // DeleteAlternateNodes


    /**
     * This function reverses the linked list without the creation of an
     * additional list.
     *
     * @output is the reversed list.
     */
    public void reverseList() {

        NodeType<T> temp = null;
        this.currentPos = this.head;

        while (currentPos != null) {

            temp = currentPos.back;
            currentPos.back = currentPos.next;
            currentPos.next = temp;
            currentPos = currentPos.back;


        } // while

        this.head = temp.back;
        this.tail = currentPos;
    } // reverseList

    /**
     * This function swaps every other node with ever other node flipping
     * the 2 making it alternating.
     * @output the nodes flip flop on a linked list.
     */
    public void swapAlternate() {

        this.currentPos = this.head;

        while (currentPos != null && currentPos.next != null) {

            NodeType<T> temp1 = currentPos;
            NodeType<T> temp2 = currentPos.next;

            if ( temp1.back != null) {
                temp1.back.next = temp2;
            } else { head = temp2; }

            if ( temp2.next != null) {
                temp2.next.back = temp1;
            }


            temp1.next = temp2.next;
            temp2.back = temp1.back;
            temp2.next = temp1;
            temp1.back = temp2;




            currentPos = temp1.next;

        } // while

        System.out.println("sss");
    } // swapAlternat


} // DoublyLinkedList
