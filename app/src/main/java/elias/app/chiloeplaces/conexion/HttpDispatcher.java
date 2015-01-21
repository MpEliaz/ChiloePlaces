package elias.app.chiloeplaces.conexion;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.content.Context
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.ConnectException;

import elias.app.chiloeplaces.clases.JSONBean;

/**
 * Created by Elias on 17-01-15.
 */
public class HttpDispatcher {

    private final Context context;
    private ObjectMapper mapper;
    private final String BASE_URL_ADDRESS = "http://$s:$s/api/";
    private final String SERVER_ADDRESS = "mi ip";
    private final String SERVER_PORT = "8000";
    private final String REGISTRY_OWNER = "";

    public HttpDispatcher(Context context) {
        this.context = context;

        mapper = new ObjectMapper();

        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    }

    public <T> void doGet(Class<T> resultType, AsyncTaskListener<T> listener){

        StringBuilder builder = new StringBuilder(String.format(BASE_URL_ADDRESS,SERVER_ADDRESS,SERVER_PORT));
        String url = builder.append("lugares/").toString();

        if(wifiEnabled())
        {
            // TODO: implementar HTTP GETWORKER
        }else {
            Toast.makeText(context,"Wifi desabilitado",Toast.LENGTH_LONG).show();
        }
    }

    public void doPost(JSONBean bean, AsynctaskListener<List<String>> listener){

        StringBuilder builder = new StringBuilder(String.format(BASE_URL_ADDRESS,SERVER_ADDRESS,SERVER_PORT));
        String url = builder.append("lugares/").toString();

        if(wifiEnabled())
        {
            // TODO: implementar HTTP POSTWORKER
        }else {
            Toast.makeText(context,"Wifi desabilitado",Toast.LENGTH_LONG).show();
        }

    }

    public void doPut(JSONBean bean, AsynctaskListener<List<String>> listener){

        StringBuilder builder = new StringBuilder(String.format(BASE_URL_ADDRESS,SERVER_ADDRESS,SERVER_PORT));
        String url = builder.append("lugares/").toString();

        if(wifiEnabled())
        {
            // TODO: implementar HTTP PUTWORKER
        }else {
            Toast.makeText(context,"Wifi desabilitado",Toast.LENGTH_LONG).show();
        }

    }

    public void doDelete(JSONBean bean, AsynctaskListener<List<String>> listener){

        StringBuilder builder = new StringBuilder(String.format(BASE_URL_ADDRESS,SERVER_ADDRESS,SERVER_PORT));
        String url = builder.append("lugares/").toString();

        if(wifiEnabled())
        {
            // TODO: implementar HTTP PUTWORKER
        }else {
            Toast.makeText(context,"Wifi desabilitado",Toast.LENGTH_LONG).show();
        }

    }

    private boolean wifiEnabled() {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null && info.isConnected();
    }
}
