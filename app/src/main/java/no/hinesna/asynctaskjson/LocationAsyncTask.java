package no.hinesna.asynctaskjson;

import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by christerhansen on 23.03.15.
 */
public class LocationAsyncTask extends AsyncTask<String, Integer, Long>{

    @Override
     protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Long doInBackground(String... params) {
        return null;
    }


    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
    }
}
