package com.example.examenguerrero.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class volumenes {
    private String titulo;
    private String fecha;
    private String urlvolumen;
    private String idvol;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrlvolumen() {
        return urlvolumen;
    }

    public void setUrlvolumen(String urlvolumen) {
        this.urlvolumen = urlvolumen;
    }


    public String getIdvol() {
        return idvol;
    }

    public void setIdvol(String idvol) {
        this.idvol = idvol;
    }

    public volumenes(JSONObject a) throws JSONException {
        idvol = a.getString("issue_id").toString();
        titulo = a.getString("title").toString();
        fecha = a.getString("date_published").toString();
        urlvolumen = a.getString("cover").toString();
    }

    public static ArrayList<volumenes> JsonObjecBuild(JSONArray datos) throws JSONException{
        ArrayList<volumenes> volumenes = new ArrayList<>();

        for (int i = 0; i <datos.length();i++){
            volumenes.add(new volumenes(datos.getJSONObject(i)));
        }
        return volumenes;
    }
}
