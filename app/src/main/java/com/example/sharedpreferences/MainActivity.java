package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, pass;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private void init(){
        username = findViewById(R.id.activity_main_username);
        pass = findViewById(R.id.activity_main_pass);
        checkBox = findViewById(R.id.activity_main_checkbox);
        sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        String getusername = sharedPreferences.getString("username" , null);

        if (!TextUtils.isEmpty(getusername))
            username.setText(getusername);
        else
            Toast.makeText(this, "Kayıt Yok", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void Login(View v){
        String txtUserName = username.getText().toString();
        String txtPass = pass.getText().toString();

        if (!TextUtils.isEmpty(txtUserName) && !TextUtils.isEmpty(txtPass)){
            if (checkBox.isChecked()){
                editor = sharedPreferences.edit();
                editor.putString("username", txtUserName);
                editor.apply();
                Toast.makeText(this, "Kullanıcı Adını Kaydettim", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Kutucukları Boş Bırakmayınız!", Toast.LENGTH_SHORT).show();
    }
}