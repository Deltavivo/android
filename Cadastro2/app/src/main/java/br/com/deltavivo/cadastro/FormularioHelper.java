package br.com.deltavivo.cadastro;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.deltavivo.cadastro.dao.AlunoDAO;

/**
 * Created by delta on 29/08/2016.
 */
public class FormularioHelper {
    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private RatingBar nota;
    private FormularioHelper helper;
    private Aluno aluno;
    private AlunoDAO alunodao;

    public FormularioHelper(FormularioActivity activity){
        this.aluno = new Aluno();
        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.site = (EditText) activity.findViewById(R.id.formulario_site);
        nota = (RatingBar) activity.findViewById(R.id.formulario_nota);

    }

    public Aluno pegaAlunoDoFormulario(){
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setNota(Double.valueOf(nota.getProgress()));
        return aluno;
    }

    public boolean temNome(){
        return !nome.getText().toString().isEmpty();
    }

    public void mostrarErro(){
        nome.setError("Campo nome não pode ser vazio.");
    }


}
