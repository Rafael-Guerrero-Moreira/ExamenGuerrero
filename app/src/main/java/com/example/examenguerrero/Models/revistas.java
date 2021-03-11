package com.example.examenguerrero.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class revistas {
    private String name;
    private String description;
    private String urlRevista;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlRevista() {
        return urlRevista;
    }

    public void setUrlRevista(String urlRevista) {
        this.urlRevista = urlRevista;
    }

    public revistas(JSONObject a) throws JSONException{
        name = a.getString("name").toString();
        description = a.getString("description").toString();
        urlRevista = a.getString("portada").toString();
    }

    public static ArrayList<revistas> JsonObjecBuild(JSONArray datos) throws JSONException{
        ArrayList<revistas> revistas = new ArrayList<>();

        for (int i = 0; i <datos.length();i++){
            revistas.add(new revistas(datos.getJSONObject(i)));
        }
        return revistas;
    }
}
