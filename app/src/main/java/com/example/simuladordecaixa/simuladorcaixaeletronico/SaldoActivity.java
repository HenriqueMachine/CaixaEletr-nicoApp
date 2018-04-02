package com.example.simuladordecaixa.simuladorcaixaeletronico;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class SaldoActivity extends AppCompatActivity {

    private TextView telaSaldo;
    private Button confirmarTelaSaldo;
    private int meuDinheiro = 0;

    public static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        telaSaldo = (TextView) findViewById(R.id.tvSaldo);
        confirmarTelaSaldo = (Button) findViewById(R.id.btConfirmar);

        //Recupera valor saldo
        SharedPreferences sharedPreferencesRecuperaValor = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferencesRecuperaValor.contains("saldoSalvo") ){
            String saldoRecuperado = sharedPreferencesRecuperaValor.getString("saldoSalvo", "0");
            int saldoRecuperadoInt = Integer.valueOf(saldoRecuperado);
            meuDinheiro = meuDinheiro + saldoRecuperadoInt;

        }

        //Chamada funções saque e deposito
        Intent it = getIntent();
        final int deposito = it.getIntExtra("ValoresPassadosDeposito", 0 );

            if ( deposito > 0 ){

            meuDinheiro = meuDinheiro + deposito;

        }

        Intent newIt = getIntent();
        final int saque = newIt.getIntExtra("ValoresPassadosSaque",0);
            if(saque > 0 ){

            meuDinheiro = meuDinheiro - saque ;

        }

        final String meuDinheiroString = String.valueOf(meuDinheiro);

        if(meuDinheiroString.length() >= 3 ){

        }

        SimpleMaskFormatter maskSaldo = new SimpleMaskFormatter(" N.NNN,NN ");
        MaskTextWatcher maskFormSaldo = new MaskTextWatcher(telaSaldo, maskSaldo);
        telaSaldo.addTextChangedListener(maskFormSaldo);
        //mostrarDeposito.setText(saldoDeposito);
        //mostrarSaque.setText(saldoSaque);

        confirmarTelaSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Volta Menu
                Intent voltaMenu = new Intent(SaldoActivity.this, MainActivity.class);
                finish();
                startActivity(voltaMenu);

                //Salva preferências
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String armazenaSaldo = meuDinheiroString ;
                editor.putString("saldoSalvo", armazenaSaldo);
                editor.commit();
            }
        });

        //Recupera preferências
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferences.contains("saldoSalvo") ){
           //String saldoRecuperado = sharedPreferences.getString("saldoSalvo", "0");
            telaSaldo.setText(meuDinheiroString);

        }

    }

}

