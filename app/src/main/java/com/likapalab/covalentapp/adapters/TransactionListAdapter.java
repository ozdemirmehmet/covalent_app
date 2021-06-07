/*
 * Created by Mehmet Ozdemir on 06.06.2021 20:46
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 06.06.2021 16:38
 */

package com.likapalab.covalentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.likapalab.covalentapp.R;
import com.likapalab.covalentapp.api.transcation.TransactionItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //Class Variables
    private Context context;
    private String myWalletAddress;
    private String updatedAt;
    private List<TransactionItem> transactionList;

    public TransactionListAdapter(String myWalletAddress, String updatedAt, List<TransactionItem> transactionList) {
        this.myWalletAddress = myWalletAddress;
        this.updatedAt = updatedAt;
        this.transactionList = transactionList;
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {
        private TextView fromTextView;
        private TextView toTextView;
        private TextView valueTextView;
        private TextView ageTextView;
        private ImageView statusImageView;

        public TransactionViewHolder(View view) {
            super(view);
            fromTextView = view.findViewById(R.id.text_view_from);
            toTextView = view.findViewById(R.id.text_view_to);
            valueTextView = view.findViewById(R.id.text_view_value);
            ageTextView = view.findViewById(R.id.text_view_age);
            statusImageView = view.findViewById(R.id.image_view_status);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template_transaction, parent, false);
        context = parent.getContext();
        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TransactionViewHolder transactionViewHolder = (TransactionViewHolder) holder;

        final TransactionItem transactionItem = transactionList.get(position);
        if (transactionItem != null) {
            if (transactionItem.getFromAddressLabel() == null) {
                if (transactionItem.getFromAddress().toLowerCase().equals(myWalletAddress.toLowerCase())) {
                    transactionViewHolder.fromTextView.setText(context.getString(R.string.text_my_wallet));
                } else {
                    transactionViewHolder.fromTextView.setText(context.getString(R.string.text_other_wallet));
                }
            } else {
                transactionViewHolder.fromTextView.setText(String.valueOf(transactionItem.getFromAddressLabel()));
            }
            if (transactionItem.getToAddressLabel() == null) {
                if (transactionItem.getToAddress().toLowerCase().equals(myWalletAddress.toLowerCase())) {
                    transactionViewHolder.toTextView.setText(context.getString(R.string.text_my_wallet));
                } else {
                    transactionViewHolder.toTextView.setText(context.getString(R.string.text_other_wallet));
                }
            } else {
                transactionViewHolder.toTextView.setText(String.valueOf(transactionItem.getToAddressLabel()));
            }
            transactionViewHolder.valueTextView.setText(String.valueOf(Long.parseLong(transactionItem.getValue()) / Math.pow(10, 18)));
            transactionViewHolder.ageTextView.setText(getAge(transactionItem));

            if (transactionItem.isSuccessful()) {
                transactionViewHolder.statusImageView.setImageResource(R.drawable.icon_success);
            } else {
                transactionViewHolder.statusImageView.setImageResource(R.drawable.icon_error);
            }
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    private String getAge(TransactionItem transactionItem) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date blockSignedAt = fmt.parse(transactionItem.getBlockSignedAt().replace("T", " ").substring(0, 19));
            Date updatedAtDate = fmt.parse(updatedAt.replace("T", " ").substring(0, 19));
            long age = updatedAtDate.getTime() - blockSignedAt.getTime();
            int seconds = (int) (age / 1000 % 60);
            int minutes = (int) (age / (60 * 1000) % 60);
            int hours = (int) (age / (60 * 60 * 1000) % 24);
            int days = (int) (age / (24 * 60 * 60 * 1000));
            return days + " days " + hours + " hours " + minutes + " mins " + seconds + " secs";
        } catch (ParseException e) {
            e.printStackTrace();
            return "not calculated";
        }
    }
}
