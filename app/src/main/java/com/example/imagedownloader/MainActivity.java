package com.example.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ImageView dope;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dope = findViewById(R.id.imageView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream io = urlConnection.getInputStream();
                Bitmap myypic = BitmapFactory.decodeStream(io);
                return myypic;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void downloadImage(View view) {
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage = null;
        try {
           //https://1.bp.blogspot.com/-yi56eGXFgac/UPT7UWcrDtI/AAAAAAAADQ8/xKuV-Ou9cVI/s1600/zindagi+gulzar+hai+OST+(1).png
if(c==0) {
    myImage = task.execute("https://duexpress.in/wp-content/uploads/2016/09/Zindagi-Gulzar-Hai.png").get();
    c = 1;
}
else if(c==1)
{myImage = task.execute("https://i.pinimg.com/originals/5d/e9/df/5de9df7f30d2e9f63127c19ffec39f92.png").get();
    c = 2;

}
else if(c==2)
{
    myImage = task.execute("https://atulmalikram.files.wordpress.com/2016/07/zindagi-gulzar-hai.png?w=474").get();
    c = 3;
}
            else if(c==3)
            {
                myImage = task.execute(" https://bollyviewer.files.wordpress.com/2016/04/zgh_160.png?w=450&h=312&zoom=2").get();
                c = 4;
            }
            else if(c==4)
            {
                myImage = task.execute("https://bollyviewer.files.wordpress.com/2016/04/zgh_116.png?w=450&h=312&zoom=2").get();
                c = 5;
            }
            else if(c==5)
            {
                myImage = task.execute("https://bollyviewer.files.wordpress.com/2016/04/zgh_136.png?w=450&h=330&zoom=2").get();
                c = 6;
            }
            else if(c==6)
            {
                myImage = task.execute("https://bollyviewer.files.wordpress.com/2016/04/zgh_179.png?w=450&h=312&zoom=2").get();
                c = 7;
            }
            else if(c==7)
            {
                myImage = task.execute("https://bollyviewer.files.wordpress.com/2016/04/zgh_167.png?w=450&h=312&zoom=2").get();
                c = 8;
            }
else if(c==8)
{
    myImage = task.execute("https://bollyviewer.files.wordpress.com/2016/04/zgh_165.png?w=450&h=330&zoom=2").get();
    c = 9;
}
else
{
    myImage = task.execute("https://cdn.mangobaaz.com/wp-content/uploads/2017/12/kashaf-zgh-7.png").get();
    c = 0;
}


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        dope.setImageBitmap(myImage);


    }
}
