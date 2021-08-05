package com.example.likingapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.likingapp.BR;
import com.example.likingapp.R;
import com.example.likingapp.databinding.RecyclerviewSuperheroRowBinding;
import com.example.likingapp.models.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroRecyclerViewAdapter extends RecyclerView.Adapter<SuperHeroRecyclerViewAdapter.ViewHolder> implements Filterable {
    private final List<Hero> mData;
    private final List<Hero> mDataFull;
    private final LayoutInflater mInflater;
    private boolean isDelete = false;
    private SuperHeroRecyclerViewAdapter.ItemActionListener mActionListener;

    public SuperHeroRecyclerViewAdapter(Context context, List<Hero> data, boolean isDelete) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mDataFull = new ArrayList<>(data);
        this.isDelete = isDelete;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerviewSuperheroRowBinding recyclerviewSuperheroRowBinding =
                RecyclerviewSuperheroRowBinding.inflate(mInflater, parent, false);
        return new ViewHolder(recyclerviewSuperheroRowBinding);
    }

    @Override
    public void onBindViewHolder(SuperHeroRecyclerViewAdapter.ViewHolder holder, int position) {
        Object obj = mData.get(position);
        holder.bind(obj);
        changeIcon(holder);
        setThumbnail(holder);
    }

    // Check and change Action Icon if necessary
    public void changeIcon(SuperHeroRecyclerViewAdapter.ViewHolder holder) {
        if (isDelete) {
            holder.binding.imageViewAddIcon.setImageResource(R.drawable.bin);
        }
    }

    // Helper function to set thumbnail element
    public void setThumbnail(SuperHeroRecyclerViewAdapter.ViewHolder holder) {
        String imageURL = holder.binding.getHero().thumbnail_url;
        if (imageURL == null) {
            String thumbnail = holder.binding.getHero().thumbnail.getPath();
            if (thumbnail != null && !thumbnail.isEmpty()) {
                imageURL = holder.binding.getHero().thumbnail.getPath() + "." +
                        holder.binding.getHero().thumbnail.getExtension();
            }
        }

        Picasso.get().load(imageURL).into(holder.binding.heroAvatar);
    }

    // Return total number of elements on list
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public Filter getFilter() {
        return mDataFilter;
    }

    // Helper function to filter elements
    private Filter mDataFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Hero> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFull);
            } else {
                String filterText = constraint.toString().toLowerCase().trim();

                for (Hero hero: mDataFull) {
                    if (hero.name.toLowerCase().contains(filterText)) {
                        filteredList.add(hero);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerviewSuperheroRowBinding binding;

        ViewHolder(RecyclerviewSuperheroRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.imageViewInfoIcon.setOnClickListener(v -> mActionListener.infoItem(getAdapterPosition()));
            binding.imageViewAddIcon.setOnClickListener(v -> mActionListener.addOrDeleteItem(getAdapterPosition()));
        }

        public void bind(Object obj) {
            binding.setVariable(BR.hero, obj);
            binding.executePendingBindings();
        }
    }

    // Helper function to return element by position
    public Hero getItem(int id) {
        return mData.get(id);
    }

    // Helper function to add elements
    public void add(int position, Hero character) {
        mData.add(position, character);
        notifyDataSetChanged();
    }

    // Helper function to add multiples elements
    public void addAll(List<Hero> heroes) {
        if (heroes != null) {
            mData.addAll((List)heroes);
            mDataFull.addAll((List)heroes);
            notifyDataSetChanged();
        }
    }

    // Helper function to remove elements
    public void remove(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    // Helper function to update elements
    public void update(int position, Hero character) {
        mData.set(position, character);
        notifyDataSetChanged();
    }

    // Interface for add/delete and edit functions
    public interface ItemActionListener {
        void infoItem(int position);
        void addOrDeleteItem(int position);
    }

    // Bind ActionListener
    public void setActionListener(SuperHeroRecyclerViewAdapter.ItemActionListener itemActionListener) {
        this.mActionListener = itemActionListener;
    }
}
