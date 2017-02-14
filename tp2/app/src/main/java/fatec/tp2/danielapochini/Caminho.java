package fatec.tp2.danielapochini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Caminho extends Activity implements View.OnClickListener {
    Button btnVoltar;
    Button btnAcessar;
    EditText InputOrigem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caminho);
        InputOrigem = (EditText)findViewById(R.id.InputOrigem);
        btnAcessar = (Button)findViewById(R.id.btnAcessar);
        btnAcessar.setOnClickListener(this);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnAcessar:
                Uri mapUri = Uri.parse("google.navigation:q="+Uri.encode(InputOrigem.getText().toString()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            case R.id.btnVoltar:
                finish();
            default:
                break;
        }
    }
}
