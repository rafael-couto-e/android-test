package rafael.couto.testeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import rafael.couto.testeapplication.adapter.ListAdapter;
import rafael.couto.testeapplication.model.ListModel;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvItems = findViewById(R.id.rvItems);
        ListAdapter adapter = new ListAdapter(new ArrayList<ListModel>(){{
            add(new ListModel("One", "1"));
            add(new ListModel("Two", "2"));
            add(new ListModel("Three", "3"));
            add(new ListModel("Four", "4"));
            add(new ListModel("Five", "5"));
        }}, this);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setItemAnimator(new DefaultItemAnimator());
        rvItems.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return false;
    }
}
