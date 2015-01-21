package elias.app.chiloeplaces.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Elias on 15-01-15.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITULOS = {"Picadas", "Novedades", "Noticias"};
    private ArrayList<Fragment> frag;

    public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.frag = fragments;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITULOS[position];
    }

    @Override
    public int getCount() {
        return this.frag.size();
    }

    @Override
    public Fragment getItem(int position) {
        return frag.get(position);
    }
}