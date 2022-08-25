import java.io.*;
import java.lang.module.FindException;
import java.net.BindException;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main_sort {
    public static void main(String[] args){

        Algorithm t = new Algorithm();
        Scanner sc = new Scanner(System.in);
        int n,choice;
         float[] arr= null;
        while(true) {
            menu();
            choice = sc.nextInt();
            // Exit menu
            if(choice==0){
                System.out.println("Thanks!!!");
                break;
            }
            switch (choice){
                case 1:
                  arr= t.input(arr);
                   t.writeFile(arr,"input.txt");
                    break;
                case 2:
                    t.readFile("input.txt");
                    break;
                case 3:
                    // write arr to file output1
                    float [] b = t.bubbleSort(arr,true);
                    t.writeFile(b,"output1.txt");
                    break;
                case 4:
                     b = t.selectionSort(arr);
                    t.writeFile(b,"output2.txt");
                    break;
                case 5:
                     b = t.insertionSort(arr);
                    t.writeFile(b,"output3.txt");
                    break;
                case 6:
                    String index=t.search(arr);
                    t.writeFileSearch(index,"output4.txt");
                    break;
                case 7:
                    index = t.binarySearch(arr);
                    t.writeFileSearch(index,"output5.txt");
            }
        }

    }
    public static void menu(){
        // display menu
        System.out.println("+--------------------Menu----------------------+");
        System.out.println("|     1.Input                                  |");
        System.out.println("|     2.Output                                 |");
        System.out.println("|     3.Bubble sort                            |");
        System.out.println("|     4.Selection sort                         |");
        System.out.println("|     5.Insertion sort                         |");
        System.out.println("|     6.Search > value                         |");
        System.out.println("|     7.Search = value                         |");
        System.out.println("|     0.Exit                                   |");
        System.out.println("+----------------------------------------------+");
        System.out.print("Choice:");
    }
}
