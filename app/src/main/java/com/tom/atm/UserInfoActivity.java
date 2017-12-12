package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edName = (EditText) findViewById(R.id.edname);
        edPhone = (EditText) findViewById(R.id.edphone);
        String edname = getSharedPreferences("info", MODE_PRIVATE)
                .getString("NAME","");
        String edphone = getSharedPreferences("info", MODE_PRIVATE)
                .getString("PHONE", "");
        edName.setText(edname);
        edPhone.setText(edphone);

    }
    public void back(View view){
        String edname = edName.getText().toString();
        String edphone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", edname);
        getIntent().putExtra("EXTRA_PHONE", edphone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
}
