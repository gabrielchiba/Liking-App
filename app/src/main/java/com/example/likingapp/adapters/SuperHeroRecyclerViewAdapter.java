package com.example.likingapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.likingapp.BR;
import com.example.likingapp.databinding.RecyclerviewSuperheroRowBinding;
import com.example.likingapp.models.Hero;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroRecyclerViewAdapter extends RecyclerView.Adapter<SuperHeroRecyclerViewAdapter.ViewHolder>{
    private final List<Hero> mData;
    private final LayoutInflater mInflater;
    private SuperHeroRecyclerViewAdapter.ItemActionListener mActionListener;

    public SuperHeroRecyclerViewAdapter(Context context, List<Hero> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
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
    }

    // Return total number of elements on list
    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerviewSuperheroRowBinding binding;

        ViewHolder(RecyclerviewSuperheroRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.imageViewBinIcon2.setOnClickListener(v -> mActionListener.deleteItem(getAdapterPosition()));
            binding.imageViewEditIcon2.setOnClickListener(v -> mActionListener.editItem(getAdapterPosition()));
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

    //Helper function to filter elements
    public List<Hero> filter(String queryText)
    {
        List<Hero> copyList = new ArrayList<>();

        Log.d("DATA", String.valueOf(copyList));

        if(queryText.isEmpty())
        {
            copyList.addAll(mData);
        }
        else
        {

            for(Hero hero: mData)
            {
                if(hero.getName().toLowerCase().contains(queryText.toLowerCase()))
                {
                    copyList.add(hero);
                }
            }

        }
        Log.d("DATA", String.valueOf(copyList));
        Log.d("DATA", String.valueOf(mData));
        notifyDataSetChanged();
        return copyList;

    }

    // Interface for delete and edit functions
    public interface ItemActionListener {
        void deleteItem(int position);
        void editItem(int position);
    }

    // Bind ActionListener
    public void setActionListener(SuperHeroRecyclerViewAdapter.ItemActionListener itemActionListener) {
        this.mActionListener = itemActionListener;
    }
}
