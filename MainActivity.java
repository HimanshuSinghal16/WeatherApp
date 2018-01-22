package com.example.android.weatherforcast;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

import static java.lang.Double.*;

public class MainActivity extends AppCompatActivity {
    DownloadTask task;
    TextView summary;
    TextView Temperature;
    String Summary = null;
    String my=null;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Double temp=0.0;
    int himanshu=0;
    RelativeLayout secondLayout;
    TextView nameOfCity;
    RelativeLayout firstLayout;
    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = " ";
            URL url;
            HttpsURLConnection urlConnection = null;
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "URL Failed";
        }

    }

    public void onClick(View view) throws ExecutionException, InterruptedException {
        secondLayout.setVisibility(View.VISIBLE);
        String result = null;
        DownloadTask task = new DownloadTask();
        if (view.getTag().toString().equals(Integer.toString(1))) {

            nameOfCity.setText(button1.getText().toString());
            try {
                result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/28.7041,77.1025").get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String[] himan = result.split("\"currently\":");
            String[] wheatherSmmary = himan[1].split(",\"minutely\"");
            Log.i("Weather Summary", wheatherSmmary[0]);
            Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
            Matcher m = p.matcher(wheatherSmmary[0]);
            while (m.find()) {
               // Log.i("SUMMARY", m.group(1));
           Summary=m.group(1);
           continue;
            }
            summary.setText(Summary);
            p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
            m = p.matcher(wheatherSmmary[0]);
            String temperature=" ";
            while (m.find()) {
                Log.i("Temperature=>", m.group(1));
                temperature=m.group(1);
                continue;
            }
            temp = Double.parseDouble(temperature);
            temp = (temp - 32.0) * (5.0 / 9.0);
            himanshu = (int) Math.round(temp);
            my=String.valueOf(himanshu);;
            Temperature.setText(my+ "\u00B0");
        }

       if (view.getTag().toString().equals(Integer.toString(2))) {
            nameOfCity.setText(button2.getText().toString());
           try {
               result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/26.9124,75.7873").get();
           }
           catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
           String[] himan = result.split("\"currently\":");
           String[] wheatherSmmary = himan[1].split(",\"minutely\"");
           Log.i("Weather Summary", wheatherSmmary[0]);
           Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
           Matcher m = p.matcher(wheatherSmmary[0]);
           while (m.find()) {
               // Log.i("SUMMARY", m.group(1));
               Summary=m.group(1);
               continue;
           }
           summary.setText(Summary);
           p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
           m = p.matcher(wheatherSmmary[0]);
           String temperature=" ";
           while (m.find()) {
               Log.i("Temperature=>", m.group(1));
               temperature=m.group(1);
               continue;
           }
           temp = Double.parseDouble(temperature);
           temp = (temp - 32.0) * (5.0 / 9.0);
           himanshu = (int) Math.round(temp);
           my=String.valueOf(himanshu);;
           Temperature.setText(my+ "\u00B0");


        }

        if (view.getTag().toString().equals(Integer.toString(3))) {
            nameOfCity.setText(button3.getText().toString());
            try {
                result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/23.0225,72.5714").get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String[] himan = result.split("\"currently\":");
            String[] wheatherSmmary = himan[1].split(",\"minutely\"");
            Log.i("Weather Summary", wheatherSmmary[0]);
            Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
            Matcher m = p.matcher(wheatherSmmary[0]);
            while (m.find()) {
                // Log.i("SUMMARY", m.group(1));
                Summary=m.group(1);
                continue;
            }
            summary.setText(Summary);
            p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
            m = p.matcher(wheatherSmmary[0]);
            String temperature=" ";
            while (m.find()) {
                Log.i("Temperature=>", m.group(1));
                temperature=m.group(1);
                continue;
            }
            temp = Double.parseDouble(temperature);
            temp = (temp - 32.0) * (5.0 / 9.0);
            himanshu = (int) Math.round(temp);
            my=String.valueOf(himanshu);;
            Temperature.setText(my+ "\u00B0");
        }

        if (view.getTag().toString().equals(Integer.toString(4))) {
            nameOfCity.setText(button4.getText().toString());
            try {
                result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/34.083656,74.797371").get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String[] himan = result.split("\"currently\":");
            String[] wheatherSmmary = himan[1].split(",\"minutely\"");
            Log.i("Weather Summary", wheatherSmmary[0]);
            Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
            Matcher m = p.matcher(wheatherSmmary[0]);
            while (m.find()) {
                // Log.i("SUMMARY", m.group(1));
                Summary=m.group(1);
                continue;
            }
            summary.setText(Summary);
            p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
            m = p.matcher(wheatherSmmary[0]);
            String temperature=" ";
            while (m.find()) {
                Log.i("Temperature=>", m.group(1));
                temperature=m.group(1);
                continue;
            }
            temp = Double.parseDouble(temperature);
            temp = (temp - 32.0) * (5.0 / 9.0);
            himanshu = (int) Math.round(temp);
            my=String.valueOf(himanshu);;
            Temperature.setText(my+ "\u00B0");



        }

        if (view.getTag().toString().equals(Integer.toString(5))) {
            nameOfCity.setText(button5.getText().toString());
            try {
                result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/13.0827,80.2707").get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String[] himan = result.split("\"currently\":");
            String[] wheatherSmmary = himan[1].split(",\"minutely\"");
            Log.i("Weather Summary", wheatherSmmary[0]);
            Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
            Matcher m = p.matcher(wheatherSmmary[0]);
            while (m.find()) {
                // Log.i("SUMMARY", m.group(1));
                Summary=m.group(1);
                continue;
            }
            summary.setText(Summary);
            p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
            m = p.matcher(wheatherSmmary[0]);
            String temperature=" ";
            while (m.find()) {
                Log.i("Temperature=>", m.group(1));
                temperature=m.group(1);
                continue;
            }
            temp = Double.parseDouble(temperature);
            temp = (temp - 32.0) * (5.0 / 9.0);
            himanshu = (int) Math.round(temp);
            my=String.valueOf(himanshu);;
            Temperature.setText(my+ "\u00B0");

            //result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/13.0827,80.2707").get();


        }
        if (view.getTag().toString().equals(Integer.toString(6))) {
            nameOfCity.setText(button6.getText().toString());
            try {
                result = task.execute("https://api.darksky.net/forecast/24dc1aa712a1d8c7722b866a6e4bb426/19.0760,72.8777").get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            String[] himan = result.split("\"currently\":");
            String[] wheatherSmmary = himan[1].split(",\"minutely\"");
            Log.i("Weather Summary", wheatherSmmary[0]);
            Pattern p = Pattern.compile("\"summary\":(.*?),\"icon\"");
            Matcher m = p.matcher(wheatherSmmary[0]);
            while (m.find()) {
                // Log.i("SUMMARY", m.group(1));
                Summary=m.group(1);
                continue;
            }
            summary.setText(Summary);
            p = Pattern.compile("\"temperature\":(.*?),\"apparentTemperature");
            m = p.matcher(wheatherSmmary[0]);
            String temperature=" ";
            while (m.find()) {
                Log.i("Temperature=>", m.group(1));
                temperature=m.group(1);
                continue;
            }
            temp = Double.parseDouble(temperature);
            temp = (temp - 32.0) * (5.0 / 9.0);
            himanshu = (int) Math.round(temp);
            my=String.valueOf(himanshu);;
            Temperature.setText(my+ "\u00B0");



        }

        button1.setAlpha(0f);
        button2.setAlpha(0f);
        button3.setAlpha(0f);
        button4.setAlpha(0f);
        button5.setAlpha(0f);
        button6.setAlpha(0f);

        }

    public void goBack(View view) {

        secondLayout.setVisibility(View.INVISIBLE);
        button1.setAlpha(1f);
        button2.setAlpha(1f);
        button3.setAlpha(1f);
        button4.setAlpha(1f);
        button5.setAlpha(1f);
        button6.setAlpha(1f);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        secondLayout = (RelativeLayout) findViewById(R.id.secondLayout);
        nameOfCity = (TextView) findViewById(R.id.nameOfCity);
        Temperature = (TextView) findViewById(R.id.Tempreature);
        summary = (TextView) findViewById(R.id.summary);


    }
}
