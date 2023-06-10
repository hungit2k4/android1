package com.example.demotutor2;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {

    private ArrayList<NhanVien> list;

    public NhanVienAdapter(ArrayList<NhanVien> list) {
        this.list = list;
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
        if (view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.layout_employee_item, null);
            TextView tvMaNhanVien = view.findViewById(R.id.tvMaNhanVien);
            TextView tvTenNhanVien = view.findViewById(R.id.tvTenNhanVien);
            TextView tvPhongBan = view.findViewById(R.id.tvPhongBan);
            TextView btnSua = view.findViewById(R.id.btnSua);
            TextView btnXoa = view.findViewById(R.id.btnXoa);
            ViewHolder holder = new ViewHolder(tvMaNhanVien, tvTenNhanVien,
                    tvPhongBan, btnSua, btnXoa);
            view.setTag(holder);
        }
        NhanVien nhanVien = (NhanVien) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvMaNhanVien.setText(nhanVien.getMaNV());
        holder.tvPhongBan.setText(nhanVien.getPhongBan());
        holder.tvTenNhanVien.setText(nhanVien.getHoTen());
        // button sửa
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployeeActivity employeeActivity = (EmployeeActivity) _viewGroup.getContext();
                employeeActivity.capNhatNhanVien(nhanVien);
            }
        });
        // button xóa
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = -1; // giả su không có
                for (int i = 0; i < list.size(); i++) {
                    NhanVien nv = list.get(i);
                    if (nv.getMaNV().equals(nhanVien.getMaNV())) {
                        index = i; // 0, 1, 2, 3, ..
                        break;
                    }
                }
                if (index != -1) {
                    // xóa theo chỉ số
                    list.remove(index);
                    notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    private static class ViewHolder {
        final TextView tvMaNhanVien, tvTenNhanVien, tvPhongBan;
        final TextView btnSua, btnXoa;

        public ViewHolder(TextView tvMaNhanVien, TextView tvTenNhanVien, TextView tvPhongBan, TextView btnSua, TextView btnXoa) {
            this.tvMaNhanVien = tvMaNhanVien;
            this.tvTenNhanVien = tvTenNhanVien;
            this.tvPhongBan = tvPhongBan;
            this.btnSua = btnSua;
            this.btnXoa = btnXoa;
        }
    }
}
