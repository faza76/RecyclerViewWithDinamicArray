package com.example.recyclerv;
/**
 * Created by Faza Akbar on 03/03/19.
 * faza.akbar.tif17@polban.ac.id
 */

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewDialog.NoticeDialogListener{

    RecyclerView recyclerView;
    String[] items;
    FloatingActionButton fab;
    TypedArray img;

    //Drawable[] img;


    ArrayList<kendaraan> listKD = new ArrayList<kendaraan>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Drawable draw = getResources().getDrawable(R.drawable.ic_directions_car_black_24dp);

        kendaraan kd = new kendaraan("Mobil","kendaraan", draw);
        listKD.add(kd);

        String[] desc = {"Kendaraan versi darat","Kendaraan versi udara","kendaraan versi sehat","Kendaraan versi hemat"};;
        items = getResources().getStringArray(R.array.kendaraan);
        //img = getResources().getDrawable(R.array.gambar,MainActivity.this);
        img = getResources().obtainTypedArray(R.array.gambar);



        recyclerView = findViewById(R.id.Recyview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView.setAdapter(new Adapter(MainActivity.this,listKD));

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewDialog dialog = new NewDialog();
                dialog.show(getSupportFragmentManager(), "Hello");
            }
        });


    }

    @Override
    public void onDialogPositiveClick(DialogFragment fragment, kendaraan kd) {
        //lightList.addLights(lights);
        Adapter rAdapter = new Adapter(MainActivity.this,listKD);
        listKD.add(kd);
        rAdapter.notifyDataSetChanged();
        //  recycleAdapter.notifyItemInserted(lightList.getTotalSize()-1);
        Toast.makeText(getApplicationContext(), "Hello Fragment", Toast.LENGTH_SHORT).show();
    }
}
