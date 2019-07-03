import java.io.IOException;
import java.util.Scanner;


class Jar {

    public static String XmlFunc(String args) {
        String[] cmd = { "cmd", "/c",  "cd c:\\DaJaVa && apktool d -f", FileName};
        Process process = null;
        try {
            process = new ProcessBuilder(cmd).start();

            Scanner s = new Scanner(process.getInputStream(), "EUC-KR");
            while (s.hasNextLine() == true) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "c:\\DaJaVa\\"+args+"\\AndroidManifest.xml"; //xml경로를 String으로 return
    }

}
public abstract class Main{
    public static String FileName = "InsecureBankv2.apk";
    public static void main(String[] args){
        String XmlPath;
        XmlPath = Jar.XmlFunc(FileName);
        System.out.println(XmlPath);
    }
}
