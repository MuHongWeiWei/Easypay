package com.fly.easypay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.aviran.cookiebar2.CookieBar;
import org.aviran.cookiebar2.OnActionClickListener;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 100;
    int total;
    private TextView tvContent,tvCash;
    private TextView tvTotal, tvStore;
    private Button restart, exit;
    private TextView tvQueue;
    private String content;
    private String count;
    private String store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        content = getIntent().getStringExtra("content");
        count = getIntent().getStringExtra("count");
        store = getIntent().getStringExtra("store");
        int cash = getSharedPreferences("queue", MODE_PRIVATE).getInt("cash", 0);



        findViews();
        onClick();
        price();

        if((cash - total) < 0){
            new AlertDialog.Builder(this)
                    .setTitle("警告")
                    .setMessage("餘額不足.請加值")
                    .setCancelable(false)
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();

        }

        setData();
        

        tvCash.setText( (cash - total) + "$");
        getSharedPreferences("queue",MODE_PRIVATE)
                .edit()
                .putInt("cash",(cash - total))
                .apply();
    }



    private void setData() {
        int num = getSharedPreferences("queue", MODE_PRIVATE).getInt("num", 0);

        tvQueue.setText("第" + num + "號");

        tvTotal.setText(total + "$");
        getSharedPreferences("queue",MODE_PRIVATE)
                .edit()
                .putInt("total",total).apply();
        tvContent.setText(content + "*" + count);
        getSharedPreferences("queue",MODE_PRIVATE)
                .edit()
                .putString("content",content + "*" + count).apply();
        tvStore.setText(store);
    }

    private void price() {
        switch (content) {
            //food
            case "米血(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "雞翅(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            case "百頁豆腐(20元)":
                total = 20 * Integer.parseInt(count);
                break;
            case "鳥蛋(5元)":
                total = 5 * Integer.parseInt(count);
                break;
            case "豆干(5元)":
                total = 5 * Integer.parseInt(count);
                break;
            case "草莓冰淇淋(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "香草冰淇淋(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "花生冰淇淋(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "巧克力冰淇淋(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "梅子冰淇淋(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "紅豆麻糬(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "花生麻糬(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "奶酥麻糬(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "綠豆麻糬(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "黑糖麻糬(10元)":
                total = 10 * Integer.parseInt(count);
                break;
            case "蝦仁煎(65元)":
                total = 65 * Integer.parseInt(count);
                break;
            case "蚵仔煎(65元)":
                total = 65 * Integer.parseInt(count);
                break;
            case "綜合煎(75元)":
                total = 75 * Integer.parseInt(count);
                break;
            case "大(150元)":
                total = 150 * Integer.parseInt(count);
                break;
            case "中(100元)":
                total = 100 * Integer.parseInt(count);
                break;
            case "小(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "紅茶(20元)":
                total = 20 * Integer.parseInt(count);
                break;
            case "綠茶(20元)":
                total = 20 * Integer.parseInt(count);
                break;
            case "百香綠(35元)":
                total = 35 * Integer.parseInt(count);
                break;
            case "奶綠(40元)":
                total = 40 * Integer.parseInt(count);
                break;
            case "奶茶(40元)":
                total = 40 * Integer.parseInt(count);
                break;
            case "豬肉捲餅(40元)":
                total = 40 * Integer.parseInt(count);
                break;
            case "牛肉捲餅(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "雞肉捲餅(40元)":
                total = 40 * Integer.parseInt(count);
                break;
            case "鴨肉捲餅(45元)":
                total = 45 * Integer.parseInt(count);
                break;
            case "咖哩(35元)":
                total = 35 * Integer.parseInt(count);
                break;
            case "原味(35元)":
                total = 35 * Integer.parseInt(count);
                break;
            case "辣味(35元)":
                total = 35 * Integer.parseInt(count);
                break;
            case "麻辣鴨血(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "麻辣豬血(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "麻辣綜合(60元)":
                total = 60 * Integer.parseInt(count);
                break;
            case "香腸(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            case "大腸(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            case "大腸包小腸(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "炒麵(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            case "炒米粉(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            case "豬血湯(35元)":
                total = 35 * Integer.parseInt(count);
                break;
            case "肉燥飯(25元)":
                total = 25 * Integer.parseInt(count);
                break;
            //play
            case "搓麻將遊戲(1局50元 3局120元)":
                if (Integer.parseInt(count) % 3 == 0) {
                    total = 120 * Integer.parseInt(count) / 3;
                } else {
                    total = 50 * Integer.parseInt(count);
                }
                break;
            case "火影忍者(149元)":
                total = 149 * Integer.parseInt(count);
                break;
            case "航海王(149元)":
                total = 149 * Integer.parseInt(count);
                break;
            case "迪士尼(149元)":
                total = 149 * Integer.parseInt(count);
                break;
            case "鋼彈(149元)":
                total = 149 * Integer.parseInt(count);
                break;
            case "射氣球遊戲(1局50元 3局120元)":
                if (Integer.parseInt(count) % 3 == 0) {
                    total = 120 * Integer.parseInt(count) / 3;
                } else {
                    total = 50 * Integer.parseInt(count);
                }
                break;
            case "撈金魚遊戲(1局50元 3局120元)":
                if (Integer.parseInt(count) % 3 == 0) {
                    total = 120 * Integer.parseInt(count) / 3;
                } else {
                    total = 50 * Integer.parseInt(count);
                }
                break;
            case "打棒球遊戲(60元)":
                total = 60 * Integer.parseInt(count);
                break;
            case "投籃球遊戲(1局50元 3局120元)":
                if (Integer.parseInt(count) % 3 == 0) {
                    total = 120 * Integer.parseInt(count) / 3;
                } else {
                    total = 50 * Integer.parseInt(count);
                }
                break;
            case "星際大戰(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "科技系列(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "城市系列(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "交通系列(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            //cloth
            case "V領毛衣(250元)":
                total = 250 * Integer.parseInt(count);
                break;
            case "九分袖T恤(150元)":
                total = 150 * Integer.parseInt(count);
                break;
            case "連帽外套(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "毛絨長褲(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "MA-1飛行外套(1000元)":
                total = 1000 * Integer.parseInt(count);
                break;
            case "束口褲(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "格紋襯衫(250元)":
                total = 250 * Integer.parseInt(count);
                break;
            case "長襪(49元)":
                total = 49 * Integer.parseInt(count);
                break;
            case "牛仔褲(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "長袖T恤(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "短袖T恤(100元)":
                total = 100 * Integer.parseInt(count);
                break;
            case "棒球外套(550元)":
                total = 550 * Integer.parseInt(count);
                break;
            case "皮帶(100元)":
                total = 100 * Integer.parseInt(count);
                break;
            case "素面襯衫(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "POLO衫(250元)":
                total = 250 * Integer.parseInt(count);
                break;
            case "針織圍巾(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "羽絨外套(2000元)":
                total = 2000 * Integer.parseInt(count);
                break;
            case "牛仔襯衫(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "工作褲(350元)":
                total = 350 * Integer.parseInt(count);
                break;
            case "短襪(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "縮口褲(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "休閒長褲(300元)":
                total = 300 * Integer.parseInt(count);
                break;
            //CCC
            case "Iphone6保護貼(250元)":
                total = 250 * Integer.parseInt(count);
                break;
            case "Note8保護貼(200元)":
                total = 200 * Integer.parseInt(count);
                break;
            case "Apple充電線(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "行動電源(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "Iphone8保護貼(300元)":
                total = 300 * Integer.parseInt(count);
                break;
            case "耳罩式耳機(1500元)":
                total = 1500 * Integer.parseInt(count);
                break;
            case "耳機音源轉接線(350元)":
                total = 350 * Integer.parseInt(count);
                break;
            case "IphoneXR保護貼(450元)":
                total = 450 * Integer.parseInt(count);
                break;
            case "airpods犀牛盾(3000元)":
                total = 3000 * Integer.parseInt(count);
                break;
            case "Iphone7犀牛盾(2000元)":
                total = 2000 * Integer.parseInt(count);
                break;
            case "IphoneXS保護殼(1500元)":
                total = 1500 * Integer.parseInt(count);
                break;
            case "手機架(500元)":
                total = 500 * Integer.parseInt(count);
                break;
            case "三星S9+保護殼(650元)":
                total = 650 * Integer.parseInt(count);
                break;
            case "充電線保護套(50元)":
                total = 50 * Integer.parseInt(count);
                break;
            case "藍芽耳機(950元)":
                total = 950 * Integer.parseInt(count);
                break;
            case "三星S8犀牛盾(1500元)":
                total = 1500 * Integer.parseInt(count);
                break;
            case "airpods(3100元)":
                total = 3100 * Integer.parseInt(count);
                break;
            case "Switch保護殼(1500元)":
                total = 1500 * Integer.parseInt(count);
                break;
            case "IphoneXS max保護殼(1299元)":
                total = 1299 * Integer.parseInt(count);
                break;
            case "藍芽喇叭(2999元)":
                total = 2999 * Integer.parseInt(count);
                break;
            case "充電手機殼(1000元)":
                total = 1000 * Integer.parseInt(count);
                break;
            case "Iphone7保護殼(350元)":
                total = 350 * Integer.parseInt(count);
                break;
            case "IphoneX 犀牛盾(1999元)":
                total = 1999 * Integer.parseInt(count);
                break;
            case "apple充電線(399元)":
                total = 399 * Integer.parseInt(count);
                break;
        }

    }

    private void onClick() {
        restart.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    private void findViews() {
        tvContent = findViewById(R.id.tv_content);
        tvTotal = findViewById(R.id.tv_total);
        tvQueue = findViewById(R.id.tv_queue);
        tvStore = findViewById(R.id.tv_store);
        tvCash = findViewById(R.id.tv_cash);
        restart = findViewById(R.id.btn_restart);
        exit = findViewById(R.id.btn_exit);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_restart:
                finish();
                break;
            case R.id.btn_exit:
                Intent intent=new Intent(this,LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }


}
