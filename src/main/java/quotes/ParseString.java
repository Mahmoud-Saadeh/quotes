package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class ParseString implements StringToJSON {
    private ArrayList<Quote> parsedData;
    private Quote quote = null;

    @Override
    public void convertString(String path) throws IOException {
        Gson gson = new Gson();
        FileToString stringFile = new FileToString();

        stringFile.readFile(path);
        parsedData = gson.fromJson(stringFile.getStringFile(), new TypeToken<ArrayList<Quote>>() {}.getType());
    }

    public boolean searchByAuthor(String author) {
        for (Quote q : parsedData) {
            if (q.getAuthor().equals(author)) {
                quote = q;
                return true;
            }
        }
        return false;
    }

    public void httpGetQuote() throws IOException {
        try {
            String data = QuoteReq.getQuoteReq();
            String path = "src/main/resources/recentquotes.json";
            convertString(path);

            Edit.writeFile(parsedData,data,path);

        } catch (IOException e) {
            System.out.println("Internet is not connected");
            convertString("src/main/resources/recentquotes.json");

            int random = App.randomQuote(parsedData.size());
            System.out.println("AT INDEX " + random + " " + parsedData.get(random));
        }
    }

    public Quote getQuote() {
        return quote;
    }

    public ArrayList<Quote> getParsedData() {
        return parsedData;
    }
}
