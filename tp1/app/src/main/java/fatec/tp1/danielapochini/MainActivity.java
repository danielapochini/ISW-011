package fatec.tp1.danielapochini;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    boolean decimal = false;
    boolean soma = false;
    boolean menos = false;
    boolean mult = false;
    boolean div = false;
    boolean exp = false;
    Double[] numero = new Double[20];
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n0 = (Button)findViewById(R.id.Btn0);
        n0.setOnClickListener(this);
        Button n1 = (Button)findViewById(R.id.Btn1);
        n1.setOnClickListener(this);
        Button n2 = (Button)findViewById(R.id.Btn2);
        n2.setOnClickListener(this);
        Button n3 = (Button)findViewById(R.id.Btn3);
        n3.setOnClickListener(this);
        Button n4 = (Button)findViewById(R.id.Btn4);
        n4.setOnClickListener(this);
        Button n5 = (Button)findViewById(R.id.Btn5);
        n5.setOnClickListener(this);
        Button n6 = (Button)findViewById(R.id.Btn6);
        n6.setOnClickListener(this);
        Button n7 = (Button)findViewById(R.id.Btn7);
        n7.setOnClickListener(this);
        Button n8 = (Button)findViewById(R.id.Btn8);
        n8.setOnClickListener(this);
        Button n9 = (Button)findViewById(R.id.Btn9);
        n9.setOnClickListener(this);

        Button ponto = (Button)findViewById(R.id.BtnPonto);
        ponto.setOnClickListener(this);

        Button soma = (Button)findViewById(R.id.BtnSoma);
        soma.setOnClickListener(this);
        Button menos = (Button)findViewById(R.id.BtnMenos);
        menos.setOnClickListener(this);
        Button mult = (Button)findViewById(R.id.BtnMult);
        mult.setOnClickListener(this);
        Button div = (Button)findViewById(R.id.BtnDiv);
        div.setOnClickListener(this);
        Button igual = (Button)findViewById(R.id.BtnIgual);
        igual.setOnClickListener(this);

        Button raiz = (Button)findViewById(R.id.BtnRaiz);
        raiz.setOnClickListener(this);
        Button exp = (Button)findViewById(R.id.BtnExp);
        exp.setOnClickListener(this);

        Button del = (Button)findViewById(R.id.BtnDEL);
        del.setOnClickListener(this);
        Button limpar = (Button)findViewById(R.id.BtnLimpar);
        limpar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            TextView tela = (TextView)findViewById(R.id.texto);
            int selecao = v.getId();
            String a = tela.getText().toString();
            String b = tela.getText().toString();
            try {
                switch (selecao) {
                        case R.id.Btn0:
                            tela.setText(a+"0");
                            break;
                        case R.id.Btn1:
                            tela.setText(a+"1");
                            break;
                        case R.id.Btn2:
                            tela.setText(a+"2");
                            break;
                        case R.id.Btn3:
                            tela.setText(a+"3");
                            break;
                        case R.id.Btn4:
                            tela.setText(a+"4");
                            break;
                        case R.id.Btn5:
                            tela.setText(a+"5");
                            break;
                        case R.id.Btn6:
                            tela.setText(a+"6");
                            break;
                        case R.id.Btn7:
                            tela.setText(a+"7");
                            break;
                        case R.id.Btn8:
                            tela.setText(a+"8");
                            break;
                        case R.id.Btn9:
                            tela.setText(a+"9");
                            break;
                        case R.id.BtnPonto:
                            if (!decimal){
                                tela.setText(a+".");
                                decimal = true;
                            }else{
                                return;
                            }
                            break;
                        case R.id.BtnSoma:
                            soma = true;
                            numero[0] = Double.parseDouble(a);
                            tela.setText("");
                            decimal = false;
                            break;
                        case R.id.BtnMenos:
                            menos = true;
                            numero[0] = Double.parseDouble(a);
                            tela.setText("");
                            decimal = false;
                            break;
                        case R.id.BtnMult:
                            mult = true;
                            numero[0] = Double.parseDouble(a);
                            tela.setText("");
                            decimal = false;
                            break;
                        case R.id.BtnDiv:
                            div = true;
                            numero[0] = Double.parseDouble(a);
                            tela.setText("");
                            decimal = false;
                            break;

                        case R.id.BtnRaiz:
                            numero[0] = Double.parseDouble(a);
                            resultado = Math.sqrt(numero[0]);
                            tela.setText(String.valueOf(resultado));
                            decimal = false;
                            break;

                        case R.id.BtnExp:
                            exp = true;
                            numero[0] = Double.parseDouble(a);
                            tela.setText("");
                            decimal = false;
                            break;

                        case R.id.BtnIgual:
                            numero[1] = Double.parseDouble(b);

                            if(soma){
                                resultado = numero[0] + numero[1];
                                tela.setText(String.valueOf(resultado));
                            }else if(menos){
                                resultado = numero[0] - numero[1];
                                tela.setText(String.valueOf(resultado));
                            }else if(mult){
                                resultado = numero[0] * numero[1];
                                tela.setText(String.valueOf(resultado));
                            }else if(div){
                                resultado = numero[0] / numero[1];
                                tela.setText(String.valueOf(resultado));
                            }else if (exp){
                                resultado =  Math.pow(numero[0], numero[1]);
                                tela.setText(String.valueOf(resultado.intValue()));
                            }
                            decimal = false;
                            soma = false;
                            menos = false;
                            mult = false;
                            div = false;
                            exp = false;
                            break;
                        case R.id.BtnLimpar:
                            tela.setText("");
                            break;
                        case R.id.BtnDEL:
                            String valor = tela.getText().toString();
                            StringBuilder w = new StringBuilder(valor);
                            valor = String.valueOf( w.deleteCharAt(valor.length() - 1) );
                            tela.setText(valor);
                            break;
                    }
                    }catch (Exception e) {
                    tela.setText(R.string.error);
                }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override


    public boolean  onMenuItemSelected (int panel, MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(this, "Feito por Daniela Pochini", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}