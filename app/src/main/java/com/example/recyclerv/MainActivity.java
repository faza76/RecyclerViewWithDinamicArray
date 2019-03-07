package com.example.recyclerv;
/**
 * Created by Faza Akbar on 03/03/19.
 * faza.akbar.tif17@polban.ac.id
 */

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] items;
    //Drawable[] img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = getResources().getStringArray(R.array.kendaraan);
        //img = getResources().getDrawable(R.array.gambar,MainActivity.this);
        final TypedArray img = getResources().obtainTypedArray(R.array.gambar);



        recyclerView = findViewById(R.id.Recyview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this,items,img));

    }
}
