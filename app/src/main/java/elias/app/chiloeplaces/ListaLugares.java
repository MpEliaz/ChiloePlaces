package elias.app.chiloeplaces;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import elias.app.chiloeplaces.adaptadores.AdaptadorListaLugares;
import elias.app.chiloeplaces.clases.Lugar;


public class ListaLugares extends Fragment {


    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Lugar l = new Lugar();
        l.setNombre("Parque Cucao");
        l.setComuna("Chonchi");
        l.setDescripcion("un lugar maravilloso");
        final ArrayList<Lugar> lugares;
        lugares = new ArrayList<Lugar>();
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);
        lugares.add(l);


        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdaptadorListaLugares(R.layout.item_lugar, lugares));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.lista_lugares, container, false);
        return  rootview;
    }


}
