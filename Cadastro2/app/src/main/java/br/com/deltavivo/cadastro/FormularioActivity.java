package br.com.deltavivo.cadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

       /* Button botao = (Button) findViewById(R.id.formulario_botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormularioActivity.this, "Voce clicou no botao!", Toast.LENGTH_LONG).show();
                finish();
            }
        });*/

        this.helper = new FormularioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:


                if(helper.temNome()){
                    Aluno aluno = helper.pegaAlunoDoFormulario();
                    Toast.makeText(FormularioActivity.this, "Aluno cadastrado: " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                    finish();
                    return true;

                }else{
                    helper.mostrarErro();
                }

                //Toast.makeText(this, "OK Clicado", Toast.LENGTH_LONG).show();
                //finish();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
/*
    EditText campoNome = (EditText) findViewById(R.id.formulario_nome);
    EditText campoSite = (EditText) findViewById(R.id.formulario_site);

    Aluno aluno = new Aluno();

    String nome = campoNome.getText().toString();
    String site = campoSite.getText().toString();
*/
}
