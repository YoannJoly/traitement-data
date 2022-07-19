package fr.yoann;

import fr.yoann.bll.BLLException;
import fr.yoann.bll.ObjectManager;
import fr.yoann.domain.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static fr.yoann.ParsingJson.*;

public class JsonToDatabase {
    public static void main(String[] args) throws JSONException, IOException, BLLException {
//        addActeurToDatabase();
//        addNaissanceToDatabase();
//        addRoleToDatabase();
//        addFilmToDatabase();
//        addGenreToDatabase();
//        addPaysToDatabase();
    }

    public static void addActeurToDatabase() throws JSONException, IOException, BLLException {
        for (int j = 0; j < getActeurFromJson().length(); j++) {
            JSONObject jsonObject = getActeurFromJson().getJSONObject(j);
            Acteur acteur = new Acteur(jsonObject.getString("identite"), jsonObject.getString("url"), jsonObject.getString("id"));
            ObjectManager.getInstance().addObject(acteur);
        }

        List<Acteur> acteurs = new ArrayList<>();
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            for (int i = 0; i < getFilmFromJson().getJSONArray(j).length(); i++) {
                JSONObject jsonObject = getFilmFromJson().getJSONArray(j).getJSONObject(i).getJSONObject("film");
                for (int v = 0; v < jsonObject.getJSONArray("acteurs").length(); v++) {
                    Acteur acteur = new Acteur(jsonObject.getJSONArray("acteurs").getJSONObject(v).getString("identite"), jsonObject.getJSONArray("acteurs").getJSONObject(v).getString("url"), jsonObject.getJSONArray("acteurs").getJSONObject(v).getString("id"));
                    acteurs.add(acteur);
                    System.out.println("Nombre d'acteurs dans la liste : " + acteurs.size());
                }
            }
        }
        for (Acteur acteur : acteurs) {
            ObjectManager.getInstance().addObject(acteur);
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
        List<Film> films = new ArrayList<>();
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            for (int i = 0; i < getFilmFromJson().getJSONArray(j).length(); i++) {
                JSONObject jsonObject = getFilmFromJson().getJSONArray(j).getJSONObject(i).getJSONObject("film");
                int anneeSortie;
                if (jsonObject.getString("anneeSortie").equals("")) {
                    anneeSortie = 0;
                } else {
                    String digits = jsonObject.getString("anneeSortie").replaceAll("[^0-9]", "");
                    anneeSortie = Integer.parseInt(digits);
                }
                Film film = new Film(jsonObject.getString("nom"), jsonObject.getString("url"), jsonObject.getString("plot"), jsonObject.getString("id"), jsonObject.getString("langue"), anneeSortie);
                films.add(film);
                System.out.println("Nombre de films dans la liste : " + films.size());
            }
        }
        for (Film film : films) {
            ObjectManager.getInstance().addObject(film);
        }
    }

    public static void addGenreToDatabase() throws JSONException, IOException, BLLException {
        List<String> genres = getGenreFromJson();
        List<Genre> listGenres = new ArrayList<>();
        for (String genre : genres) {
            Genre genre1 = new Genre(genre);
            listGenres.add(genre1);
        }
        for (Genre genre : listGenres) {
            ObjectManager.getInstance().addObject(genre);
        }
    }

    public static void addPaysToDatabase() throws JSONException, IOException, BLLException {
        List<JSONObject> pays = getPaysFromJson();
        List<Pays> listPays = new ArrayList<>();
        for (JSONObject jsonObject : pays) {
            Pays pays1 = new Pays(jsonObject.getString("nom"), jsonObject.getString("url"));
            listPays.add(pays1);
        }
        for (Pays paysFromList : listPays) {
            ObjectManager.getInstance().addObject(paysFromList);
        }
    }
}
