package com.fly.easypay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.aviran.cookiebar2.CookieBar;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {


    private List<Store> stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        CookieBar.build(StoreActivity.this).setTitle("歡迎使用***夜市Easy Pay***").show();

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(StoreActivity.this, 4));

        stores = new ArrayList<>();
        stores.add(new Store("飲食區",R.drawable.food));
        stores.add(new Store("娛樂區",R.drawable.play));
        stores.add(new Store("服飾區",R.drawable.cloth));
        stores.add(new Store("3C區",R.drawable.ccc));

        recycler.setAdapter(new StoreAdapter());
    }


    class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreHolder> {

        @NonNull
        @Override
        public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_store,parent,false);
            return new StoreHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StoreHolder holder, final int position) {
            final Store store = stores.get(position);
            holder.nameText.setText(store.getName());
            holder.iconImage.setImageResource(store.getImage());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(StoreActivity.this, ArticleActivity.class);
                    intent.putExtra("Sort", store.getName());
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return stores.size();
        }

        class StoreHolder extends RecyclerView.ViewHolder {
            TextView nameText;
            ImageView iconImage;
            public StoreHolder(View itemView) {
                super(itemView);
                nameText = itemView.findViewById(R.id.item_name);
                iconImage = itemView.findViewById(R.id.item_image);
            }
        }
    }
}
