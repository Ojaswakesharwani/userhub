package com.example.userhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> list) {
        this.userList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(userList.get(position).getName());
        holder.email.setText("Email : "+userList.get(position).getEmail());
        holder.username.setText("Username : "+userList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {

        return userList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, email , username;

        public ViewHolder(View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.nameText);
            email = itemView.findViewById(R.id.emailText);
            username = itemView.findViewById(R.id.username);
        }
    }
}
