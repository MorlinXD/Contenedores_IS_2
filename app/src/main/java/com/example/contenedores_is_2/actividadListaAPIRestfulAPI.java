package com.example.contenedores_is_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.contenedores_is_2.adaptadores.AdaptadorUsuario;
import com.example.contenedores_is_2.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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
        lstOpciones = (ListView)findViewById(R.id.lstListaapi);
        View header = getLayoutInflater().inflate(R.layout.ly_itemusuario, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, actividadListaAPIRestfulAPI.this, actividadListaAPIRestfulAPI.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        ArrayList<Usuario> lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this, lstUsuarios);
        lstOpciones.setAdapter(adapatorUsuario);
    }
}