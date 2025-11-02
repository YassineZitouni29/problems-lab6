package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        String itemName;
        double itemPrice;
        int quantity;
        double price = 0;

        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            // *** create a new item and add it to the cart
            Item item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            price+=itemPrice*quantity;
            // *** print the contents of the cart object using println
            for (int i = 0; i<cart.size(); i++){
                Item temp =  cart.get(i);
                System.out.printf("Item: %s , price: %.2f , quantity: %d\n", temp.getName(), temp.getPrice(), temp.getQuantity());
            }
            System.out.printf("The total price is : %.2f\n", price);
            scan.nextLine();
            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
