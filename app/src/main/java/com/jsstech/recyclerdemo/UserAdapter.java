package com.jsstech.recyclerdemo;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    private List<UserModel> listItems;
    private Context context;

    public UserAdapter(List<UserModel> listItems,Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
                //inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        UserModel model= (UserModel) listItems.get(position);
   holder.txtdate.setText(((UserModel) listItems.get(position)).getExp());
        holder.txtdate.setText(((UserModel) listItems.get(position)).getDates());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtname;
        TextView txtdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname=itemView.findViewById(R.id.tname);
            txtdate=itemView.findViewById(R.id.tdate);


        }
    }
}
