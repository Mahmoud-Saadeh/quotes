package quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuoteReq {
    public static String getQuoteReq() throws IOException {
        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        connection.setRequestMethod("GET");
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String data = bufferedReader.readLine();
        bufferedReader.close();
        return data;
    }
}
