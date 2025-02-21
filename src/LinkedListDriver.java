import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The linked list driver class provides the scanner and user inupt portions of
 * the project and makes calls to DoublyLinkedList
 */
public class LinkedListDriver {

    /**
     * main method is what prompts the user and provides the desired output
     */
    public static void main(String[] args) {



        DoublyLinkedList<?> list;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");

        String dataType = scan.nextLine();

        if (dataType.equals("i")) {
            list = new DoublyLinkedList<Integer>();
        } else if (dataType.equals("d")) {
            list = new DoublyLinkedList<String>();
        } else {
            list = new DoublyLinkedList<Double>();
        }

        String fileName = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {

                try {

                    String[] content = line.split("\\s+");
                    for (String item : content) {
                        insertToList(list, item, dataType);
                    } // for
                    } catch (NumberFormatException e) {
                    } // catch
                } // while
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }  // Print the sorted list
            System.out.println("Doubly Linked List:");
            list.print();

            System.out.println("Commands:\n");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(t) - print reverse");
            System.out.println("(r) - Reverse list");
            System.out.println("(b) - Delete Subsection");
            System.out.println("(s) - Swap Alternate");
            System.out.println("(q) - Quit program");

            String str = "";
            while (str != "q") {
                System.out.print("Enter a command: ");
                str = scan.nextLine();

                if (str.equals("i")) { // insert
                    System.out.print("Enter a number to insert: ");
                    String item = scan.nextLine();

                System.out.print("Original list :");
                    list.print();
                    insertToList(list, item, dataType);
                    System.out.print("New list :");
                    list.print();

                } else if (str.equals("d")) { // delete
                    System.out.print("Enter a number to delete: ");
                    String item = scan.nextLine();
                    System.out.print("Original list :");
                    list.print();
                    deleteFromList(list, item, dataType);
                    if(list != null) {
                        System.out.print("New list :");
                        list.print();
                    } // if

                } else if (str.equals("p")) { // print
                    System.out.print("The list is: ");
                    list.print();

                    System.out.println();

                } else if (str.equals("l")) { //length
                    System.out.print("Length of the new list is :");
                    System.out.println(list.length());

                } else if (str.equals("t")) { // print reverse
                    System.out.print("The list is: ");
                    list.printReverse();

                } else if (str.equals("r")) {
                    list.reverseList();

                } else if (str.equals("b")) {
                    System.out.print("Enter the lower bound: ");
                    String item1 = scan.nextLine();
                    System.out.print("Enter the upper bound: ");
                    String item2 = scan.nextLine();
                    System.out.print("The original list: ");
                    list.print();
                    deleteSubFromList(list, item1, item2, dataType);
                    System.out.print("The modified list: ");
                    list.print();
                } else if (str.equals("s")) {
                    System.out.println("The original list: ");
                    list.print();
                    list.swapAlternat();
                    System.out.println("The modified list: ");
                    list.print();

                } else if (str.equals("q")) { //quit

                    System.out.println("Exiting the program...");
                    System.exit(0);
                } else {
                    System.out.println("Invalid command");
                } // if-else
            } // while


    } // main

    // Generic method to insert items safely
    private static <T extends Comparable<T>> void insertToList(DoublyLinkedList<T> list,
    String value, String type) {
        T itemParsed = parseGeneric(value, type);
        list.insertItem(itemParsed);
    }

    // Generic method to delete items safely
    private static <T extends Comparable<T>> void deleteFromList(DoublyLinkedList<T> list,
    String value, String type) {
        T itemParsed = parseGeneric(value, type);
        list.deleteItem(itemParsed);
    }

    private static <T extends Comparable<T>> void deleteSubFromList(DoublyLinkedList<T> list,
    String value1, String value2, String type) {
        T lowerBoundParsed = parseGeneric(value1, type);
        T upperBoundParsed = parseGeneric(value2, type);
        list.deleteSubsection(lowerBoundParsed, upperBoundParsed);
    }
    private static <T extends Comparable<T>> T parseGeneric(String item, String type) {
        if (type.equals("i")) {return (T) Integer.valueOf(item);}
        else if (type.equals("d")) { return (T) Double.valueOf(item);}
        else {return (T) item;}

    }

} // class
