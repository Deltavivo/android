package br.com.deltavivo.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import br.com.deltavivo.cadastro.dao.AlunoDAO;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    //private List<Aluno> alunos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        //String[] alunos= {"Anderson", "Matheus", "Rodolfo"};


        /*listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Toast.makeText(ListaAlunosActivity.this,"Posicao selecionada:" + posicao, Toast.LENGTH_LONG).show();
            }
        });

        listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
                String aluno = (String) adapter.getItemAtPosition(posicao);
                Toast.makeText(ListaAlunosActivity.this,"Clique longo: " + aluno, Toast.LENGTH_LONG).show();
                return false;
            }
        });*/

        Button botaoAdiciona = (Button) findViewById(R.id.lista_alunos_floating_button);

        botaoAdiciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ListaAlunosActivity.this,"Botao floating", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        this.carregaLista();
    }

    private void carregaLista(){
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.getLista();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1,alunos);
        listaAlunos.setAdapter(adapter);
        Toast.makeText(ListaAlunosActivity.this, "Lista vazia? " + alunos.isEmpty(), Toast.LENGTH_SHORT).show();
    }
}
