package com.example.telmex.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.telmex.petagram.adapter.AdaptadorMascota;
import com.example.telmex.petagram.adapter.PageAdapter;
import com.example.telmex.petagram.fragment.FragmentDetalle;
import com.example.telmex.petagram.fragment.FragmentMascotas;
import com.example.telmex.petagram.poyo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMascota;
    ArrayList<Mascota> mascotas;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setUpViewPager();

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacto:
                /*Intent intent = new Intent(this,ActivityAbout.class);
                startActivity(intent);*/
                break;
            case R.id.acerca:
                /*Intent intent1 = new Intent(this,ActivitySetting.class);
                startActivity(intent1);*/
                break;
            case R.id.mEstrella:
                Intent intent = new Intent(this,FavoritasActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragment()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentMascotas());
        fragments.add(new FragmentDetalle());
        return  fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_dog);
    }





}
