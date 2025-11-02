package problem3;

public class Dictionary extends Document{
    private String language;

    public Dictionary(String title ,String language) {
        super(title);
        this.language = language;
    }

    @Override
    public String toString(){
        String res = super.toString();
        res+=", Language: " + language;
        return res;
    }
}
