package elias.app.chiloeplaces;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import elias.app.chiloeplaces.adaptadores.MainPagerAdapter;


public class ActividadPrincipal extends ActionBarActivity {

    private ViewPager pager;
    private PagerSlidingTabStrip tabs;
    private ListaLugares listalugares;
    private ArrayList<Fragment> fragments;
    private MainPagerAdapter adapter;
    Toolbar toolbar;
    private int mBaseTranslationY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        listalugares = new ListaLugares();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragments = new ArrayList<Fragment>();
        fragments.add(listalugares);
        fragments.add(new Fragment());
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);
        tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.primary_color));
        tabs.setTextColor(getResources().getColor(R.color.white));
        tabs.setViewPager(pager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
