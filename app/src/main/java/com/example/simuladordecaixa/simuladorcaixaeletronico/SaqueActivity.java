package com.example.simuladordecaixa.simuladorcaixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class SaqueActivity extends AppCompatActivity {
    TextView milSaque;
    Button retornarMainSaque;
    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button number0;

    private int saldoSaque=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);

            milSaque = (TextView) findViewById(R.id.tvValorDeposito);
            retornarMainSaque = (Button) findViewById(R.id.btConfirmarSaque);

            //Buttons
            number0 = (Button) findViewById(R.id.btNr0);
            number1 = (Button) findViewById(R.id.btNr1);
            number2 = (Button) findViewById(R.id.btNr2);
            number3 = (Button) findViewById(R.id.btNr3);
            number4 = (Button) findViewById(R.id.btNr4);
            number5 = (Button) findViewById(R.id.btNr5);
            number6 = (Button) findViewById(R.id.btNr6);
            number7 = (Button) findViewById(R.id.btNr7);
            number8 = (Button) findViewById(R.id.btNr8);
            number9 = (Button) findViewById(R.id.btNr9);

            //Mascaras de format
            SimpleMaskFormatter maskMil = new SimpleMaskFormatter("N.NNN,NN");
            MaskTextWatcher maskFormMil = new MaskTextWatcher(milSaque, maskMil);
            milSaque.addTextChangedListener(maskFormMil);

        }

    public void capturaBotoesSaque (View view){
        switch (view.getId()){

            /*case R.id.btNr0:
                String numero0;
                numero0 = ((Button)view).getText().toString();
                guardaNumeros(numero0);
            case R.id.btNr1:
                String numero1;
                numero1 = ((Button)view).getText().toString();
                guardaNumeros(numero1);
            case R.id.btNr2:
                String numero2;
                numero2 = ((Button)view).getText().toString();
                guardaNumeros(numero2);
            case R.id.btNr3:
                String numero3;
                numero3 = ((Button)view).getText().toString();
                guardaNumeros(numero3);
            case R.id.btNr4:
                String numero4;
                numero4 = ((Button)view).getText().toString();
                guardaNumeros(numero4);
            case R.id.btNr5:
                String numero5;
                numero5 = ((Button)view).getText().toString();
                guardaNumeros(numero5);
            case R.id.btNr6:
                String numero6;
                numero6 = ((Button)view).getText().toString();
                guardaNumeros(numero6);
            case R.id.btNr7:
                String numero7;
                numero7 = ((Button)view).getText().toString();
                guardaNumeros(numero7);
            case R.id.btNr8:
                String numero8;
                numero8 = ((Button)view).getText().toString();
                guardaNumeros(numero8);
            case R.id.btNr9:
                String numero9;
                numero9 = ((Button)view).getText().toString();
                guardaNumeros(numero9);*/
            //captura os keyboards
            default:
                String numerodef;
                numerodef = ((Button) view).getText().toString();
                getKeyboard(numerodef);
                break;
        }
    }
    public void depositoCaseSaque(View view){
        switch (view.getId()){
            //Button que envia os valores
            case R.id.btConfirmarSaque:
                if(saldoSaque > 0) {
                    passarValores("ValoresPassadosSaque", saldoSaque);
                    finish();
                    Toast.makeText(SaqueActivity.this, "Valor será transferido para sua conta corrente.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SaqueActivity.this, "O valor não está disponível para saque... ", Toast.LENGTH_SHORT).show();
                }break;

        }
    }

    public void getKeyboard(String str){
        String scrCurrent = milSaque.getText().toString();
        scrCurrent += str;
        milSaque.setText(scrCurrent);
        String saldoSemFormataçao = milSaque.getText().toString();
        String formatado = saldoSemFormataçao.replace(".", "");
        formatado = formatado.replace(",", "");

        saldoSaque = Integer.valueOf(formatado);

    }
    public void passarValores (String recebe, Integer passaMilhar){
        Intent passandoValoresParaSaldo = new Intent(this, SaldoActivity.class);
        passandoValoresParaSaldo.putExtra(recebe, passaMilhar);
        startActivity(passandoValoresParaSaldo);
    }

}

