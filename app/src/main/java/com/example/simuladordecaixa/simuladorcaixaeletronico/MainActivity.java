package com.example.simuladordecaixa.simuladorcaixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;

public class MainActivity extends AppCompatActivity {

    public Button btSaldo;
    public Button btSaque;
    public Button btDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSaldo = (Button) findViewById(R.id.btSaldo);
        btSaque = (Button) findViewById(R.id.btSaque);
        btDeposito= (Button) findViewById(R.id.btDeposito);


        btSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Toast saldo teste", Toast.LENGTH_SHORT).show();
                //Função saldo

                Intent Saldo = new Intent(MainActivity.this, Saldo2Activity.class);
                startActivity(Saldo);

            }
        });


        btSaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Toast saque teste", Toast.LENGTH_SHORT).show();
                //Função saque

                Intent Saque = new Intent(MainActivity.this, SaqueActivity.class);
                startActivity(Saque);
            }
        });

        btDeposito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Toast depósito teste", Toast.LENGTH_SHORT).show();
                //Função deposito

                Intent Deposito = new Intent(MainActivity.this, DepositoActivity.class);
                startActivity(Deposito);

            }
        });
    }

}
