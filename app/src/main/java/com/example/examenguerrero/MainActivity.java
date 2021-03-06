package com.example.examenguerrero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.examenguerrero.Adapters.AdapterRevistas;
import com.example.examenguerrero.Models.revistas;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue request;
    private StringRequest stringr;
    private ListView revistass;
    ArrayList<com.example.examenguerrero.Models.revistas> revistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        revistass = (ListView)findViewById(R.id.lstvRevistas);

        View header= getLayoutInflater().inflate(R.layout.ly_header_revistas,null);

        revistass.addHeaderView(header);
        enviar();

        revistass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,VolumenesPublicados.class).putExtra("id", revistas.get(position-1).getId()));
                Toast.makeText(MainActivity.this, "ID: "+ revistas.get(position-1).getId(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void enviar(){
        request = Volley.newRequestQueue(MainActivity.this);
        String URL = "https://revistas.uteq.edu.ec/ws/journals.php";

        stringr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                revistas = new ArrayList<com.example.examenguerrero.Models.revistas>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    revistas = com.example.examenguerrero.Models.revistas.JsonObjecBuild(jsonArray);

                    AdapterRevistas adapterRevistas = new AdapterRevistas(MainActivity.this,revistas);
                    revistass.setAdapter(adapterRevistas);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error: "+ error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Este es: ", error.getMessage());
            }
        });
        request.add(stringr);
    }


}