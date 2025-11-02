package problem2;
import problem1.Item;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public boolean addCustomer(Customer customer){
        if (customers.contains(customer)){
            return false;
        }
        customers.add(customer);
        customer.setBank(this);
        return true;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public void summary(){
        System.out.println("Customers:");
        for (Customer customer : customers){
            System.out.println(customer.getName());
            System.out.println(customer.getTransactions());
            System.out.println();
        }
    }
}
