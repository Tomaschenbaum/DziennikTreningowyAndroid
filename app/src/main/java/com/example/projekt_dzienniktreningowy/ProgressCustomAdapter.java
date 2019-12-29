package com.example.projekt_dzienniktreningowy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProgressCustomAdapter extends ArrayAdapter<ProgressDataModel> {
    private ArrayList<ProgressDataModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtCwiczenie;
        TextView txtSrednia;
        TextView txtMax;
        TextView txtMin;
    }

    public ProgressCustomAdapter(ArrayList<ProgressDataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProgressDataModel dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtCwiczenie = (TextView) convertView.findViewById(R.id.data);
            viewHolder.txtSrednia = (TextView) convertView.findViewById(R.id.cwiczenie);
            viewHolder.txtMax = (TextView) convertView.findViewById(R.id.obciazenie);
            viewHolder.txtMin = (TextView) convertView.findViewById(R.id.serie);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtCwiczenie.setText(dataModel.getCwiczenie());
        viewHolder.txtSrednia.setText("Srednia: " + dataModel.getSrednia());
        viewHolder.txtMax.setText("Min: " + dataModel.getMax());
        viewHolder.txtMin.setText("Max: " + dataModel.getMin());

        return convertView;
    }
}
