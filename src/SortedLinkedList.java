public class SortedLinkedList {

    private NodeType head; // represents the head of the node
    private NodeType currentPos; // represents the current node



    /**
     * This class holds the linked list and what the linked list can do
     * and can be done to the linked list
     */
    public SortedLinkedList() {

        head = null;
        currentPos = null;

    } // SortedLinkedList

    /**
     * returns the length of the linkedList
     * @return length of list
     */
    public int getLength() {
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
    public void insertItem( ItemType item ) {

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

    /**
     * Searches the list for the item values and returnd the index
     * @return the index of the item
     * @param item is the value stored in the array
     */
    public int searchItem( ItemType item ) {

        int count = 1;
        this.currentPos = this.head;

        while (currentPos != null && currentPos.info.getValue() != item.getValue()) {
            count++;
            currentPos = currentPos.next;
        }

        if ( currentPos == null ) {

            System.out.printf("Item is not present in the list\n");
            return 0;
        }

        System.out.printf("The item is present at index %d\n",count);
        return count;

    }

    /**
     * retrieves the next item in the linked list
     */
    public ItemType getNextItem() {

        if (this.head == null){
           System.out.printf("List is empty\n");
            return null;
        }

        if ( this.currentPos == null)  {
            this.currentPos = this.head;
            return this.currentPos.info;
        } // if




        if (currentPos.next == null) {

            System.out.println("The end of the list has been reached");
            return null;

        }
        currentPos = currentPos.next;
        return currentPos.info;

    } // getNextItem

    public void resetList() {

        currentPos = null;
    } // resetList



    /**
     * merges the main list with an inputted one but doesnt alter the main list
     * when merging
     *
     *@param length is the length of the new list
     *@param cmdLine is an array of the command line numbers
     */
    public void mergeList (int length, int[] cmdLine) {

        SortedLinkedList list1 = new SortedLinkedList();;
        SortedLinkedList list2 = new SortedLinkedList();;
        ItemType item = new ItemType();

        list1.head = this.head;

        for (int i = 0; i < length; i++) {
            item = new ItemType();
            item.initialize(cmdLine[i]);
            list2.insertItem(item);

        } // for

        NodeType index1 = list1.head;
        NodeType index2 = list2.head;

        SortedLinkedList resultList = new SortedLinkedList();


        while (index1 != null && index2 != null) {

            if (index1.info.compareTo(index2.info) < 0) {

                resultList.insertItem(index1.info);
                index1 = index1.next;

            } // if

            else if (index1.info.compareTo(index2.info) > 0) {

                resultList.insertItem(index2.info);
                index2 = index2.next;

            } // else if

            else if (index1.info.compareTo(index2.info) == 0) {

                resultList.insertItem(index1.info);
                index1 = index1.next;
                index2 = index2.next;

            } // else if
        } // while

        if (index1 != null) {

            while (index1 != null) {

                resultList.insertItem(index1.info);
                index1 = index1.next;

            } // while


        } // if

        if (index2 != null) {

            while (index2 != null) {

                resultList.insertItem(index2.info);
                index2 = index2.next;

            } // while

        } // if

        System.out.println("The list 1 : ");

        if (list1 != null) {
        list1.print();
        } // if

        System.out.println(" ");

        System.out.println("The list 2 : ");

        if (list2 != null) {

        list2.print();
        } // if

        System.out.println(" ");

        System.out.println("Merged list : ");

        if (resultList != null) {
            resultList.print();
        } // while
        System.out.println(" ");


    } // mergeList

    public void DeleteAlternateNodes () {

        this.currentPos = this.head;

        while (currentPos != null && currentPos.next != null) {

            currentPos.next = currentPos.next.next;
            currentPos = currentPos.next;

        } // while

    } // DeleteAlternateNodes
    /**
     * intersection prints out the same numbers in 2 different arrays the 1st is
     * main one and the second is an inputted one
     *
     * @param length is the length of the list
     * @param cmdLine is the numbers in the command line
     */
    public void intersection(int length, int cmdLine[]) {


        SortedLinkedList list1 = new SortedLinkedList();;
        SortedLinkedList list2 = new SortedLinkedList();;
        ItemType item = new ItemType();

        list1.head = this.head;

        for (int i = 0; i < length; i++) {
            item = new ItemType();
            item.initialize(cmdLine[i]);
              list2.insertItem(item);

        } // for

        NodeType index1 = list1.head;
        NodeType index2 = list2.head;

        SortedLinkedList resultList = new SortedLinkedList();


        while (index1 != null) {

            index2 = list2.head;

            while (index2 != null) {

                if (index1.info.compareTo(index2.info) == 0) {

                    resultList.insertItem(index2.info);
                } // if
                index2 = index2.next;
            } // while

            index1 = index1.next;

        } // while

        System.out.println("The list 1 : ");

        if (list1 != null) {

            list1.print();

        }
        System.out.println(" ");

        System.out.println("The list 2 : ");

        if (list2 != null) {

            list2.print();

        } // while

        System.out.println(" ");

        System.out.println("Intersection of lists : ");

        if (resultList != null) {
            resultList.print();
        } // while
        System.out.println(" ");


    } // intersection


    /**
     * this print function prints out the linked lists
     */
    public void print () {

        this.currentPos = this.head;

        while (currentPos != null) {

            System.out.printf("%d ", currentPos.info.getValue());
            currentPos = currentPos.next;

        } // while



        System.out.println(" ");

    } // print

} // SortedLinkedList
