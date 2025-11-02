package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Book book) {
        queue.addLast(book);
    }

    public Book dequeue() {
        return queue.removeFirst();
    }

    public Book peek(){
        return queue.getFirst();
    }

    public void display(){
        System.out.println("Queue contents (front to back):");
        for (int i = 0; i < queue.size(); i++) {
            Book book = queue.get(i);
            System.out.println(book);
        }
    }
}
