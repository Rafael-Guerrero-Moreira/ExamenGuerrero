package com.example.examenguerrero.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class articulos {
    private String tituloart;
    private String section;
    private String urlDoc;

    public String getTituloart() {
        return tituloart;
    }

    public void setTituloart(String tituloart) {
        this.tituloart = tituloart;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrlDoc() {
        return urlDoc;
    }

    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }

    public articulos(JSONObject a) throws JSONException {
        tituloart = a.getString("title").toString();
        section = a.getString("section").toString();
        urlDoc = a.getString("UrlViewGalley").toString();
    }

    public static ArrayList<articulos> JsonObjecBuild(JSONArray datos) throws JSONException{
        ArrayList<articulos> articulos = new ArrayList<>();

        for (int i = 0; i <datos.length();i++){
            articulos.add(new articulos(datos.getJSONObject(i)));
        }
        return articulos;
    }
}
