package com.tom.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPhone;
    private Spinner ages;
    private String TAG = UserInfoActivity.class.getSimpleName();

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
        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 15; i <= 40; i++){
            data.add(i + "");
        }
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ages, android.R.layout.simple_list_item_1);
        ages.setAdapter(adapter);
    }
    public void back(View view){
        Log.d(TAG, "ok: " + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        String edname = edName.getText().toString();
        String edphone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", edname);
        getIntent().putExtra("EXTRA_PHONE", edphone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
}
