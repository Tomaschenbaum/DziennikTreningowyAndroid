package com.example.projekt_dzienniktreningowy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {
    private ArrayList<DataModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtCwiczenie;
        TextView txtData;
        TextView txtObciazenie;
        TextView txtSerie;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataModel dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtCwiczenie = (TextView) convertView.findViewById(R.id.cwiczenie);
            viewHolder.txtData = (TextView) convertView.findViewById(R.id.data);
            viewHolder.txtObciazenie = (TextView) convertView.findViewById(R.id.obciazenie);
            viewHolder.txtSerie = (TextView) convertView.findViewById(R.id.serie);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtCwiczenie.setText(dataModel.getCwiczenie());
        viewHolder.txtData.setText(dataModel.getData());
        viewHolder.txtObciazenie.setText("Obciążenie: " + dataModel.getObciazenie());
        viewHolder.txtSerie.setText("Liczba serii: " + dataModel.getSerie());

        return convertView;
    }
}
