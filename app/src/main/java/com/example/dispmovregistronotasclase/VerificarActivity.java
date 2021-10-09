package com.example.dispmovregistronotasclase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class VerificarActivity extends Activity {

    private TextView muestra_resultado;
    private Button boton_ver_datos;
    

    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_verificar);

        muestra_resultado = (TextView)findViewById(R.id.txt_visualizar);
        boton_ver_datos = (Button)findViewById(R.id.btn_ver_notas);




    }
}
