package com.example.sqlliteinterndevelopmentlogics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button enterDetail,ViewAll;
EditText username,email;
HelpSqlLite DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        email=findViewById(R.id.Email);
      enterDetail=findViewById(R.id.Add);
      ViewAll=findViewById(R.id.button4);
DB=new HelpSqlLite(this);
enterDetail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String userName = username.getText().toString();
        String emaill = email.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(emaill)) {
            Toast.makeText(MainActivity.this, "Please add details", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkinsertData = DB.insertuserData(userName, emaill);
            if (checkinsertData == true) {
                Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failed to add User", Toast.LENGTH_SHORT).show();
            }
        }
    }
});
ViewAll.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,AllEntires.class);
        startActivity(intent);
    }
});
    }
}