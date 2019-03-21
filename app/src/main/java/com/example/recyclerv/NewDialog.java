package com.example.recyclerv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Faza Akbar on 21/03/19.
 * faza.akbar.tif17@polban.ac.id
 */
public class NewDialog extends DialogFragment {

    String[] nama_kd;
    Spinner spinner;
    ImageView imageView;
    int currentIndex;
    EditText editText;
    EditText editText2;

    private static Drawable[] drawables = new Drawable[4];

    NoticeDialogListener listener;
    //MainActivity extends Activity implements Context, NoticeDialogListener
    //MainActivity instanceOf Activity ---> True
    //MainActivity instanceOf Context ---> True
    //MainActivity instanceOf NoticeDialogListener ---> True

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (NoticeDialogListener) context;
    }

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment fragment, kendaraan kd);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.content_new_kendaraan, null);
        builder.setView(view);

        nama_kd = getResources().getStringArray(R.array.kendaraan);
        spinner = view.findViewById(R.id.spinner);
        imageView = view.findViewById(R.id.imageView);
        editText = view.findViewById(R.id.editText);
        editText2 = view.findViewById(R.id.editText2);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, nama_kd);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Drawable drawable = CommonUtil.makeLightsType(getResources(), position);
                imageView.setImageDrawable(drawable);
                currentIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = editText.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    name = nama_kd[currentIndex];
                }
                String desc = editText2.getText().toString();
                TypedArray mimg = getActivity().getResources().obtainTypedArray(R.array.gambar);


                Drawable img = makeImage(getResources(),currentIndex);

                kendaraan kd = new kendaraan(name,desc,img);

                listener.onDialogPositiveClick(NewDialog.this, kd);

//                Toast.makeText(getActivity(), lights.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), nama_kd[currentIndex], Toast.LENGTH_SHORT).show();
            }
        });

//        builder.setTitle("new Dialog");
//        builder.setMessage("Hello Dialog");

        return builder.create();
    }

    public Drawable makeImage(Resources resources, int index){

        if (drawables[index]==null){
            TypedArray images = resources.obtainTypedArray(R.array.gambar);
            Drawable drawable = images.getDrawable(index);
            drawables[index]=drawable;
            Log.d("new Drawable", drawable.toString());
        }
        return  drawables[index];
    }


}

