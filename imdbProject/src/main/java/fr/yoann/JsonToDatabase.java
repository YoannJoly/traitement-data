package fr.yoann;

import fr.yoann.bll.BLLException;
import fr.yoann.bll.ObjectManager;
import fr.yoann.domain.Acteur;
import fr.yoann.domain.Film;
import fr.yoann.domain.Naissance;
import fr.yoann.domain.Role;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static fr.yoann.ParsingJson.*;

public class JsonToDatabase {
    public static void main(String[] args) throws JSONException, IOException, BLLException {
        //addActeurToDatabase();
        //addNaissanceToDatabase();
        //addRoleToDatabase();
        addFilmToDatabase();
    }

    public static void addActeurToDatabase() throws JSONException, IOException, BLLException {
        for (int j = 0; j < getActeurFromJson().length(); j++) {
            JSONObject jsonObject = getActeurFromJson().getJSONObject(j);
            Acteur acteur = new Acteur(jsonObject.getString("identite"), jsonObject.getString("url"), jsonObject.getString("id"));
            ObjectManager.getInstance().addObject(acteur);
        }
        for (int j = 0; j < getRoleFromJson().length(); j++) {
            JSONObject jsonObject = getFilmFromJson().getJSONArray(j).getJSONObject(j).getJSONObject("film");
            for (int i = 0; i < jsonObject.getJSONArray("castingPrincipal").length(); i++) {
                Acteur acteur = new Acteur(jsonObject.getJSONArray("castingPrincipal").getJSONObject(i).getString("identite"), jsonObject.getJSONArray("castingPrincipal").getJSONObject(i).getString("url"), jsonObject.getJSONArray("castingPrincipal").getJSONObject(i).getString("id"));
                ObjectManager.getInstance().addObject(acteur);
            }
        }
    }

    public static void addNaissanceToDatabase() throws JSONException, IOException, BLLException {
        for (int j = 0; j < getNaissanceFromJson().length(); j++) {
            JSONObject jsonObject = getNaissanceFromJson().getJSONObject(j);
            String naissance = jsonObject.getString("naissance");
            JSONObject jsonObject2 = new JSONObject(naissance);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            String date = jsonObject2.getString("dateNaissance");
            LocalDate dateNaissance;
            dateNaissance = LocalDate.parse(date, formatter);
            Naissance naissance1 = new Naissance(dateNaissance, jsonObject2.getString("lieuNaissance"));
            ObjectManager.getInstance().addObject(naissance1);
        }
    }

    public static void addRoleToDatabase() throws JSONException, IOException, BLLException {
        for (int j = 0; j < getRoleFromJson().length(); j++) {
            Role role = new Role(getRoleFromJson().getJSONArray(j).getJSONObject(j).getString("characterName"));
            ObjectManager.getInstance().addObject(role);
        }
    }

    public static void addFilmToDatabase() throws JSONException, IOException, BLLException {
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            //JSONObject jsonObject = getFilmFromJson().getJSONObject(j);

            for (int i = 0; i < getFilmFromJson().getJSONArray(j).length(); i++) {
                JSONObject jsonObject = getFilmFromJson().getJSONArray(j).getJSONObject(i).getJSONObject("film");
                int anneeSortie;
                if (jsonObject.getString("anneeSortie").equals("")) {
                    anneeSortie = 0;
                }  else {
                    String digits = jsonObject.getString("anneeSortie").replaceAll("[^0-9]", "");
                    anneeSortie = Integer.parseInt(digits);
                }
                Film film = new Film(jsonObject.getString("nom"), jsonObject.getString("url"), jsonObject.getString("plot"), jsonObject.getString("id"), jsonObject.getString("langue"), anneeSortie);
                ObjectManager.getInstance().addObject(film);
            }

        }
    }

}
