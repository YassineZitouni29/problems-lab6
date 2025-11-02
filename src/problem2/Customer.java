package problem2;

import java.util.ArrayList;
public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();
    private Bank bank;

    public Customer(String name) {
        this.name = name;
    }

    public boolean addTransactionToCustomer(double amount, Customer customer){
        if (this.bank.getCustomers().contains(customer)) {
            customer.addTransaction(amount);
            return true;
        }
        return false;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    private void addTransaction(double amount){
        transactions.add(amount);
    }

    public String  getName(){
        return this.name;
    }
    public ArrayList<Double> getTransactions(){
        return this.transactions;
    }
}
