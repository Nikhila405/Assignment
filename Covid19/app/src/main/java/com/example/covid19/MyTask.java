package com.example.covid19;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void, Void, String>
{
    Context ct;
    RecyclerView recyclerView;
    ProgressDialog pd;
    String URL = "https://api.covid19api.com/dayone/country/IN";

    public MyTask(MainActivity mainActivity, RecyclerView rv)
    {
        ct = mainActivity;
        recyclerView = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ct);
        pd.setMessage("Displaying Covid 19 stats");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(URL);
            HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while((line = reader.readLine())!=null) {
                builder.append(line);
            }
            return builder.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        try
        {
            JSONArray IndiaJSON = new JSONArray(s);
            List<Details> Covid = new ArrayList<>();
            for(int i = IndiaJSON.length()-1; i>=0; i--) {
                JSONObject Date = IndiaJSON.getJSONObject(i);
                String item = Date.optString("Date");
                String date = "";
                for(int k = 0; k<item.length(); k++) {
                    if(item.charAt(k)=='T') {
                        break;
                    }
                    else {
                        date+=item.charAt(k);
                    }
                }
                String active = Date.optString("Active");
                String death = Date.optString("Deaths");
                String recovered = Date.optString("Recovered");
                Details covid = new Details(active, death, recovered, date);
                Covid.add(covid);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(ct));
            DetailsAdapter adapter = new DetailsAdapter(ct, Covid);
            recyclerView.setAdapter(adapter);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}