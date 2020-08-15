package com.nain.spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1, spinner2;
    String select1, select2;
    Button button, button01, button02;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.button);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);

        // Llenado de Spinner -> 01
        String[] strings = {"Pagina Web", "Celular", "Captura Foto", "Grabar Video"};

        spinner1.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, strings));

        // Llenado de Spinner -> 02
        ArrayAdapter<CharSequence> adapater = ArrayAdapter.createFromResource(this, R.array.spinner2,
                android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapater);

        // Evento Click spinner1
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Select: " + select1, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento Click spinner2
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Select: " + select2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatosActivity.class);
                intent.putExtra("valor01", select1);
                startActivity(intent);
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner01();
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSpinner2();
            }
        });
    }

    private void spinner01() {
        switch (select1) {
            case "Pagina Web":
                uri = Uri.parse("https://developer.android.com/reference/android/net/Uri");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case "Celular":
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:931375941"));
                startActivity(intent1);
                break;
            case "Captura Foto":
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent2);
                break;
            case "Grabar Video":
                Intent intent3 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }

    private void setSpinner2() {
        switch (select2) {
            case "Unicación de Negocio":
                uri = Uri.parse("geo:-18.056441891181393,-70.25109359989592");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case "Calle de Negocio":
                uri = Uri.parse("google.streetview:cbll=-18.056441891181393,-70.25109359989592");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                intent2.setPackage("com.google.android.apps.maps");
                startActivity(intent2);
                break;

            case "Enviar Correo":
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Title: Titulo");
                intent1.putExtra(Intent.EXTRA_TEXT, "Virus Informático no abrir!");
                intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"nain.acero24@gmail.com"});
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}