import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The linked list driver class provides the scanner and user inupt portions of
 * the project and makes calls to SortedLinkedList
 */
public class LinkedListDriver{

    /**
     * main method is what prompts the user and provides the desired output
     */
    public static void main(String[] args) {

        DoublyLinkedList<Comparable> list = new DortedLinkedList<>();

        String fileName = "input.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {

            try {

            String[] content = line.split("\\s+");
            ItemType item = new ItemType();
            for (String num : content) {
                int value = Integer.parseInt(num.trim());

                item = new ItemType();
                item.initialize(value);
                list.insertItem(item);
                // list.print();
            } // for
            } catch (NumberFormatException e) {
            } // catch
        } // while
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }  // Print the sorted list
            System.out.println("Doubly Linked List:");
            list.print();


            System.out.println("Commands:");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(s) - Search value");
            System.out.println("(n) - Print next iterator value");
            System.out.println("(r) - Reset iterator");
            System.out.println("(a) - Delete alternate nodes");
            System.out.println("(m) - Merge lists");
            System.out.println("(t) - Find intersection");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(q) - Quit program");

            Scanner scan = new Scanner(System.in);
            String str = "";
            while (str != "q") {
                System.out.print("Enter a command: ");
                str = scan.nextLine();

                if (str.equals("i")) { // insert
                    int val = 0;
                    System.out.print("Enter a number to insert: ");
                    val = scan.nextInt();
                    System.out.print("Original list :");
                    list.print();
                    /**
                       for (int i = 0; i < list.getLength() ; i++) {
                       System.out.print("" + list.info.getValue() + "");
                       }
                    */
                    ItemType item = new ItemType();
                    item.initialize(val);
                    list.insertItem(item);
                    System.out.print("New list :");
                    list.print();
                    scan.nextLine();

                } else if (str.equals("d")) { // delete
                    int val = 0;
                    System.out.print("Enter a number to delete: ");
                    val = scan.nextInt();
                    System.out.print("Original list :");
                    list.print();

                    ItemType item = new ItemType();
                    item.initialize(val);
                    list.deleteItem(item);

                    if(list != null) {
                        System.out.print("New list :");
                        list.print();
                    } // if
                    scan.nextLine();

                } else if (str.equals("s")) { //search
                    int val = 0;
                    System.out.print("Enter a number to search: ");
                    val = scan.nextInt();
                    System.out.print("Original list :");
                    list.print();

                    ItemType item = new ItemType();
                    item.initialize(val);
                    list.searchItem(item);
                    scan.nextLine();

                } else if (str.equals("n")) { // nextItem

                    ItemType nextItem = list.getNextItem();

                    if (nextItem != null) {

                        System.out.println("" + nextItem.getValue() + "");
                    } // if
                } else if (str.equals("r")) { // reset
                    list.resetList();
                    System.out.println("Iterator is reset");
                } else if (str.equals("a")) { // delete alternate

                    System.out.print("Original list :");
                    list.print();

                    list.DeleteAlternateNodes();
                    System.out.print("New list :");
                    list.print();

                } else if (str.equals("m")) { // merge
                    int len = 0;
                    System.out.print("Enter the length of the new list: ");
                    len = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter the numbers: ");
                    String list2 = scan.nextLine();
                    String[] stringArray = list2.trim().split("\\s+");
                    int[] newListArray = new int[len];

                    for (int i = 0; i < len; i++) {
                        newListArray[i] = Integer.parseInt(stringArray[i]);
                        System.out.println(newListArray[i]);
                    }

                    list.mergeList(len, newListArray);


                } else if (str.equals("t")) { // intersection
                    int len = 0;
                    System.out.print("Enter the length of the new list: ");
                    len = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter the numbers: ");
                    String list2 = scan.nextLine();
                    String[] stringArray = list2.split(" ");
                    int[] newListArray = new int[len];

                    for (int i = 0; i < stringArray.length; i++) {
                        newListArray[i] = Integer.parseInt(stringArray[i]);
                    }

                    list.intersection(len, newListArray);
                } else if (str.equals("p")) { // print
                    System.out.print("The list is: ");
                    list.print();

                    System.out.println();

                } else if (str.equals("l")) { //length
                    System.out.print("Length of the new list is :");
                    System.out.println(list.getLength());

                } else if (str.equals("q")) { //quit

                    System.out.println("Exiting the program...");
                    System.exit(0);
                } else {
                    System.out.println("Invalid command");
                } // if-else
            } // while
        } // main
    } // class
