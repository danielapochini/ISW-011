package fatec.tp2.danielapochini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Sobre  extends Activity implements View.OnClickListener {
    ImageView btnGithub;
    Button btnVoltar;
    TextView txtViewSobre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        txtViewSobre = (TextView)findViewById(R.id.txtViewSobre);
        txtViewSobre.setOnClickListener(this);
        btnGithub = (ImageView)findViewById(R.id.btnGit);
        btnGithub.setOnClickListener(this);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGit: case R.id.txtViewSobre:
                String url = "https://github.com/danielapochini";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
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