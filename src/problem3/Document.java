package problem3;

public class Document {
    private static int numOfDocs = 0;
    private int numRec;
    private String title;

    public Document(){}

    public Document(String title) {
        numOfDocs++;
        this.numRec = numOfDocs;
        this.title = title;
    }

    public int getNumRec() {
        return numRec;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){
        return "Title: " + title;
    }
}
