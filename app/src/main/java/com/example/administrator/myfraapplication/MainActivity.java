package com.example.administrator.myfraapplication;


import android.content.DialogInterface;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.fra_00);
        setContentView(R.layout.fra_01);
        setContentView(R.layout.fra_button);
        Button button_1 = (Button)findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        replaceFragment(new fra_01());
        Button button_2 = (Button)findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        replaceFragment(new fra_00());
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_1:
                replaceFragment(new fra_01());
                break;
            case R.id.button_2:
                replaceFragment(new fra_00());
                break;
            default:
                break;
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fra_01,fragment);
        transaction.replace(R.id.fra_00,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
