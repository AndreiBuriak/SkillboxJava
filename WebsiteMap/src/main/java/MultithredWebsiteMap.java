import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MultithredWebsiteMap extends RecursiveTask<List<String>> {

    private final String websiteLink;

    public MultithredWebsiteMap(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    protected List<String> compute() {
        List<String> websiteMap = new ArrayList<>();
        websiteMap.add(getWebsiteLink());


        try {
            List<MultithredWebsiteMap> taskList = new ArrayList<>();
            Document document = Jsoup.connect(websiteLink).maxBodySize(0).get();
            Thread.sleep(100);
            Elements urls = document.body().getElementsByTag("a");
            for (Element url : urls) {
                String link = url.absUrl("href");

                if (link.contains("#")) {
                    link = link.split("#")[0];
                }
                if (link.contains("?")) {
                    link = link.split("\\?")[0];
                }

                if (link.startsWith(websiteLink) && Main.setLinks.add(link)) {
                    MultithredWebsiteMap task = new MultithredWebsiteMap(link);
                    task.fork();
                    taskList.add(task);
                }
            }

            for (MultithredWebsiteMap list : taskList) {
                for (String string : list.join()) {
                    websiteMap.add("\t" + string);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return websiteMap;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }
}
