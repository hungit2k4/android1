package com.example.thuchanhtrenlop.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanhtrenlop.Models.MayTinh;
import com.example.thuchanhtrenlop.R;

import java.util.ArrayList;

public class MayTinhAdapter extends BaseAdapter {
    ArrayList<MayTinh> list;

    public MayTinhAdapter(ArrayList<MayTinh> _list) {
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
    public View getView(int _i, View _iew, ViewGroup _viewGroup) {
        View view=_iew;
        if (view == null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_maytinh_item,null);
            TextView hang = view.findViewById(R.id.tvHang);
            TextView gia = view.findViewById(R.id.tvGia);
            ViewHolder holder =new ViewHolder(hang,gia);
            view.setTag(holder);
        }
        MayTinh mayTinh = (MayTinh) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.hang.setText("Hãng: "+mayTinh.getHang());
        holder.gia.setText("Giá: "+mayTinh.getGia()+"$");
        return view;
    }

    private class ViewHolder{
        final TextView hang,gia;

        public ViewHolder(TextView hang, TextView gia) {
            this.hang = hang;
            this.gia = gia;
        }
    }
}
