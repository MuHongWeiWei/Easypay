package com.fly.easypay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoreLookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_look);

        TextView tvStore = findViewById(R.id.tv_store);
        TextView tvTotal = findViewById(R.id.tv_total);
        TextView tvNum = findViewById(R.id.tv_num);
        TextView tvContent = findViewById(R.id.tv_content);
        final Button finish = findViewById(R.id.btn_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish.setText("已完成");
            }
        });


        String store = getSharedPreferences("queue", MODE_PRIVATE).getString("store", "");
        tvStore.setText(store);
        int total = getSharedPreferences("queue", MODE_PRIVATE).getInt("total", 0);
        tvTotal.setText("金額:" +total + "$");
        int num = getSharedPreferences("queue", MODE_PRIVATE).getInt("num", 0);
        tvNum.setText("訂單編號:" + num);
        String content = getSharedPreferences("queue", MODE_PRIVATE).getString("content", "");
        tvContent.setText("購買物品:"+content);

    }
}
