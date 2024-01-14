package com.example.contenedores_is_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{

    TextView txtItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Datos
        final String[] datos = new String[]{"JOSE ANDRES ALVAREZ MORA","JEAN PIERRE MORALES VERA","RAFAEL ALEXANDER NAVAS RIVERA","LUIS AARON REYES PALACIOS","KERLY MIKAELA TRIANA ARRIETA", "JOSSELYN JELITZA VERA ZAMBRANO"};
        //Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        //Vista
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbOpciones);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        txtItemSelected = findViewById(R.id.txtItemSeleccionado);
        cmbOpciones.setOnItemSelectedListener(this);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        ListView lstOpciones = (ListView)findViewById(R.id.lstListaapi);
        lstOpciones.setAdapter(adaptador2);

        lstOpciones.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        txtItemSelected.setText("Item Seleccionado: " + parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        txtItemSelected.setText("");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.getApplicationContext(),
                parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_LONG).show();



    }
}