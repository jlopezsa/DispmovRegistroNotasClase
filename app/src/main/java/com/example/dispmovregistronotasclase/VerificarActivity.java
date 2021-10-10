package com.example.dispmovregistronotasclase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerificarActivity extends Activity {

    private TextView muestra_resultado;
    private Button boton_ver_datos;

    private Materia materia_reg = null;
    

    @Override public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_verificar);

        muestra_resultado = (TextView)findViewById(R.id.txt_visualizar);
        boton_ver_datos = (Button)findViewById(R.id.btn_ver_notas);

        // Recibiendo el objeto desde otra actividad
        Bundle objeto_rx = getIntent().getExtras();
        if(objeto_rx!=null){
            materia_reg = (Materia) objeto_rx.getSerializable("MATERIA");
            //Log.i("VERIF_Materia",materia_reg.getNombre_materia());
            //Log.i("VERIF_Estudiante",materia_reg.getEstudiantes(0).getNombre());
        }

        boton_ver_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(materia_reg == null){
                    muestra_resultado.setText("No existe registro de notas. Ingrese primero las notas");
                }else{
                    for (int i = 0; i < materia_reg.getTotal_estudiantes(); i++) {
                        muestra_resultado.append(materia_reg.getEstudiantes(i).getNombre() + materia_reg.getEstudiantes(i).getTotal_corte()+"\n");
                    }
                }
            }
        });
    }
}
