package problem3;

public class Book extends Document {
    private String author;
    private int nbrPages;

    public Book(String title, String author, int nbrPages) {
        super(title);
        this.author = author;
        this.nbrPages = nbrPages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        String res = super.toString();
        res += ", Author: " + author;
        res += ", Nbr Pages: " + nbrPages;
        return res;
    }
}
