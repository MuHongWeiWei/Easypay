package com.fly.easypay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener ,View.OnClickListener {

    private static final String TAG = ArticleActivity.class.getSimpleName();
    private TextView tvSort;
    private Spinner store, all, amount;
    private int storeChoice;
    private int allChoice;
    private String sort;
    private Button finish;
    private String content;
    private String count;
    private String store_choice;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        findViews();
        choiceSort();
        choiceAmount();

    }

    private void queueNum() {
        getSharedPreferences("queue",MODE_PRIVATE)
                .edit()
                .putInt("num",num)
                .apply();
    }

    @Override
    protected void onStart() {
        super.onStart();
        int cash = getSharedPreferences("queue", MODE_PRIVATE).getInt("cash", 0);
        if(!(cash < 0)){
            num++;
        }
        queueNum();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] stores = getResources().getStringArray(storeChoice);
        store_choice = stores[i];
        switch (store_choice) {
            //all
            case "老三滷味":
                allChoice = R.array.food_braised;
                break;
            case "春捲冰淇淋":
                allChoice = R.array.food_iceCream;
                break;
            case "阿餐麻糬":
                allChoice = R.array.food_mochi;
                break;
            case "澎湖蚵仔煎":
                allChoice = R.array.food_oyster;
                break;
            case "蘭嶼烤小卷":
                allChoice = R.array.food_seafood;
                break;
            case "田在新飲料":
                allChoice = R.array.food_drink;
                break;
            case "朝豐捲餅":
                allChoice = R.array.food_burrito;
                break;
            case "印度魚蛋":
                allChoice = R.array.food_fish_eggs;
                break;
            case "七哥麻辣燙":
                allChoice = R.array.food_mala_tang;
                break;
            case "黑橋香腸":
                allChoice = R.array.food_sausage;
                break;
            case "響饕小吃":
                allChoice = R.array.food_snack;
                break;
            //play
            case "小東搓麻將":
                allChoice = R.array.play_mahjong;
                break;
            case "窄南公仔":
                allChoice = R.array.play_doll;
                break;
            case "狙擊手射氣球":
                allChoice = R.array.play_balloon;
                break;
            case "也似撈金魚":
                allChoice = R.array.play_fish;
                break;
            case "好棒打擊場":
                allChoice = R.array.play_baseball;
                break;
            case "神射手投籃":
                allChoice = R.array.play_basketball;
                break;
            case "童玩積木":
                allChoice = R.array.play_block;
                break;
            //cloth
            case "好穿服飾店":
                allChoice = R.array.cloth_one;
                break;
            case "好買服飾店":
                allChoice = R.array.cloth_two;
                break;
            case "來來服飾店":
                allChoice = R.array.cloth_three;
                break;
            case "來買服飾店":
                allChoice = R.array.cloth_four;
                break;
            case "熊讚服飾店":
                allChoice = R.array.cloth_five;
                break;
            case "一級棒服飾店":
                allChoice = R.array.cloth_six;
                break;
            case "超讚服飾店":
                allChoice = R.array.cloth_seven;
                break;
            case "超好服飾店":
                allChoice = R.array.cloth_eight;
                break;
            //CCC
            case "阿坤3C":
                allChoice = R.array.CCC_one;
                break;
            case "阿燦3C":
                allChoice = R.array.CCC_two;
                break;
            case "阿明3C":
                allChoice = R.array.CCC_three;
                break;
            case "阿國3C":
                allChoice = R.array.CCC_four;
                break;
            case "小美3C":
                allChoice = R.array.CCC_five;
                break;
            case "阿興3C":
                allChoice = R.array.CCC_six;
                break;
            case "阿隆3C":
                allChoice = R.array.CCC_seven;
                break;
            case "小乖3C":
                allChoice = R.array.CCC_eight;
                break;
            case "阿皓3C":
                allChoice = R.array.CCC_nine;
                break;
        }
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(ArticleActivity.this, allChoice, android.R.layout.simple_spinner_dropdown_item);
        all.setAdapter(foodAdapter);
        all.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                content = String.valueOf(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void findViews() {
        sort = getIntent().getStringExtra("Sort");
        tvSort = findViewById(R.id.tv_sort);
        store = findViewById(R.id.store_item);
        all = findViewById(R.id.food_item);
        amount = findViewById(R.id.amount_item);
        finish = findViewById(R.id.btn_finish);
        finish.setOnClickListener(this);
        tvSort.setText(sort);
    }

    private void choiceSort() {
        switch (sort) {
            case "飲食區":
                storeChoice = R.array.food;
                break;
            case "娛樂區":
                storeChoice = R.array.play;
                break;
            case "服飾區":
                storeChoice = R.array.cloth;
                break;
            case "3C區":
                storeChoice = R.array.CCC;
                break;
        }
        ArrayAdapter<CharSequence> storeAdapter = ArrayAdapter.createFromResource(ArticleActivity.this, storeChoice, android.R.layout.simple_spinner_dropdown_item);
        store.setAdapter(storeAdapter);
        store.setOnItemSelectedListener(this);
    }

    private void choiceAmount() {
        ArrayAdapter<CharSequence> storeAdapter = ArrayAdapter.createFromResource(ArticleActivity.this, R.array.amount, android.R.layout.simple_spinner_dropdown_item);
        amount.setAdapter(storeAdapter);
        amount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                count = String.valueOf(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("content", content);
        intent.putExtra("store",store_choice);

        getSharedPreferences("queue",MODE_PRIVATE)
                .edit()
                .putString("store",store_choice).apply();

        intent.putExtra("count",count);
        startActivity(intent);
    }
}
