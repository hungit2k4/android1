package com.example.phu_dao_va_on_tap.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.phu_dao_va_on_tap.Models.SinhVien;
import com.example.phu_dao_va_on_tap.R;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    ArrayList<SinhVien> list;

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
    public View getView(int _i, View _View, ViewGroup _viewGroup) {
        View view = _View;
        if (view==null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_nhanvien_item, null);
            TextView maNV = view.findViewById(R.id.tvMaNV);
            TextView hoTen = view.findViewById(R.id.tvHoTen);
            TextView phongBan = view.findViewById(R.id.tvPhongBan);
            ViewHolder holder=new ViewHolder(maNV,hoTen,phongBan);
            view.setTag(holder);
        }
        SinhVien sinhVien = (SinhVien) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.MaNV.setText(sinhVien.getMaNV());
        holder.HoTen.setText(sinhVien.getHoTen());
        holder.PhongBan.setText(sinhVien.getPhongBan());
        return view;
    }
    private static class ViewHolder{
        final TextView MaNV, HoTen, PhongBan;

        public ViewHolder(TextView maNV, TextView hoTen, TextView phongBan) {
            MaNV = maNV;
            HoTen = hoTen;
            PhongBan = phongBan;
        }
    }
}
