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

import com.example.f1r3z.myapplicationdocument.DetailDocument;
import com.example.f1r3z.myapplicationdocument.R;
import com.example.f1r3z.myapplicationdocument.model.Document;

import java.util.ArrayList;
import java.util.List;


public class adt_rv_cardview_doc extends RecyclerView.Adapter<adt_rv_cardview_doc.ViewHolder> {
    private List<Document> lst;
    private Context ctx;

    public adt_rv_cardview_doc() {
        lst = new ArrayList<Document>();

        Document d = new Document();
        d.setTitle("เอกสารการเข้าอบรม");
        d.setDescription("การเข้าอบรมของECP4N");
        d.setPicture(R.mipmap.ic_document);
        lst.add(d);

        d = new Document();
        d.setTitle("เอกสารการทำความสะอาดตึก");
        d.setDescription("การทำความสะอาดตึก3");
        d.setPicture(R.mipmap.ic_document);
        lst.add(d);
    }

    @Override
    public adt_rv_cardview_doc.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card_doc, parent, false);
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
    public void onBindViewHolder(adt_rv_cardview_doc.ViewHolder holder, final int position){
        Document d =lst.get(position);
        holder.tvTitle.setText(d.getTitle());
        holder.tvDescription.setText(d.getDescription());
        holder.imgCover.setImageResource(d.getPicture());

        holder.cvGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               String selectedTitle = lst.get(position).getTitle();
               int selectedCover = lst.get(position).getPicture();
               DetailDocumentWhithData(selectedTitle,selectedCover);

            }
        });
    }
    private void DetailDocumentWhithData(String strTitle,int imgCover){
        Intent intent = new Intent(ctx,DetailDocument.class);
        intent.putExtra("selectedCover",imgCover);
        intent.putExtra("selectedTitle",strTitle);
        ctx.startActivity(intent);
    }

    @Override
    public int getItemCount(){
        return lst.size();
    }

}

