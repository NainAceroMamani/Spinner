package com.nain.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        textView1 = findViewById(R.id.valor1);
        textView2 = findViewById(R.id.valor2);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null){
            String datos = parametros.getString("valor01");
            textView1.setText(datos);
        }
    }
}
