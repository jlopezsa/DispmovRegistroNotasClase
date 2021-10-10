package com.example.dispmovregistronotasclase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarActivity extends Activity {

    private Materia materia_reg;
    private Estudiante estudiante_reg;
    private Corte corte_notas;

    private Button boton_regresar, boton_reg_alumno,boton_reg_notas;
    private EditText ingresa_disciplina, ingresa_estudiante;
    private EditText in_autoevaluacion, in_trabajos, in_parcial;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_registrar);

        materia_reg = new Materia();



        // Asociar objetos de la vista con el código
        ingresa_disciplina = (EditText) findViewById(R.id.txt_disciplina);
        ingresa_estudiante = (EditText)findViewById(R.id.txt_alumno);
        in_autoevaluacion = (EditText)findViewById(R.id.txt_autoevaluacion);
        in_trabajos = (EditText)findViewById(R.id.txt_trabajos);
        in_parcial = (EditText)findViewById(R.id.txt_parcial);

        boton_regresar = (Button)findViewById(R.id.btn_regresar);
        boton_reg_alumno = (Button)findViewById(R.id.btn_ingresa_alumno);
        boton_reg_notas = (Button)findViewById(R.id.btn_notas);
        //------------------------------------------


        // Creando los Listener de los botones
        boton_reg_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia_reg.setNombre_materia(ingresa_disciplina.getText().toString());
                estudiante_reg = new Estudiante();
                estudiante_reg.setNombre(ingresa_estudiante.getText().toString());
            }
        });

        boton_reg_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corte_notas = new Corte();

                try {
                    corte_notas.setAutoevaluacion(Float.valueOf(in_autoevaluacion.getText().toString()));
                    corte_notas.setTrabajos(Float.valueOf(in_trabajos.getText().toString()));
                    corte_notas.setParcial(Float.valueOf(in_parcial.getText().toString()));
                }catch(Exception error_identificado){
                    Log.i("TRY-CATCH","Las notas no son numeros reales");
                    AlertDialog.Builder alerta = new AlertDialog.Builder(RegistrarActivity.this);
                    alerta.setMessage("Ingrese numero real en notas");
                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("Cuidado!");
                    titulo.show();
                }
                // Asociaciones entre objetos
                estudiante_reg.setNotas_corte(corte_notas);
                estudiante_reg.calculatotal_corte();
                materia_reg.setEstudiantes(estudiante_reg);
            }
        });

        boton_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarHome(null);
            }
        });

    }



    public void lanzarHome(View view){
        Intent i = new Intent(this,MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("MATERIA", materia_reg);
            i.putExtras(bundle);
        startActivity(i);
    }

}
