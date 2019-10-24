package com.example.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ArrayAdapter extends RecyclerView.Adapter<Employee> {

    Context ctx;
    int resource;
    List<Employee> eList;

    public ArrayAdapter(Context ctx, int resource, List<Employee> eList) {
        super();

        this.ctx = ctx;
        this.resource = resource;
        this.eList = eList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resource, null);
        TextView id = v.findViewById(R.id.id);
        TextView name = v.findViewById(R.id.name);
        TextView age = v.findViewById(R.id.age);
        TextView salary = v.findViewById(R.id.salary);

        Employee e = eList.get(position);
        id.setText(e.getId());
        name.setText(e.getName());
        age.setText(e.getAge());
        salary.setText(e.getSalary());

        return v;
    }


}
