package sample.Controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;


public class ImportIpData {

    public ArrayList Check(String ip) {
        ArrayList<String> tab1 = new ArrayList <>();
        ArrayList <String> tab2 = new ArrayList <>();
        ArrayList<String> tab3= new ArrayList<>();

        final String url = "https://check-host.net/ip-info?host=" + ip;
        try {
            Document document = Jsoup.connect(url).get();

            for (Element row : document.select("table.hostinfo.result tr")) {

                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    tab1.add(row.select("td:nth-of-type(1)").text());
                    tab2.add(row.select("td:nth-of-type(2)").text());


                }

            }

            for (int a = 0; a < 12; a++) {
                tab3.add(tab1.get(a) + " " + tab2.get(a));


                a++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return tab3;

    }
}


