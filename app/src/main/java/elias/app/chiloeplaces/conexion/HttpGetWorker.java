package elias.app.chiloeplaces.conexion;

import android.content.Entity;
import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Elias on 17-01-15.
 */
public class HttpGetWorker<T> extends AsyncTask<String, Void, T> {

    private HashSet<AsyncTaskListener<T>> listeners;
    private final ObjectMapper mapper;
    private Class<T> beanClass;

    public HttpGetWorker(ObjectMapper mapper, Class<T> beanClass){

        this.mapper = mapper;
        this.beanClass = beanClass;
    }

    @Override
    protected T doInBackground(String... strings) {
        return process(strings[0]);
    }

    @Override
    protected void onPostExecute(T result) {

        for(AsyncTaskListener<T> listener : listeners){

            listener.proccessResult(result);
        }
    }

    public void addAsyncTaskListener(AsyncTaskListener<T> listener){
        if(listeners == null) listeners = new HashSet<AsyncTaskListener<T>>();
        listeners.add(listener);
    }

    private T process(String url){
        T data = null;
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json");
        try{
            HttpResponse resp = client.execute(httpGet);
            StatusLine statusLine = resp.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200){
                HttpEntity entity = resp.getEntity();
                String respStr = EntityUtils.toString(entity);
                data = mapper.readValue(respStr, beanClass);
            }else {

                Log.e("JSON", "Error al cargar el documento json");
            }
        }catch (IOException ex)
        {
            Log.e("HTTPGetWorker", ex.getLocalizedMessage(),ex);
        }

    }

}
