import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {

    static Set<String> setLinks = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {

        final String websiteLink = "https://skillbox.ru/";

        try (PrintWriter linksToFile = new PrintWriter("src/main/resources/file.txt")) {
            setLinks.add(websiteLink);
            List<String> listLinks = new ForkJoinPool().invoke(new MultithredWebsiteMap(websiteLink));

            for (String link : listLinks) {
                linksToFile.write(link + "\n");
            }
            linksToFile.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
