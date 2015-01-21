package elias.app.chiloeplaces.conexion;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

import elias.app.chiloeplaces.clases.JSONBean;

/**
 * Created by Elias on 18-01-15.
 */
public class HttpPostWorker<T> extends AsyncTask<JSONBean, Void, List<String>> {

    private HashSet<AsyncTaskListener<List<String>>> listeners;
    private final ObjectMapper mapper;
    private final String url;
    private Class<T> beanClass;

    public HttpPostWorker(ObjectMapper mapper, String url) {
        this.mapper = mapper;
        this.url = url;
    }

    @Override
    protected List<String> doInBackground(JSONBean... params) {

        ArrayList<String> list = new ArrayList<String>();
        for (JSONBean bean : params) list.add(process(bean));
        return list;
    }

    private String process(JSONBean bean) {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type","Application/json");
        try {
            String data = mapper.writeValueAsString(bean);
            StringEntity entity = new StringEntity(data);
            httpPost.setEntity(entity);
            HttpResponse res = client.execute(httpPost);
            String respStr = EntityUtils.toString(res.getEntity());
            updateServerId(respStr, bean);
        }catch (IOException ex){
            Log.e("HttpPostWorker", ex.getLocalizedMessage(), ex);
        }

        return builder.toString();
    }

    private void updateServerId(String respStr, JSONBean bean) {

        try {
            JsonNode node = mapper.readTree(respStr);
            int serverId = node.path("serverId").asInt();
            Log.e("Server ID recibido", String.valueOf(serverId));
            bean.setServerId(serverId);
            Intent intent = new Intent(ContactReciver)
        }
    }

    @Override
    protected void onPostExecute(List<String> result) {
        for (AsyncTaskListener<T> listener : listeners){
            listener.processResult(result);
        }
    }

    public void addAsyncTaskListener(AsyncTaskListener<List<String>> listener){
        if(listeners == null) listeners = new HashSet<AsyncTaskListener<T>>();
        listeners.add(listener);
    }
}
