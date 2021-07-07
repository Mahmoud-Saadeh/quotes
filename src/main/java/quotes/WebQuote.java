package quotes;

public class WebQuote {
    private final String quoteText;
    private final String quoteAuthor;

    public WebQuote(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    @Override
    public String toString() {
        return "Quote ==> \n" + quoteAuthor +
                " said:===>> \n" + quoteText;
    }
}
