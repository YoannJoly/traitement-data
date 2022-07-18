package fr.yoann;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParsingJson {

    public static void main(String[] args) throws IOException, JSONException {
        //getActeurFromJson();
        //getNaissanceFromJson();
        //System.out.println(getRoleFromJson());
        //getFilmFromJson();
        //getCastingFromJson();
        //getGenreFromJson();
        //getPaysFromJson();
        //getRealisateurFromJson();
    }

    public static @NotNull JSONArray getActeurFromJson() throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray(JsonToString());
        JSONArray finalJsonArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            System.out.println("identite : " + jsonObject.getString("identite"));
//            System.out.println("url : " + jsonObject.getString("url"));
//            System.out.println("id : " + jsonObject.getString("id") + "\n");
            finalJsonArray.put(jsonObject);
        }
        return finalJsonArray;
    }

    public static @NotNull JSONArray getNaissanceFromJson() throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray(JsonToString());
        JSONArray finalJsonArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String naissance = jsonObject.getString("naissance");
            JSONObject jsonObject2 = new JSONObject(naissance);
//            System.out.println("dateNaissance : " + jsonObject2.getString("dateNaissance"));
//            System.out.println("lieuNaissance : " + jsonObject2.getString("lieuNaissance") + "\n");
            finalJsonArray.put(jsonObject);
        }
        return finalJsonArray;
    }

    public static @NotNull JSONArray getRoleFromJson() throws IOException, JSONException {
        JSONArray finalJsonArray = new JSONArray();
        JSONArray jsonArray = new JSONArray(JsonToString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String roles = jsonArray.getJSONObject(i).getString("roles");
            JSONArray jsonArray2 = new JSONArray(roles);
//            for (int j = 0; j < jsonArray2.length(); j++) {
//                JSONObject jsonObject2 = jsonArray2.getJSONObject(j);
//                System.out.println("characterName : " + jsonObject2.getString("characterName"));
//            }
            finalJsonArray.put(jsonArray2);
        }
        return finalJsonArray;
    }

    public static @NotNull JSONArray getFilmFromJson() throws IOException, JSONException {
        JSONArray finalJsonArray = new JSONArray();
        for (int j = 0; j < getRoleFromJson().length(); j++) {
            JSONArray jsonArray = getRoleFromJson().getJSONArray(j);
            finalJsonArray.put(jsonArray);
//            System.out.println("film : " + jsonArray.getJSONObject(0).getString("film") + "\n");
        }
        return finalJsonArray;
    }

    public static void getCastingFromJson() throws IOException, JSONException {
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            JSONArray jsonArray = getFilmFromJson().getJSONArray(j);
            String film = jsonArray.getJSONObject(j).getString("film");
            JSONObject jsonObject = new JSONObject(film);
            System.out.println("nom : " + jsonObject.getString("nom"));
        }
    }

    public static void getGenreFromJson() throws IOException, JSONException {
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            JSONArray jsonArray = getFilmFromJson().getJSONArray(j);
            String film = jsonArray.getJSONObject(j).getString("film");
            JSONObject jsonObject = new JSONObject(film);
            System.out.println("nom : " + jsonObject.getString("genres"));
        }
    }

    public static void getPaysFromJson() throws IOException, JSONException {
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            JSONArray jsonArray = getFilmFromJson().getJSONArray(j);
            String film = jsonArray.getJSONObject(j).getString("film");
            JSONObject jsonObject = new JSONObject(film);
            System.out.println("Pays : " + jsonObject.getString("pays"));
        }
    }

    public static void getRealisateurFromJson() throws IOException, JSONException {
        for (int j = 0; j < getFilmFromJson().length(); j++) {
            JSONArray jsonArray = getFilmFromJson().getJSONArray(j);
            String film = jsonArray.getJSONObject(j).getString("film");
            JSONObject jsonObject = new JSONObject(film);
            System.out.println("Realisateur : " + jsonObject.getString("realisateurs"));
        }
    }

    @Contract(" -> new")
    public static @NotNull String JsonToString() throws IOException {
        String file = "src/main/resources/films.json";
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
