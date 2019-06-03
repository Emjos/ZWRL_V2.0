package sample.Classes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;


public class ImportIpData {

    public ArrayList Check(String ip) {

        ArrayList<String> tab3= new ArrayList<>();

        final String url = "https://check-host.net/ip-info?host=" + ip;
        try {
            Document document = Jsoup.connect(url).get();

            for (Element row : document.select("table.hostinfo.result tr")) {

                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {

                   // for (int a = 0; a < 12; a++) {
                        tab3.add(row.select("td:nth-of-type(1)").text() + " " + row.select("td:nth-of-type(2)").text());


                  //      a++;
                  //  }

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return tab3;

    }
}


