package com.example.userhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;
    private OnUserClickListener listener;

    public UserAdapter(List<User> list, OnUserClickListener listener) {
        this.userList = list;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.name.setText(user.getName());
        holder.email.setText("Email : "+user.getEmail());
        holder.username.setText("Username : "+user.getUsername());

        holder.itemView.setOnClickListener(v -> {
            listener.onUserClick(user);
        });    }

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
