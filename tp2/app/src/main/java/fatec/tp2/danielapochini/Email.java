package fatec.tp2.danielapochini;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
    Button btnVoltar;
    Button btnEnviar;
    EditText InputTo;
    EditText InputSubject;
    EditText InputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        InputTo = (EditText)findViewById(R.id.InputTo);
        InputSubject = (EditText)findViewById(R.id.InputSubject);
        InputMessage = (EditText)findViewById(R.id.InputMessage);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnEnviar:
                String InputTox = InputTo.getText().toString();
                String InputSubjectx = InputSubject.getText().toString();
                String InputMessagex = InputMessage.getText().toString();


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { InputTox });
                intent.putExtra(Intent.EXTRA_SUBJECT, InputSubjectx);
                intent.putExtra(Intent.EXTRA_TEXT, InputMessagex);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.btnVoltar:
                finish();
            default:
                break;
        }
    }
}
