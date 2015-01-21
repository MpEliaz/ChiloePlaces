package elias.app.chiloeplaces.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import elias.app.chiloeplaces.clases.Lugar;

/**
 * Created by Elias on 18-01-15.
 */
public class LugarReceiver extends BroadcastReceiver {

    public static final int LUGAR_AGREGADO = 1;
    public static final int LUGAR_ELIMINADO = 2;
    public static final int LUGAR_ACTUALIZADO = 3;

    private final ArrayAdapter<Lugar> adapter;

    public LugarReceiver(ArrayAdapter<Lugar> adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int  operacion = intent.getIntExtra("operacion", -1);
        switch (operacion){
            case LUGAR_AGREGADO: agregarLugar(intent); break;
            case LUGAR_ELIMINADO: eliminarLugar(intent); break;
            case LUGAR_ACTUALIZADO: actualizarLugar(intent); break;
        }
    }

    private void actualizarLugar(Intent intent) {
    }

    private void eliminarLugar(Intent intent) {
        ArrayList<Lugar> lista = (ArrayList<Lugar>) intent.getSerializableExtra("datos");
        for(Lugar l : lista)adapter.remove(l);
    }

    private void agregarLugar(Intent intent) {
        Lugar lugar = (Lugar)intent.getSerializableExtra("datos");
        adapter.add(lugar);
    }
}
