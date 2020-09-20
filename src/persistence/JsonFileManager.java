package persistence;
import com.google.gson.Gson;
import models.Patient;
import models.PatientFull;
import org.json.simple.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonFileManager {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1)
            sb.append((char) cp);
        String result = sb.toString();
        return result.replaceAll("\\\\n", "");

    }

    public static String readFileFromUrl(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                return readAll(rd);
            } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public PatientFull[] readJson(String url){
        String text = readFileFromUrl(url);
        return new Gson().fromJson(text, PatientFull[].class);
    }
}
