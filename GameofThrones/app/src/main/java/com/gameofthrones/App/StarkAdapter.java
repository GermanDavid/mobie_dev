package com.gameofthrones.App;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.xpath.XPathFunctionResolver;

public class StarkAdapter extends RecyclerView.Adapter<StarkAdapter.StarkViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public StarkAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;

    }
    @NonNull
    @Override
    public StarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.stark_row, parent, false);
        return new StarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarkViewHolder starkViewHolder, int position) {
        starkViewHolder.myText1.setText(data1[position]);
        starkViewHolder.myText2.setText(data2[position]);
        starkViewHolder.myImage.setImageResource(images[position]);

        starkViewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StarkSecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class StarkViewHolder extends  RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public StarkViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textView);
            myText2 = itemView.findViewById(R.id.textView2);
            myImage = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
