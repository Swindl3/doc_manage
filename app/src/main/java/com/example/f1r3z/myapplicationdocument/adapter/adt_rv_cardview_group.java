package com.example.f1r3z.myapplicationdocument.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.f1r3z.myapplicationdocument.ListDocName;
import com.example.f1r3z.myapplicationdocument.R;
import com.example.f1r3z.myapplicationdocument.model.Group;

import java.util.ArrayList;
import java.util.List;


public class adt_rv_cardview_group extends RecyclerView.Adapter<adt_rv_cardview_group.ViewHolder> {
    private List<Group> lst;
    private Context ctx;

    public adt_rv_cardview_group() {
        lst = new ArrayList<Group>();

        Group g = new Group();
        g.setTitle("ECP4N");
        g.setDescription("เอกสารมหาลัย");
        g.setPicture(R.mipmap.ic_document);
        lst.add(g);

        g = new Group();
        g.setTitle("ECP1N");
        g.setDescription("เอกสารมหาลัย");
        g.setPicture(R.mipmap.ic_document);
        lst.add(g);

        g = new Group();
        g.setTitle("ECP3N");
        g.setDescription("เอกสารมหาลัย");
        g.setPicture(R.mipmap.ic_document);
        lst.add(g);
    }

    @Override
    public adt_rv_cardview_group.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_group, parent, false);
        ctx = parent.getContext();
        return new ViewHolder(v);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cvGroup;
        private ImageView imgCover;
        private TextView tvTitle;
        private TextView tvDescription;

        public ViewHolder(View v){
            super(v);
            cvGroup = v.findViewById(R.id.cvProduct);
            imgCover = v.findViewById(R.id.imgCover);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDescription = v.findViewById(R.id.tvDescription);
        }
    }

    @Override
    public void onBindViewHolder(adt_rv_cardview_group.ViewHolder holder, final int position){
        Group g = lst.get(position);
        holder.tvTitle.setText(g.getTitle());
        holder.tvDescription.setText(g.getDescription());
        holder.imgCover.setImageResource(g.getPicture());

        holder.cvGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ctx, ListDocName.class);
                ctx.startActivity(intent);
                Toast.makeText(ctx, lst.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return lst.size();
    }

}

