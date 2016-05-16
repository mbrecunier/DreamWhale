package com.epicodus.dreamwhale.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.models.Dream;
import com.epicodus.dreamwhale.ui.DreamDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/16/16.
 */
public class DreamViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.dreamDateTextView) TextView mDreamDateTextView;

    private Context mContext;
    private ArrayList<Dream> mDreams = new ArrayList<>();

    public DreamViewHolder(View itemView, ArrayList<Dream> dreams) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mDreams = dreams;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, DreamDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("dreams", Parcels.wrap(mDreams));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindDream(Dream dream) {
        int color = Integer.parseInt(dream.getColor());
        Log.d("Color", Color.alpha(color) + "");
        int alpha =  Color.alpha(color),
                red = Color.red(color),
                green = Color.green(color),
                blue = Color.blue(color);
        if ((red*0.299 + green*0.587 + blue*0.114) > 186 ){
            mDreamDateTextView.setTextColor((Color.BLACK));
        } else {
            mDreamDateTextView.setTextColor(Color.WHITE);
        }

        mDreamDateTextView.setText(dream.getDate());
        mDreamDateTextView.setBackgroundColor(color);
    }
}
