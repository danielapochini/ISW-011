package fatec.tp2.danielapochini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mapa extends Activity implements View.OnClickListener {
    Button btnVoltar;
    Button btnAcessar;
    EditText InputLatitude;
    EditText InputLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        InputLatitude = (EditText)findViewById(R.id.InputLatitude);
        InputLongitude = (EditText)findViewById(R.id.InputLongitude);
        btnAcessar = (Button)findViewById(R.id.btnAcessar);
        btnAcessar.setOnClickListener(this);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnAcessar:
                //geo:0,0?q=latitude,longitude(label)
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+InputLatitude.getText().toString()+","+InputLongitude.getText().toString()+"");
                Intent mapaIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapaIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapaIntent);
                break;
            case R.id.btnVoltar:
                finish();
            default:
                break;
        }
    }
}
