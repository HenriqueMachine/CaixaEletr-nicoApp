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

public class DepositoActivity extends AppCompatActivity {

    TextView mil;
    Button retornarMain;
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

    private int saldo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        mil = (TextView) findViewById(R.id.tvValorDeposito);
        retornarMain = (Button) findViewById(R.id.button11);

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
        MaskTextWatcher maskFormMil = new MaskTextWatcher(mil, maskMil);

        mil.addTextChangedListener(maskFormMil);

    }

public void capturaBotoes (View view){
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
    public void depositoCase(View view){
        switch (view.getId()){
            //Button que envia os valores
            case R.id.button11:
                if(saldo > 0) {
                    passarValores("ValoresPassadosDeposito", saldo);
                    finish();
                    Toast.makeText(DepositoActivity.this, "Valor depositado da sua conta corrente para seu banco digital", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(DepositoActivity.this, "Não é possível depositar este valor", Toast.LENGTH_SHORT).show();
                }break;

        }
    }

    public void getKeyboard(String str){
        String scrCurrent = mil.getText().toString();
        scrCurrent += str;
        mil.setText(scrCurrent);

        String saldoSemFormataçao = mil.getText().toString();
        String formatado = saldoSemFormataçao.replace(".", "");
        formatado = formatado.replace(",", "");
        //formatado +=str;

        saldo = Integer.valueOf(formatado);

    }
    public void passarValores (String recebe, Integer passaMilhar){
        Intent passandoValoresParaSaldo = new Intent(this, SaldoActivity.class);
        passandoValoresParaSaldo.putExtra(recebe, passaMilhar);
        startActivity(passandoValoresParaSaldo);
    }

}

