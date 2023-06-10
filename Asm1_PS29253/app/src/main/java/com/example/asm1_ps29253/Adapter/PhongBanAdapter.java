package com.example.asm1_ps29253.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.asm1_ps29253.Models.PhongBan;
import com.example.asm1_ps29253.R;

import java.util.ArrayList;

public class PhongBanAdapter extends BaseAdapter {
    ArrayList<PhongBan> list;

    public PhongBanAdapter(ArrayList<PhongBan> _list) {
        this.list = _list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view =_view;
        if (view == null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_phongban_item,null);
            TextView tenPB= view.findViewById(R.id.tvTenPB);
            ViewHolder holder= new ViewHolder(tenPB);
            view.setTag(holder);
        }
        PhongBan phongBan = (PhongBan) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tenPB.setText("  "+phongBan.getTenPB());
        return view;
    }
    public class ViewHolder{
        final TextView tenPB;

        public ViewHolder(TextView tenPB) {
            this.tenPB = tenPB;
        }
    }
}
