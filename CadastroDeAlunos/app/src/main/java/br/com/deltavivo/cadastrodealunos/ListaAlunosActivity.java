package br.com.deltavivo.cadastrodealunos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {
    private ListView listaAlunos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {"Anderson","Felipe","Guilherme"};
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);

        int layout= android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, alunos);
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,layout,alunos);
        listaAlunos.setAdapter(adapter);
    }
}
