package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents = new ArrayList<>();
    public Library(int capacity) {
        this.capacity = capacity;
    }
    public boolean add(Document doc){
        if (documents.size()<capacity && !documents.contains(doc)){
            documents.add(doc);
            return true;
        }
        return false;
    }
    public boolean delete(Document doc){
        if (documents.contains(doc)){
            documents.remove(doc);
            return true;
        }
        return false;
    }
    public void displayDocuments(){
        for (Document doc : documents){
            System.out.println(doc);
        }
    }

    public Document document(int numRec){
        for (Document doc : documents){
            if (numRec == doc.getNumRec()){
                return doc;
            }
        }
        return null;
    }

    public void DisplayAuthors(){
        for (Document doc : documents){
            if (doc instanceof Book){
                Book book = (Book) doc;
                System.out.println(book.getAuthor());
            }
        }
    }
}
