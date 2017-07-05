package com.example.telephonebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences.Editor editor;
    private EditText nametext;
   private EditText numtext;
    private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nametext=(EditText)findViewById(R.id.name_editText);
        numtext=(EditText)findViewById(R.id.number_edittext);
        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insert:
                String name = nametext.getText().toString();
                String number = numtext.getText().toString();
                                if (!name.equals("")) {
                    if (number.matches("[1][1-9][\\d]{9}")) {
                Intent intentService=new Intent(this,MyIntentService.class);
                intentService.putExtra("name",name);
                intentService.putExtra("number",number);
                startService(intentService);
                Intent intentActivity=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intentActivity);
                                    }else {
                        Toast.makeText(Main2Activity.this,"号码格式错误",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Main2Activity.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Main2Activity.this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}
