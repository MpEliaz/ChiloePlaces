package elias.app.chiloeplaces.adaptadores;
import elias.app.chiloeplaces.R;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import elias.app.chiloeplaces.clases.Lugar;

/**
 * Created by Elias on 15-01-15.
 */
public class AdaptadorListaLugares extends RecyclerView.Adapter<AdaptadorListaLugares.ViewHolder> {

    private Context cx;
    private ArrayList<Lugar> lista;
    private int itemLayout;

    public AdaptadorListaLugares(int item, ArrayList<Lugar> lugares) {
        this.itemLayout = item;
        this.lista = lugares;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{

        public ImageView imagen;
        public TextView nombre;
        public TextView comuna;
        public TextView descripcion;

        public ViewHolder(View itemView){

            super(itemView);

            itemView.setOnClickListener(this);
            imagen = (ImageView)itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            comuna = (TextView) itemView.findViewById(R.id.comuna);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);

        }
        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Lugar lugar = lista.get(i);
        viewHolder.imagen.setImageResource(R.drawable.cucao);
        viewHolder.nombre.setText(lugar.getNombre());
        viewHolder.comuna.setText(lugar.getComuna());
        viewHolder.descripcion.setText(lugar.getDescripcion());

        viewHolder.itemView.setTag(lugar);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}



