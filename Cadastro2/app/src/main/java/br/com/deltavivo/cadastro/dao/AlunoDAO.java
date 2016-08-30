package br.com.deltavivo.cadastro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.deltavivo.cadastro.Aluno;

/**
 * Created by delta on 30/08/2016.
 */
public class AlunoDAO extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String TABELA = "Alunos";
    private static final String DATABASE = "Cadastro";

    public AlunoDAO(Context context){
        super(context,DATABASE,null,VERSAO);
    }

    public void onCreate(SQLiteDatabase database){
        String ddl = "CREATE TABLE " + TABELA
                    + " (id INTEGER PRIMARY KEY, "
                    + " nome TEXT NOT NULL, "
                    + " telefone TEXT, "
                    + " endereco TEXT, "
                    + " site TEXT, "
                    + " nota REAL);";
        database.execSQL(ddl);
    }

    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova){
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        database.execSQL(sql);
        onCreate(database);
    }

    public void insere(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome",aluno.getNome());
        values.put("telefone",aluno.getTelefone());
        values.put("endereco",aluno.getEndereco());
        values.put("site",aluno.getSite());
        values.put("nota",aluno.getNota());

        getWritableDatabase().insert(TABELA,null, values);
    }

    public List<Aluno> getLista(){

        List<Aluno> alunos = new ArrayList<Aluno>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABELA + ";", null);
        //cursor.moveToFirst();



        while(cursor.moveToNext()){

            Aluno aluno = new Aluno();
            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("Telefone")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("Endereco")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("Site")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("Nota")));
            alunos.add(aluno);
        }
        cursor.close();
        return alunos;
    }
}
