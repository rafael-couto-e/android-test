package rafael.couto.testeapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import rafael.couto.testeapplication.R;
import rafael.couto.testeapplication.model.ListModel;
import rafael.couto.testeapplication.viewholder.ViewHolder;

/**
 * Created by rafael.couto on 26/06/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private List<ListModel> items;
    private Context context;

    public ListAdapter(List<ListModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder vh = new ViewHolder(LayoutInflater.from(context).inflate(viewType, parent, false));
        vh.loadComponents();
        return vh;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(getItem(position));
        holder.loadData(getItem(position));
        holder.setOnChildClickListener(this);
    }

    private ListModel getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View v) {
        ListModel index = (ListModel) v.getTag();

        for(int i = 0; i < getItemCount(); i++){
            if(getItem(i).equals(index)){
                items.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }
}
