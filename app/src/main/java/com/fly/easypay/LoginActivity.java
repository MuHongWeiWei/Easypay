package com.fly.easypay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.elasticviews.ElasticButton;

import org.aviran.cookiebar2.CookieBar;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private Button customer;
    private Button store;
    private ImageView qRcode;
    private TextView storeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setResult(RESULT_OK);
        findViews();

        customer.setOnClickListener(this);
        store.setOnClickListener(this);
    }

    private void findViews() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        customer = findViewById(R.id.customer);
        store = findViewById(R.id.store);
        qRcode = findViewById(R.id.QRcode);
        storeText = findViewById(R.id.tv_store);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String store = getSharedPreferences("queue", MODE_PRIVATE).getString("store", "");
        Bitmap bitmap = QRCodeUtil.createQRCodeBitmap(store, 480, 480);
        qRcode.setImageBitmap(bitmap);
        storeText.setText(store);
    }

    @Override
    public void onClick(View view) {
        String acccount = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        switch (view.getId()){
            case R.id.customer:
               if(acccount.equals("11111")&&password.equals("11111")){
                   startActivity(new Intent(LoginActivity.this,StoreActivity.class));
                   getSharedPreferences("queue",MODE_PRIVATE)
                           .edit()
                           .putInt("cash",1000)
                           .apply();
               }else{
                   CookieBar.build(LoginActivity.this)
                           .setTitle("帳密輸入錯誤")
                           .setLayoutGravity(Gravity.BOTTOM)
                           .show();
               }
                break;
               case R.id.store:
               if(acccount.equals("22222")&&password.equals("22222")){
                   startActivity(new Intent(LoginActivity.this,StoreLookActivity.class));
               }else{
                   CookieBar.build(LoginActivity.this)
                           .setTitle("帳密輸入錯誤")
                           .setLayoutGravity(Gravity.BOTTOM)
                           .show();
               }
                break;
        }
    }
}
