import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    // Arguments: User inputs 0 to 10 args to retrieve information from sorted dictionary.
    public static void userArguments(LinkedList<Node> dictionary){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter from 0 to 10 commands separated by a space:");
        String argument = scan.nextLine();
        scan.close();
        String[] commands = argument.split(" ");
        if (commands.length > 10){
            System.out.println("Invalid number of commands! Ending program...");
        }

        else{
            for (int i = 0; i < commands.length ; i++){
                try {
                    if (Integer.parseInt(commands [i]) == -1) {
                        BufferedReader reader1 = new BufferedReader(new FileReader("/Users/martinaarmas/PairProg/Sortedbyprogram.txt"));
                        BufferedReader reader2 = new BufferedReader(new FileReader("/Users/martinaarmas/PairProg/sortedDictTest.txt"));

                        String line1 = reader1.readLine();
                        String line2 = reader2.readLine();

                        boolean areEqual = true;
                        int lineNum = 1;

                        while (line1 != null || line2 != null) {
                            if (line1 == null || line2 == null) {
                                areEqual = false;
                                break;
                            } else if (!line1.equalsIgnoreCase(line2)) {
                                areEqual = false;
                                break;
                            }

                            line1 = reader1.readLine();
                            line2 = reader2.readLine();
                            lineNum++;
                        }

                        if (areEqual) {
                            System.out.println("Two files have same content.");
                        } else {
                            System.out.println("Two files have different content. They differ at line " + lineNum);
                            System.out.println("Sortedbyprogram has " + line1 + " and sortedDictTest has " + line2 + " at line " + lineNum);
                        }

                        reader1.close();

                        reader2.close();
                    } else {

                        System.out.println(dictionary.get(Integer.parseInt(commands[i])).data);
                    }
                }catch (Exception e){
                    for (int j = 0; j < dictionary.size(); j++){
                        if (commands[i].compareToIgnoreCase(dictionary.get(j).data) == 0){
                            System.out.println(j+1);
                            break;
                        }
                        if (j == dictionary.size() - 1){
                            System.out.println(-1);
                        }
                    }
                }
            }
        }


    }


    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();                            //Timer starts.
        File file = new File("unsortedDictTest.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Sortedbyprogram.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        Node head = null;
        String line;

        while ((line = br.readLine()) != null) {
            if (dictionary.isEmpty()) {
                head = new Node(line);
                dictionary.add(head);
            }
            else {
                head = dictionary.getFirst();
                if (head.next == null) {
                    if (head.data.compareToIgnoreCase(line) > 0) {
                        Node temp = head;
                        head = new Node(line);
                        head.next = temp;
                        dictionary.addFirst(head);
                    }
                    else {
                        Node temp = new Node(line);
                        head.next = temp;
                        dictionary.add(temp);
                    }
                }
                else {
                    Node current = head;
                    int index = 0;
                    while (current.next != null){
                        if (current.data.compareToIgnoreCase(line) > 0) {
                            Node temp = new Node(line);
                            temp.next = current;
                            if (index > 0){
                                dictionary.get(index - 1).next = temp;
                            }
                            dictionary.add(index, temp);
                            break;
                        }
                        else{
                            current = current.next;
                            if (current.next == null){
                                Node temp = new Node(line);
                                if (current.data.compareToIgnoreCase(line) > 0){
                                    temp.next = current;
                                    dictionary.get(index).next = temp;
                                    dictionary.add(index + 1, temp);
                                }
                                else{
                                    dictionary.getLast().next = temp;
                                    dictionary.addLast(temp);
                                }
                                break;
                            }
                            index ++;
                        }
                    }
                }
            }
        }
        br.close();

        for (int i = 0; i < dictionary.size(); i++) {
            bw.write(dictionary.get(i).data);
            bw.newLine();
        }

        bw.close();
        System.out.print("Time taken: ");
        System.out.print(System.currentTimeMillis() - start);   //Prints total sorting time
        System.out.println(" milliseconds.");
        userArguments(dictionary);                              //Execute method for user to enter arguments
    }
}
