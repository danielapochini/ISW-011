package fatec.tp2.danielapochini;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends ListActivity {
    private String opcoes[] = {
            "Abrir Navegador", // 0
            "Encontrar Latitude e Longitude - Maps", // 1
            "Enviar Email", // 2
            "Enviar SMS", //3
            "Pesquisar Google", // 4
            "Pesquisar Play Store", // 5
            "Rota de Caminho", //6
            "Sobre", //7
            "Sair", // 8

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // Listar opções na tela (como se fosse uma activity)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opcoes);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                Toast.makeText(this, "Abrir Navegador", Toast.LENGTH_LONG).show();
                Intent it = new Intent(this, Browser.class);
                startActivity(it);
                break;
            case 1:
                Toast.makeText(this, "Mostrar Mapa", Toast.LENGTH_LONG).show();
                it = new Intent(this, Mapa.class);
                startActivity(it);
                break;
            case 2:
                Toast.makeText(this, "Enviar Email", Toast.LENGTH_LONG).show();
                it = new Intent(this, Email.class);
                startActivity(it);
                break;
            case 3:
                Toast.makeText(this, "Enviar SMS", Toast.LENGTH_LONG).show();
                it = new Intent(this, SMS.class);
                startActivity(it);
                break;
            case 4:
                Toast.makeText(this, "Pesquisar Google", Toast.LENGTH_LONG).show();
                it = new Intent(this, Google.class);
                startActivity(it);
                break;

            case 5:
                Toast.makeText(this, "Pesquisar Play Store", Toast.LENGTH_LONG).show();
                it = new Intent(this, Store.class);
                startActivity(it);
                break;
            case 6:
                Toast.makeText(this, "Rota de Caminho", Toast.LENGTH_LONG).show();
                it = new Intent(this, Caminho.class);
                startActivity(it);
                break;
            case 7:
                Toast.makeText(this, "Sobre o App", Toast.LENGTH_LONG).show();
                it = new Intent(this, Sobre.class);
                startActivity(it);
                break;
            case 8:
                Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show();
                finish();
                System.exit(0);
                break;
        }
    }
}