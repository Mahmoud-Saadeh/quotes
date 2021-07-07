package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Edit {
    public static void writeFile(ArrayList<Quote> parsedData, String data, String path) throws IOException {
        Gson gson = new Gson();
        WebQuote webQuote = gson.fromJson(data, WebQuote.class);
        Quote NewQuote = new Quote(webQuote.getQuoteAuthor(),webQuote.getQuoteText());
        parsedData.add(NewQuote);
        String json = gson.toJson(parsedData);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(dos, StandardCharsets.UTF_8.newEncoder()));
        bw.write(json);
        bw.close();
//        dos.writeBytes(json);
//        dos.close();
//        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
////            bw.flush();
//        bw.write(json);
//        bw.close();

        System.out.println("the quoteText is >>> " + webQuote.getQuoteText());
        System.out.println("the quoteAuthor is >>> " + webQuote.getQuoteAuthor());
    }
}
