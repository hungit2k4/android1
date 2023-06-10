package com.example.thuchanhtrenlop.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thuchanhtrenlop.Models.Course;
import com.example.thuchanhtrenlop.R;

import java.util.ArrayList;

public class CourseAdapter extends BaseAdapter {
    private ArrayList<Course> list;
    public CourseAdapter(ArrayList<Course> _list){
        this.list= _list;
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
    public View getView(int i, View _view, ViewGroup _viewGroup) {
        View view=_view;
                if(view==null){
                    view = View.inflate(_viewGroup.getContext(), R.layout.layout_option,null);
                    TextView tvCourseName =view.findViewById(R.id.tvCourseName);
                    ViewHolder holder= new ViewHolder(tvCourseName);
                    view.setTag(holder);
                }
                Course course = (Course) getItem(i);
                ViewHolder holder = (ViewHolder) view.getTag();
                holder.tvCourseName.setText(course.getName());
                return view;
    }
    private static class ViewHolder{
        final TextView tvCourseName;
        public ViewHolder (TextView _tvCourseName){
            this.tvCourseName = _tvCourseName;
        }
    }
}
