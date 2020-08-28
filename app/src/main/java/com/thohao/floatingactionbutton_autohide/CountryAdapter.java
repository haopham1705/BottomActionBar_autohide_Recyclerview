package com.thohao.floatingactionbutton_autohide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter {
    private List<Country> countryList;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtDescription;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtCountryName);
            txtDescription = itemView.findViewById(R.id.txtCountryDescription);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CountryViewHolder countryViewHolder = (CountryViewHolder) holder;
        Country country = countryList.get(position);
        countryViewHolder.txtName.setText(country.getName());
        countryViewHolder.txtDescription.setText(country.getDescription());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
