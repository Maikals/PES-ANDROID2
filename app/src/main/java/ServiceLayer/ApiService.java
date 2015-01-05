package ServiceLayer;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maikals on 04/01/15.
 */
public class ApiService {

    static public int login(String email, String password) {
        Log.d("com.pes.maikals.subscriptor", "mail i pass aconseguits cridat " + email + " " + password);
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://pes.ivy-corp.com/api/checkauth");
        Log.d("com.pes.maikals.subscriptor", "intentem connexió");

        int stat = 0;
        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", email));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request

            HttpResponse response = httpclient.execute(httppost);
            Log.d("com.pes.maikals.subscriptor", "post executat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            String json = reader.readLine();
            JSONTokener tokener = new JSONTokener(json);
            stat = Integer.parseInt(tokener.next(3));
        } catch (UnsupportedEncodingException e) {
            Log.d("com.pes.maikals.subscriptor", "error 1");

            e.printStackTrace();
        } catch (IOException e) {
            Log.d("com.pes.maikals.subscriptor", "error 2");

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stat;
    }
}
