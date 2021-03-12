package com.example.examenguerrero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenguerrero.Adapters.AdapterArticulos;
import com.example.examenguerrero.Adapters.AdapterVolumen;
import com.example.examenguerrero.Models.articulos;
import com.example.examenguerrero.Models.volumenes;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ArticulosVolumen extends AppCompatActivity {
    private RequestQueue request;
    private StringRequest stringr;
    private ListView articuloss;
    String idante;
    ArrayList<com.example.examenguerrero.Models.articulos> articulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos_volumen);

        idante = (String) getIntent().getExtras().get("idvol");
        Toast.makeText(ArticulosVolumen.this, "valor: "+ idante, Toast.LENGTH_SHORT).show();


        articuloss = (ListView)findViewById(R.id.lstvArticulos);
        View header= getLayoutInflater().inflate(R.layout.ly_header_articulos,null);
        articuloss.addHeaderView(header);
        enviar();
    }

    public void enviar(){
        request = Volley.newRequestQueue(ArticulosVolumen.this);
        String URL = "https://revistas.uteq.edu.ec/ws/pubs.php?i_id="+idante;

        stringr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                articulos = new ArrayList<com.example.examenguerrero.Models.articulos>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    articulos = com.example.examenguerrero.Models.articulos.JsonObjecBuild(jsonArray);

                    AdapterArticulos adapterArticulos = new AdapterArticulos(ArticulosVolumen.this,articulos);
                    articuloss.setAdapter(adapterArticulos);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ArticulosVolumen.this, "Error: "+ error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Este es: ", error.getMessage());
            }
        });
        request.add(stringr);
    }
}