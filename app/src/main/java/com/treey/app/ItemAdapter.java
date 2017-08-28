package com.treey.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tang on 2017/8/25.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<GoodsItmeEntity> entities;
    private Context context;

    public ItemAdapter(ArrayList<GoodsItmeEntity> entities) {
        this.entities = entities;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itme_goods_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.tvGoodsNemaOne.setText(entities.get(position).name);
        holder.tvGoodsPriceOne.setText(entities.get(position).price);
        holder.tvGoodsMinprofitOne.setText(entities.get(position).updata);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }
        });

    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_goods_nema_one)
        TextView tvGoodsNemaOne;
        @BindView(R.id.tv_goods_price_one)
        TextView tvGoodsPriceOne;
        @BindView(R.id.tv_goods_minprofit_one)
        TextView tvGoodsMinprofitOne;
        @BindView(R.id.btn_goods_one)
        Button btnGoodsOne;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

