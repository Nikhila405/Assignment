package com.example.menusandpickers;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private String subMenuType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.share:
                showShare();
                return true;
            case R.id.dial:
                showDial();
                return true;
            case R.id.gallery:
                showgallery();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        if("coupons".equals(subMenuType))
        {
            inflater.inflate(R.menu.item, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }
    public void invalidateOptionsMenu(String type)
    {
        subMenuType = type;
        invalidateOptionsMenu();
    }

    public void showShare()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Message to send.");
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void showDial()
    {
        Uri a = Uri.parse("tel:1234567899");
        Intent i = new Intent(Intent.ACTION_DIAL, a);
        startActivity(i);
    }

    private void showgallery()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(intent);
    }
}