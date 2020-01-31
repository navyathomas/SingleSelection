package com.example.boomdesign;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectNumberAdapter extends RecyclerView.Adapter<SelectNumberAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PhoneNumberModel> phoneNumberModels;
    private int checkedPosition = 0;/**first item is selected by default..**/


    /**
     * Interface for Listeners
     **/
    private onItemClikListeners itemClikListeners;

    public interface onItemClikListeners {
        void onItemClikListeners(View view, int position, String phoneNumberModel);
    }

    public void setOnItemClikListeners(onItemClikListeners onItemClikListeners) {
        this.itemClikListeners = onItemClikListeners;
    }

    /**
     *
     **/


    public SelectNumberAdapter(Context context, ArrayList<PhoneNumberModel> phoneNumberModels) {
        this.context = context;
        this.phoneNumberModels = phoneNumberModels;
    }


    public void setPhoneNumber(ArrayList<PhoneNumberModel> phoneNumberModels1) {
        this.phoneNumberModels = new ArrayList<>();
        this.phoneNumberModels = phoneNumberModels1;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.select_number_item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(phoneNumberModels.get(i));

    }

    @Override
    public int getItemCount() {
        return phoneNumberModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textPhoneNumber;
        private LinearLayout linearPhoneNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textPhoneNumber = itemView.findViewById(R.id.tv_select_phoneNumber);
            linearPhoneNumber = itemView.findViewById(R.id.linr_select_phoneNumber);
        }

        void bind(final PhoneNumberModel phoneNumberModel) {

            if (checkedPosition == -1) {
                /**There is no default selection.**/
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    textPhoneNumber.setBackgroundResource(R.drawable.bg_outline_number_active);
                    textPhoneNumber.setTextColor(Color.WHITE);
                } else {
                    textPhoneNumber.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    textPhoneNumber.setTextColor(context.getResources().getColor(R.color.text_number_colour));
                }
            }

            textPhoneNumber.setText(phoneNumberModel.getPhoneNumber());


            linearPhoneNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        textPhoneNumber.setBackgroundResource(R.drawable.bg_outline_number_active);
                        textPhoneNumber.setTextColor(Color.WHITE);
                        checkedPosition = getAdapterPosition();

                    }
                    if (itemClikListeners != null) {
                        itemClikListeners.onItemClikListeners(v, getAdapterPosition(), phoneNumberModel.getPhoneNumber());
                    }
                }
            });
        }
    }

    public PhoneNumberModel getSelected() {
        if (checkedPosition != -1) {
            /**if there is default selection**/
            return phoneNumberModels.get(checkedPosition);
        }
        return null;
    }
}
