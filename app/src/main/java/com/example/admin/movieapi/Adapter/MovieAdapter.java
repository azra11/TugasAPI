package com.example.admin.movieapi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.movieapi.R;
import com.squareup.picasso.Picasso;

import java.sql.ResultSet;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {
    private List<ResultItem> resultsItemList;
    private Context context;
    private ActionBar toolbar;

    public MovieAdapter(Context context, List<ResultsItem> resultsItemList) {
        this.context = context;
        this.resultsItemList = resultsItemList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.Holder holder, final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return resultsItemList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout detail;
        private ImageView ivPoster;
        private TextView tvJudul, tvTanggal;

        public Holder(View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.gambar);
            tvJudul = itemView.findViewById(R.id.judul);
            tvTanggal = itemView.findViewById(R.id.tanggal);
            detail = itemView.findViewById(R.id.detail);
        }

        }
    }
