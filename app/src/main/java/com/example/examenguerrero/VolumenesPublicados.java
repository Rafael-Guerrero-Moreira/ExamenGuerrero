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
import com.example.examenguerrero.Adapters.AdapterRevistas;
import com.example.examenguerrero.Adapters.AdapterVolumen;
import com.example.examenguerrero.Models.revistas;
import com.example.examenguerrero.Models.volumenes;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class VolumenesPublicados extends AppCompatActivity {
    private RequestQueue request;
    private StringRequest stringr;
    private ListView volumeness;
    String idant;
    ArrayList<volumenes> volumenes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes_publicados);

        volumeness = (ListView)findViewById(R.id.lstvVolumenes);
        View header= getLayoutInflater().inflate(R.layout.ly_header_volumenes,null);

        volumeness.addHeaderView(header);
        Bundle para = new Bundle();
        idant = para.getString("id");
        enviar(idant);


    }

    public void enviar(String idrevista){
        request = Volley.newRequestQueue(VolumenesPublicados.this);
        String URL = "https://revistas.uteq.edu.ec/ws/issues.php?j_id="+idrevista;

        stringr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volumenes = new ArrayList<volumenes>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    volumenes = com.example.examenguerrero.Models.volumenes.JsonObjecBuild(jsonArray);

                    AdapterVolumen adapterVolumen = new AdapterVolumen(VolumenesPublicados.this,volumenes);
                    volumeness.setAdapter(adapterVolumen);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolumenesPublicados.this, "Error: "+ error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Este es: ", error.getMessage());
            }
        });
        request.add(stringr);
    }
}