package com.example.dispmovregistronotasclase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AyudaActivity extends Activity {

    private Button boton_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        boton_regresar = (Button) findViewById(R.id.btn_regresar);

        boton_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarMain(null);
            }
        });
    }

    public void lanzarMain(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
