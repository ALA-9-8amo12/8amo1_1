package com.example.amazigh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;


public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryViewholder>{
    Context context;
    List<category> list;

    public categoryAdapter(Context context, List<category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public categoryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category2, parent, false);
        return new categoryViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewholder holder, int position) {
        holder.button.setText(list.get(position).getNamecategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class categoryViewholder extends RecyclerView.ViewHolder {
        Button button;

        public categoryViewholder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttoncategory);
        }
    }


}
