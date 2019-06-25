package sample.Classes;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ForFunctionTwo {
    String toxic = null;
    String proxy = null;
    String spam = null;
    public String getToxic() {
        return toxic;
    }

    public void setToxic(String toxic) {
        this.toxic = toxic;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getSpam() {
        return spam;
    }

    public void setSpam(String spam) {
        this.spam = spam;
    }



    public void check(String ip) throws IOException {


        final URL url = new URL("http://api.antideo.com/ip/health/"+ip);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String lines;
        int a =0;

        int check = 0;
        while ((lines = reader.readLine()) != null) {
            if (a > 2) {
                if (a ==3){
                    check = lines.indexOf(":")+1;
                    setToxic(lines.substring(check,lines.length()-1));
                }
                if (a ==4){
                    check = lines.indexOf(":")+1;
                    setProxy(lines.substring(check,lines.length()-1));
                }
                if (a ==3){
                    check = lines.indexOf(":")+1;
                    setSpam(lines.substring(check,lines.length()-1));
                }
                System.out.println(lines);
            }
        a++;
        }
        System.out.println("Toxic :"+ toxic);
        System.out.println("procy :" + proxy);
        System.out.println("spam :" +spam);
        reader.close();

    }
}
