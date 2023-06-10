package com.example.asm1_ps29253.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.asm1_ps29253.Models.NhanVien;
import com.example.asm1_ps29253.R;
import com.example.asm1_ps29253.layout.QLNhanVien;

import java.util.ArrayList;
import java.util.Iterator;

public class NhanVienAdapter extends BaseAdapter {
    ArrayList <NhanVien> list;
    public NhanVienAdapter(ArrayList<NhanVien> _list) {
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
        View view=_view;
        if (view== null){
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_nhanvien_item, null);
            TextView maNV= view.findViewById(R.id.tvMaNV);
            TextView tenNV= view.findViewById(R.id.tvHoTen);
            TextView phongBan= view.findViewById(R.id.tvPhongBan);
            Button btnxoa = view.findViewById(R.id.btnXoa);
            Button btnsua = view.findViewById(R.id.btnSua);
            ViewHolder holder = new ViewHolder(maNV,tenNV,phongBan,btnsua,btnxoa);
            view.setTag(holder);
        }
        NhanVien nhanVien = (NhanVien) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.maNV.setText("Mã NV: "+nhanVien.getMaNV());
        holder.tenNV.setText("Họ tên: "+nhanVien.getTenNV());
        holder.phongBan.setText("Phòng ban: "+nhanVien.getPhongBan());
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<NhanVien> iterator = list.iterator();
                while (iterator.hasNext()) {
                    NhanVien nv = iterator.next();
                    if (nv.getMaNV().equalsIgnoreCase(nhanVien.getMaNV())) {
                        iterator.remove();
                        notifyDataSetChanged();
                        break;
                    }
                }
            }
        });
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QLNhanVien qlnhanvien = (QLNhanVien) _viewGroup.getContext();
                qlnhanvien.UpdateNhanVien(nhanVien);
            }
        });
        return view;
    }
    public class  ViewHolder{
        final TextView maNV,tenNV,phongBan;
        final Button btnSua, btnXoa;

        public ViewHolder(TextView maNV, TextView tenNV, TextView phongBan, Button btnSua, Button btnXoa) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.phongBan = phongBan;
            this.btnSua = btnSua;
            this.btnXoa = btnXoa;
        }
    }
}
