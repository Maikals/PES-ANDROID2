package com.pes.maikals.subscriptor.ServiceLayer;

import com.pes.maikals.subscriptor.Domini.Val;

import java.util.ArrayList;

/**
 * Created by maikals on 04/01/15.
 */

public class ApiService {

    static public ArrayList<Val> getVals(String email) {
       /* Log.d("ApiService", "mail i pass aconseguits cridat " + email);
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://pes.ivy-corp.com/api/vals?email="+email);
        Log.d("ApiService", "intentem connexió");*/
        ArrayList<Val> vals = new ArrayList<Val>();
        /*try {
            // Execute HTTP Post Request

            HttpResponse response = httpclient.execute(httpget);
            Log.d("com.pes.maikals.subscriptor", "post executat");
            String result = EntityUtils.toString(response.getEntity());
            Log.d("com.pes.maikals.subscriptor", result);
            JSONObject jsonObj = new JSONObject(result);
            // CONVERT RESPONSE STRING TO JSON ARRAY
            JSONArray ja = jsonObj.getJSONArray("vals");
            int n = ja.length();
            for (int i = 0; i < n; i++) {
                JSONObject jo = ja.getJSONObject(i);
                String nomSubscripcio = jo.getString("nomSubscripcio");
                int id = jo.getInt("id");
                Val v = new Val(id, nomSubscripcio);
                vals.add(v);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return vals;
    }

    static public int login(String email, String password) {
       // Log.d("com.pes.maikals.subscriptor", "mail i pass aconseguits cridat " + email + " " + password);
        //HttpClient httpclient = new DefaultHttpClient();
        //HttpPost httppost = new HttpPost("http://pes.ivy-corp.com/api/checkauth");
        //Log.d("com.pes.maikals.subscriptor", "intentem connexió");

        int stat = 0;
        /*try {
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
        }*/
        return stat;
    }
}
