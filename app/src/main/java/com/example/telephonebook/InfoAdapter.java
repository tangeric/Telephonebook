package com.example.telephonebook;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */

public class InfoAdapter extends ArrayAdapter<Info> {
    private int resourceid;

    public InfoAdapter(@NonNull Context context, @LayoutRes int textresource, @NonNull List<Info> objects ) {
       super(context,textresource,objects);
        resourceid=textresource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Info info =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceid, parent,false);
            viewHolder=new ViewHolder();
            viewHolder.name=(TextView)view.findViewById(R.id.name_item);
            viewHolder.number=(TextView)view.findViewById(R.id.number_item);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.name.setText(info.getName());
        viewHolder.number.setText(info.getNumber());
        return view;
}
class ViewHolder{
        TextView name;
        TextView number;
    }
}
