package br.com.deltavivo.olamundo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by delta on 23/07/2016.
 */
public class OlaMundoActivity extends Activity{
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_ola_mundo);
    }
}
