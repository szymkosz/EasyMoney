package com.example.bella.secondconscience;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by szymonkoszarek on 3/26/18.
 */
//
//public class GetSentimentAsyncTask extends AsyncTask {
//}

//package com.example.bella.secondconscience;
// TEXT ANALYTICS

//        import android.os.AsyncTask;
//
//        import com.google.gson.Gson;
//        import com.google.gson.GsonBuilder;
//        import com.google.gson.JsonObject;
//        import com.google.gson.JsonParser;
//
//        import java.io.BufferedReader;
//        import java.io.DataOutputStream;
//        import java.io.InputStreamReader;
//        import java.net.URL;
//        import java.util.ArrayList;
//        import java.util.List;
//
//        import javax.net.ssl.HttpsURLConnection;

/*
 * Gson: https://github.com/google/gson
 * Maven info:
 *     groupId: com.google.code.gson
 *     artifactId: gson
 *     version: 2.8.1
 *
 * Once you have compiled or downloaded gson-2.8.1.jar, assuming you have placed it in the
 * same folder as this file (GetSentiment.java), you can compile and run this program at
 * the command line as follows.
 *
 * javac GetSentiment.java -classpath .;gson-2.8.1.jar -encoding UTF-8
 * java -cp .;gson-2.8.1.jar GetSentiment
 */

//class Document {
//    public String id, language, text;
//
//    public Document(String id, String language, String text){
//        this.id = id;
//        this.language = language;
//        this.text = text;
//    }
//}
//
//class Documents {
//    public List<Document> documents;
//
//    public Documents() {
//        this.documents = new ArrayList<Document>();
//    }
//    public void add(String id, String language, String text) {
//        this.documents.add (new Document (id, language, text));
//    }
//}

public class GetSentimentAsyncTask extends AsyncTask<Documents, Void, String> {

// ***********************************************
// *** Update or verify the following values. ***
// **********************************************

    // Replace the accessKey string value with your valid access key.
    static String accessKey = "38b171a9e2b6436c941cb26f0f953849";

    // Replace or verify the region.

    // You must use the same region in your REST API call as you used to obtain your access keys.
    // For example, if you obtained your access keys from the westus region, replace
    // "westcentralus" in the URI below with "westus".

    // NOTE: Free trial access keys are generated in the westcentralus region, so if you are using
    // a free trial access key, you should not need to change this region.
    static String host = "https://westcentralus.api.cognitive.microsoft.com";

    static String path = "/text/analytics/v2.0/sentiment";

    protected void onPostExecute(Documents documents) {

        // return text;
    }

    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    @Override
    protected String doInBackground(Documents... documents) {
        Documents docs = new Documents();
        try
        {
            docs = documents[0];
            String text = new Gson().toJson(documents);
            byte[] encoded_text = text.getBytes("UTF-8");

            // StringBuilder input = new StringBuilder ();
            // String json = new String("{  "documents": [    {      "id": "0",      "text": ");
            // json += text + "    }  ]}"

            URL url = new URL(host + path);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/json");
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", accessKey);
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(encoded_text, 0, encoded_text.length);
            wr.flush();
            wr.close();

            StringBuilder response = new StringBuilder();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    protected Object doInBackground(Object[] objects) {
//        return null;
//    }

//    public static void main (String[] args) {
//        try {
//            // Documents documents = new Documents ();
//            // documents.add ("1", "en", "I really enjoy the new XBox One S. It has a clean look, it has 4K/HDR resolution and it is affordable.");
//            // documents.add ("2", "es", "Este ha sido un dia terrible, llegué tarde al trabajo debido a un accidente automobilistico.");
//
//            HttpURLConnect http = new HttpURLConnect();
//
//            String first = http.sendGet("Nobody loves you");
//            System.out.println(HttpURLConnect.findScore(first));
//
//
//            // String response = GetSentiment (documents);
//            String response = GetSentiment ("I really enjoy the new XBox One S. It has a clean look, it has 4K/HDR resolution and it is affordable.");
//            System.out.println (response);
//        }
//        catch (Exception e) {
//            System.out.println (e);
//        }
//    }
}

