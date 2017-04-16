import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mohammedissa on 3/14/16.
 */

public class Library {



    Scanner scan = null;

    LinkedList libary = new LinkedList();











    private void load(File data) throws FileNotFoundException {


        scan = new Scanner(data);

        while (scan.hasNextLine()) {


            String line = null;

            line = scan.nextLine();

            String[] info = null;

            info = line.split(":");

            Book book = new Book(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]));

            libary.add(book);




        }
    }

    private void purchase(Book book){

        String name = book.name;

        Book current = searchByName(name);

        if(current == null){
            libary.add(book);
        }
        else {

            current.quantity++;
        }

    }

    private boolean sale(String name){

        Book current = searchByName(name);
        if(current.quantity>1)
            current.quantity --;

        else if(current.quantity == 1){

            libary.remove(current);
        }
        else
        {
         return false;
        }


    }

    private Book searchByName(String name){


        LinkedList.Node temp = libary.head; //katabna linked list 3ashan al node mawjoda jowah bas lma t3ml inta bt7thfha
        Book book = (Book)temp.data;//hay 3ashan n3ml cast ll data ille jowa al node

        while (temp.next != null){



            if(book.name.equals(name))
                return book;
            else
            {
                temp = temp.next;
                continue;
            }

        }
        return null;


    }











}

