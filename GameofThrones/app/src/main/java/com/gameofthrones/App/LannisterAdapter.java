package com.gameofthrones.App;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.xpath.XPathFunctionResolver;

public class LannisterAdapter extends RecyclerView.Adapter<LannisterAdapter.LannisterViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public LannisterAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;

    }
    @NonNull
    @Override
    public LannisterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lannister_row, parent, false);
        return new LannisterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LannisterViewHolder lannisterViewHolder, int position) {
        lannisterViewHolder.myText1.setText(data1[position]);
        lannisterViewHolder.myText2.setText(data2[position]);
        lannisterViewHolder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class LannisterViewHolder extends  RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView myImage;

        public LannisterViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textView2);
            myText2 = itemView.findViewById(R.id.textView3);
            myImage = itemView.findViewById(R.id.imageView2);
        }
    }
}
