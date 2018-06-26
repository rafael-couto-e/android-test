package rafael.couto.testeapplication.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import rafael.couto.testeapplication.R;
import rafael.couto.testeapplication.model.ListModel;

/**
 * Created by rafael.couto on 26/06/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvName;
    private TextView tvAge;
    private Button btnRemove;

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public void loadComponents(){
        tvName = itemView.findViewById(R.id.tvName);
        tvAge = itemView.findViewById(R.id.tvAge);
        btnRemove = itemView.findViewById(R.id.btnRemove);
    }

    public void loadData(ListModel item){
        tvName.setText(item.getName());
        tvAge.setText(item.getAge());
        btnRemove.setTag(item);
        btnRemove.setOnClickListener(this);
    }

    public void setOnChildClickListener(View.OnClickListener listener){
        itemView.setOnClickListener(listener);
    }

    @Override
    public void onClick(View v) {
        ListModel item = (ListModel) v.getTag();
        Toast.makeText(itemView.getContext(), item.toString(), Toast.LENGTH_SHORT).show();
    }
}
