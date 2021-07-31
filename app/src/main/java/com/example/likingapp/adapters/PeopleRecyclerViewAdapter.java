package com.example.likingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.likingapp.BR;
import com.example.likingapp.databinding.RecyclerviewPeopleRowBinding;

import androidx.recyclerview.widget.RecyclerView;

import com.example.likingapp.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleRecyclerViewAdapter extends RecyclerView.Adapter<PeopleRecyclerViewAdapter.ViewHolder> implements Filterable {

    private final List<Person> mData;
    private final List<Person> mDataFull;
    private final LayoutInflater mInflater;
    private ItemActionListener mActionListener;

    public PeopleRecyclerViewAdapter(Context context, List<Person> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mDataFull = new ArrayList<>(data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerviewPeopleRowBinding recyclerviewPeopleRowBinding =
                RecyclerviewPeopleRowBinding.inflate(mInflater, parent, false);
        return new ViewHolder(recyclerviewPeopleRowBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object obj = mData.get(position);
        holder.bind(obj);
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
            List<Person> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFull);
            } else {
                String filterText = constraint.toString().toLowerCase().trim();

                for (Person person: mDataFull) {
                    if (person.name.toLowerCase().contains(filterText)) {
                        filteredList.add(person);
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
        private final RecyclerviewPeopleRowBinding binding;

        ViewHolder(RecyclerviewPeopleRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.imageViewBinIcon.setOnClickListener(v -> mActionListener.deleteItem(getAdapterPosition()));
            binding.imageViewEditIcon.setOnClickListener(v -> mActionListener.editItem(getAdapterPosition()));
        }

        public void bind(Object obj) {
            binding.setVariable(BR.person, obj);
            binding.executePendingBindings();
        }
    }

    // Helper function to return element by position
    public Person getItem(int id) {
        return mData.get(id);
    }

    // Helper function to add elements
    public void add(int position, Person person) {
        mData.add(position, person);
        notifyDataSetChanged();
    }

    // Helper function to remove elements
    public void remove(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    // Helper function to update elements
    public void update(int position, Person person) {
        mData.set(position, person);
        notifyDataSetChanged();
    }

    // Interface for delete and edit functions
    public interface ItemActionListener {
        void deleteItem(int position);
        void editItem(int position);
    }

    // Bind ActionListener
    public void setActionListener(ItemActionListener itemActionListener) {
        this.mActionListener = itemActionListener;
    }
}
