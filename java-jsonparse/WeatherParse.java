import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Compile : javac -cp .:json-simple-1.1.1.jar WeatherParse.java
// Execute : java -cp .:json-simple-1.1.1.jar WeatherParse

public class WeatherParse {

    private static String JSON_WEATHER_PATH = "weather.json";

    public static void main(String[] args) {

        FileReader jsonFile = null;
        try {
    // récupération du fichier en lecture
            jsonFile = new FileReader("/Users/camillebrunet/JavaJSon/java-jsonparse/weather.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        JSONParser parser = new JSONParser();
        Object jsonParsed = null;
        try {
            jsonParsed = parser.parse(jsonFile);
        } catch (ParseException | IOException e) {
        e.printStackTrace();
        }
        // TODO parser le fichier
        JSONObject root = (JSONObject) jsonParsed;

        String name = (String) root.get("name");
        // TODO récupérer la racine du document

        System.out.println("City name : " + name);

        JSONObject coord = (JSONObject) root.get("coord");

        Double lat = (Double) coord.get("lat");
        Double lon = (Double) coord.get("lon");
        
        System.out.println("City latitude : " + lat);
        System.out.println("City longitude : " + lon);

        JSONArray weather = (JSONArray) root.get("weather");
        // TODO afficher la valeur de l'attribut "name" de la racine
        // TODO afficher les valeurs des attributs "lat" et "lon" de l'élément "coord" contenu dans la racine
        // TODO parcourir tous les éléments de "weather" et afficher le contenu de "main"
        for (int i = 0; i < weather.size(); i++) {
            JSONObject weath = (JSONObject) weather.get(i);
            String main = (String) weath.get("main");
            System.out.println("Weather : " + main);
        }
        
        /*
            Résultat attendu :
            * City name: London
            * City latitude: 51.51
            * City longitude: -0.13
            * Weather: Drizzle
            * Weather: Clear
        */
    }
}
