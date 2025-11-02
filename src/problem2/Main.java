package problem2;

public class Main {

    public static void main(String[] args){
        Bank bank = new Bank("BMCE");
        Customer customer1 = new Customer("Yassine");
        Customer customer2 = new Customer("Rhita");
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.summary();
        customer1.addTransactionToCustomer(10000, customer2);
        bank.summary();
        customer1.addTransactionToCustomer(9000, customer1);
        customer2.addTransactionToCustomer(-100, customer2);
        bank.summary();
    }
}
