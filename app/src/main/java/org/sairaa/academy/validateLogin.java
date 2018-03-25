package org.sairaa.academy;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.R.attr.type;

/**
 * Created by praful on 12/24/2017.
 */

public class validateLogin extends AsyncTask<String,Void,String> {

    Context context;
    final String LOG_LOGIN = "validateLogin";

    public validateLogin(Login login) {
        context = login;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String... params) {
        //String type = params[0];
        //String login_url = "http://sairaa.org/academy/triveni/login.php";
        String login_url = params[0];


            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                Log.i(LOG_LOGIN," : "+params[0]+"  "+params[1]+"  "+params[2]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+
                        "&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";

                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
