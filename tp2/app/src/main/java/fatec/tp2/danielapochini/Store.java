package fatec.tp2.danielapochini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Store extends Activity implements View.OnClickListener {
    Button btnVoltar;
    Button btnPesquisar;
    EditText inputPesquisarApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        inputPesquisarApp = (EditText)findViewById(R.id.inputPesquisarApp);
        btnPesquisar = (Button)findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(this);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPesquisar:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://play.google.com/store/search?q="+inputPesquisarApp.getText().toString()+"&hl=pt-Br"));
                startActivity(intent);
                break;
            case R.id.btnVoltar:
                finish();
            default:
                break;
        }
    }
}