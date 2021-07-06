package quotes;

import com.google.gson.Gson;

import java.io.IOException;

public class ParseString implements StringToJSON{
    private Quote[] parsedData;
    private Quote quote = null;
    @Override
    public void convertString(String path) throws IOException {
        Gson gson = new Gson();
        FileToString stringFile = new FileToString();

        stringFile.readFile(path);
        parsedData = gson.fromJson(stringFile.getStringFile(), Quote[].class);
    }

    public boolean searchByAuthor(String author){
        for (Quote q : parsedData) {
            if (q.getAuthor().equals(author)){
                quote = q;
                return true;
            }
        }
        return false;
    }

    public Quote getQuote() {
        return quote;
    }

    public Quote[] getParsedData() {
        return parsedData;
    }
}
