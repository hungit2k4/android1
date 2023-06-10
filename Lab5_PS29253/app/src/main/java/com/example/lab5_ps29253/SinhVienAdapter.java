package com.example.lab5_ps29253;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private ArrayList<SinhVien> list;

    public SinhVienAdapter(ArrayList<SinhVien> _list) {
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
        View view = _view;
        if (view ==null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_sv,null);
            TextView coSo =view.findViewById(R.id.tvCoSo);
            TextView ten = view.findViewById(R.id.tvTen);
            TextView diaChi = view.findViewById(R.id.tvDiaChi);
            Button update = view.findViewById(R.id.btnUpdate);
            Button delete = view.findViewById(R.id.btnDelete);
            ViewHolder holder = new ViewHolder(coSo, ten, diaChi, update,delete);
            view.setTag(holder);
        }
        SinhVien sinhVien = (SinhVien) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
       holder.coSo.setText(sinhVien.getCoSo());
       holder.ten.setText(sinhVien.getTen());
       holder.sdt.setText(sinhVien.getDiaChi());
        return view;
    }
    private  static class ViewHolder{
        final TextView coSo , ten,sdt;
        final Button update,delete;
        public ViewHolder(TextView coSo, TextView ten, TextView sdt, Button update, Button delete) {
            this.coSo = coSo;
            this.ten = ten;
            this.sdt = sdt;
            this.update = update;
            this.delete = delete;
        }
    }
}
