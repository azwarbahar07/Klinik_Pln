package com.example.klinik_pln.antrian.antriankedua;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.klinik_pln.R;
import com.example.klinik_pln.adapter.ViewPagerAntrianAdapter;
import com.example.klinik_pln.antrian.antriankedua.fragment.AllAntrianFragmentKedua;
import com.example.klinik_pln.antrian.antriankedua.fragment.DoneFragmentKedua;
import com.example.klinik_pln.antrian.antriankedua.fragment.MenungguFragmentKedua;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AntrianKeduaActivity extends AppCompatActivity {

    private TabLayout tab_antrian;
    private ViewPager pager_antrian;
    private ViewPagerAntrianAdapter adapter;
    private TextView tv_tanggal;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrian_kedua);

        Toolbar mTopToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);

        tab_antrian = findViewById(R.id.tab_antrian);
        pager_antrian = findViewById(R.id.pager_antrian);
        adapter = new ViewPagerAntrianAdapter(getSupportFragmentManager());
        pd = new ProgressDialog(this);

        adapter.AddFragment(new MenungguFragmentKedua(), "Menunggu");
        adapter.AddFragment(new DoneFragmentKedua(), "Selesai");
        adapter.AddFragment(new AllAntrianFragmentKedua(), "Riwayat");
        pager_antrian.setAdapter(adapter);
        tab_antrian.setupWithViewPager(pager_antrian);
        tv_tanggal = findViewById(R.id.tv_tanggal);
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        tv_tanggal.setText(dateFormat.format(date));
    }
}