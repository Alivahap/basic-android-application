package com.example.uygulama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, EditText.OnEditorActionListener{
Button BSaldir,Byemek,Buyu;
TextView tx,tx2;
    karekter k;
    EditText isim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim = findViewById(R.id.editText);
        tx =findViewById(R.id.karakter);
        if(savedInstanceState!=null){
            k=savedInstanceState.getParcelable("karekter");
            k.isim =isim.getText().toString();
            isim.setVisibility(View.INVISIBLE);
            tx.setText(k.tostring());


        }
        else{

            k = new karekter();
            k.hareketsayisi=10;
            k.saldirigucu=100;
            k.kilo=10;

        }

           tx2 = findViewById(R.id.textView2);

            BSaldir = findViewById(R.id.saldir);
            Byemek = findViewById(R.id.yemek);
            Buyu = findViewById(R.id.uyu);







        BSaldir.setOnClickListener(this);
        Byemek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tx2.setText(k.yemek());

                tx.setText(k.tostring());
            }
        });

        Buyu.setOnClickListener(this);




        tx.setText(k.tostring());

        tx2.setText("Oyuna Hoşgeldiniz lütfen bir eylem seçiniz");

          isim.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        tx2.setText("karakterin ismi "+isim.getText()+"olarak atandı"    );


        return true ;
    }

    public void onClick(View v){
  if(v.getId()==BSaldir.getId())
    tx2.setText(k.savas());



else if(v.getId()==Buyu.getId())
    tx2.setText(k.uyumak());


    tx.setText(k.tostring());


}

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("karekter",k);

    }



}