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

public class Saldo2Activity extends AppCompatActivity {

    private TextView saldoDaTelaMenu;
    private Button confirmarDaTelaMenu;
    public static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo2);

        saldoDaTelaMenu = (TextView) findViewById(R.id.tvSaldo2);
        confirmarDaTelaMenu = (Button) findViewById(R.id.btConfirmarTelaMostrar);

        SimpleMaskFormatter maskSaldo = new SimpleMaskFormatter(" N.NNN,NN ");
        MaskTextWatcher maskFormSaldo = new MaskTextWatcher(saldoDaTelaMenu, maskSaldo);
        saldoDaTelaMenu.addTextChangedListener(maskFormSaldo);


        //Recupera preferências
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferences.contains("saldoSalvo") ) {
            String saldoRecuperado = sharedPreferences.getString("saldoSalvo", "0");
            //telaSaldo.setText(saldoRecuperado);
            saldoDaTelaMenu.setText(saldoRecuperado);
        }

        confirmarDaTelaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Volta Menu
                Intent voltaMenu = new Intent(Saldo2Activity.this, MainActivity.class);
                finish();
                startActivity(voltaMenu);

            }
        });

        }
}
