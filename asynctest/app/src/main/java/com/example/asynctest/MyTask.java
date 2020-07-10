package com.example.asynctest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask  extends AsyncTask<Void,Void,String>
{  String url="https://www.googleapis.com/books/v1/volumes?q=harry%20poter";
String myUrl;
Context ct;
ProgressDialog pd;
RecyclerView myrv;
    public MyTask(MainActivity mainActivity, String bookname, RecyclerView rv) {
        ct = mainActivity;
        myUrl=url+bookname;
        myrv=rv;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ct);
        pd.setMessage("Please wait.....");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u= new URL(url);
            HttpsURLConnection connection=(HttpsURLConnection) u.openConnection();
            InputStream is= connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuilder builder=new StringBuilder();
            while((line=reader.readLine())!=null){
                builder.append(line);
                
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        
        super.onPostExecute(s);
        Toast.makeText(ct, ""+s, Toast.LENGTH_SHORT).show();
        pd.dismiss();
        List<book>bookList=new ArrayList<>();
        try{
            JSONObject rootJsonObject = new JSONObject(s);
            JSONArray itemsJsonArray =rootJsonObject.getJSONArray("items");
            for(int i = 0;i<itemsJsonArray.length();i++){
                JSONObject indexObject = itemsJsonArray.getJSONObject(i);
                JSONObject volumeInfoObject = indexObject.getJSONObject("volumeInfo");
                String title = volumeInfoObject.optString("title");
                JSONArray myArray = volumeInfoObject.getJSONArray("authors");
                String authors = myArray.get(0).toString();
                JSONObject imagelinkObject=volumeInfoObject.getJSONObject("imageLinkname");
                String thumbnail=imagelinkObject.getString("thumbnail");
                Log.i("Data",title);
                book b = new book(title,authors,thumbnail);
                bookList.add(b);

/*Log.i("DATA",title);
Log.i("DATA",authors);*/
// myTextView.setText("Book Title:"+title+"\n"+"Authors:"+authors);
// Toast.makeText(ct, ""+title+"\n"+authors, Toast.LENGTH_SHORT).show();
            }
          Log.i("SIZE",""+bookList.size());
            myrv.setLayoutManager(new LinearLayoutManager(ct));
            myrv.setAdapter(new bookadapter(ct,bookList));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
