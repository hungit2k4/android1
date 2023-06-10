package com.example.lab5_ps29253;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DienThoaiAdapter extends BaseAdapter {
    ArrayList<DienThoai> list;

    public DienThoaiAdapter(ArrayList<DienThoai> _list) {
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
        View view= _view;
        if (view==null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_dienthoai_item,null);
            TextView tvTenDT =view.findViewById(R.id.tvTenDT);
            TextView tvGia = view.findViewById(R.id.tvGia);
            TextView tvSoLuong = view.findViewById(R.id.tvSoLuong);
            ViewHolder holder = new ViewHolder(tvTenDT, tvGia,tvSoLuong);
            view.setTag(holder);
        }
        DienThoai dienThoai = (DienThoai) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.ten.setText("Tên: "+dienThoai.getTen());
        holder.gia.setText("Giá: "+dienThoai.getGia());
        holder.soLuong.setText("Số lượng: "+dienThoai.getSoLuong());
        return view;
    }
    private static class ViewHolder{
        final TextView ten, gia, soLuong;

        public ViewHolder(TextView ten, TextView gia, TextView soLuong) {
            this.ten = ten;
            this.gia = gia;
            this.soLuong = soLuong;
        }
    }
}
