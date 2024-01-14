package com.example.contenedores_is_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import webservices.Asynchtask;
import webservices.WebService;

public class actividadListaAPIRestfulAPI extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_lista_apirestful_api);
        lstOpciones = (ListView)findViewById(R.id.lstLista);
        View header = getLayoutInflater().inflate(R.layout.ly_itemusuario, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, actividadListaAPIRestfulAPI.this, actividadListaAPIRestfulAPI.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}