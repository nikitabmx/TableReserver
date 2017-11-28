package com.example.nekitenzogmailcom.tablereserver.SaveData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.nekitenzogmailcom.tablereserver.R;

import java.util.ArrayList;

/**
 * Created by artem on 28.11.2017.
 */

//наш кастомный адаптер для списка
// Здесь мы описываем поведение наших элементов списка
public class MyAdapterForList extends ArrayAdapter {

    private final Context context;
    private ArrayList<Bron> bronArr; //массив объектов

    public MyAdapterForList(@NonNull Context context, int resource, @NonNull ArrayList<Bron> objects) {
        super(context, resource, objects);
        this.context = context;
        bronArr = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item, parent, false);
//        TextView idTV = (TextView) rowView.findViewById(R.id.idTV);
//        TextView nameTV = (TextView) rowView.findViewById(R.id.nameTV);
//        TextView peopleTV = (TextView) rowView.findViewById(R.id.peopleTV);
//        TextView timeTV = (TextView) rowView.findViewById(R.id.timeTV);

        Bron bron = bronArr.get(position);

//        idTV.setText(String.valueOf(bron.getId()));
//        nameTV.setText(bron.getName());
//        peopleTV.setText(String.valueOf(bron.getPeople()));
//        timeTV.setText(bron.getTime());
        return rowView;
    }
}
