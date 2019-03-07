package com.example.recyclerv;
/**
 * Created by Faza Akbar on 03/03/19.
 * faza.akbar.tif17@polban.ac.id
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
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

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] items;
    TypedArray img;

    public Adapter(Context context, String[] items, TypedArray img){
        this.context = context;
        this.items = items;
        this.img = img;
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
        ((Items)viewHolder).mtext.setText(items[i]);
        ((Items) viewHolder).mImage.setImageResource(img.getResourceId(i,-1));


        ((Items) viewHolder).parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,items[i],Toast.LENGTH_SHORT);
                Log.d("TAG", "onClick: Clicked" + items[i]);
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Testing");
                dialog.setMessage(items[i]);
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
        return items.length;
    }

    public class Items extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mtext;
        LinearLayout parentlayout;
        public Items(@NonNull View itemView) {
            super(itemView);
            parentlayout = itemView.findViewById(R.id.parentlayout);
            mImage = itemView.findViewById(R.id.image);
            mtext = itemView.findViewById(R.id.text1);
        }
    }

}
