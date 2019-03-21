package com.example.recyclerv;
/**
 * Created by Faza Akbar on 03/03/19.
 * faza.akbar.tif17@polban.ac.id
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String items;
    String desc;
    Drawable img;
    ArrayList<kendaraan> listkd;

//    public Adapter(Context context, String[] items, String[] desc, TypedArray img){
//        this.context = context;
//        this.items = items;
//        this.img = img;
//        this.desc = desc;
//    }



    public Adapter(Context context, ArrayList<kendaraan> kd){
        this.context = context;
        this.listkd = kd;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.item,viewGroup,false);
        Items item = new Items(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((Items)viewHolder).mtext.setText(listkd.get(i).getName());
        ((Items) viewHolder).mImage.setImageDrawable(listkd.get(i).getImg());
        ((Items) viewHolder).mdesc.setText(listkd.get(i).getDesc());


        ((Items) viewHolder).parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,listkd.get(i).getName(),Toast.LENGTH_SHORT);
                Log.d("TAG", "onClick: Clicked" + listkd.get(i).getName());
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Testing");
                dialog.setMessage(listkd.get(i).getName());
                dialog.show();
            }
        });

        ((Items) viewHolder).parentlayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Testing");
                dialog.setMessage("Long click");
                dialog.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listkd.size();
    }

    public class Items extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mtext;
        TextView mdesc;
        LinearLayout parentlayout;
        public Items(@NonNull View itemView) {
            super(itemView);
            parentlayout = itemView.findViewById(R.id.parentlayout);
            mImage = itemView.findViewById(R.id.image);
            mtext = itemView.findViewById(R.id.text1);
            mdesc = itemView.findViewById(R.id.desc);
        }
    }

}
