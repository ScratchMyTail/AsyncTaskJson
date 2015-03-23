package no.hinesna.asynctaskjson;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Collections;

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
        String url = params[0];
        // Set the Accept header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the Gson message converter
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());

        // Make the HTTP GET request, marshaling the response from JSON to an array of Events
        ResponseEntity<By> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, By.class);
        By by = responseEntity.getBody();
        Log.d("LocationAsyncTask", by.getSted());
        Log.d("LocationAsyncTask", by.getUrl());
        return null;
    }


    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
    }
}
