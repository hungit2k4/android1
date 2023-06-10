package com.example.thuchanhtrenlop.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thuchanhtrenlop.Models.Contact;
import com.example.thuchanhtrenlop.R;

import java.util.ArrayList;

public class ContactAdater extends BaseAdapter {
    private ArrayList<Contact> list;

    public ContactAdater(ArrayList<Contact>_list) {
        this.list=_list;
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
    public View getView(int _i, View _view, ViewGroup _group) {
        View view= _view;
        if(view==null){
            view = View.inflate(_group.getContext(), R.layout.layout_list_contact,null);
            TextView ten =view.findViewById(R.id.ten);
            TextView sdt = view.findViewById(R.id.sdt);
            ViewHolder holder = new ViewHolder(ten,sdt);
            view.setTag(holder);
        }
        Contact contact = (Contact) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.ten.setText(contact.getName());
        holder.sdt.setText(contact.getPhoneNumber());
        return view;
    }
    private  static class ViewHolder{
        final TextView ten ,sdt;

        private ViewHolder(TextView ten, TextView sdt) {
            this.ten = ten;
            this.sdt = sdt;
        }
    }
}
