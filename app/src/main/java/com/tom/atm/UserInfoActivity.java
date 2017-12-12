package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }
    public void back(View view){
        EditText edName = (EditText) findViewById(R.id.edname);
        EditText edPhone = (EditText) findViewById(R.id.edphone);
        String edname = edName.getText().toString();
        String edphone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", edname);
        getIntent().putExtra("EXTRA_PHONE", edphone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
}
