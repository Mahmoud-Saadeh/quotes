package quotes;

public class Quote {
    private final String author;
    private final String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Quote ==> \n" + author +
                " said:===>> \n" + text;
    }
}
