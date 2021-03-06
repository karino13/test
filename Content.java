import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Content{
    public static int find(){
        //xml파일에서 provider 검색 함수
        String filename = "AndroidManifest.xml";
        String word = "(?i).*provider.*";
        int num=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String s;

            int line =1;

            while ((s = reader.readLine()) != null) {
                if (s.matches(word)){
                    System.out.println(line + " : " + s);
                    num++;
                }
                line++; }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        if(num>0)
            return 1; //content provide 취약점이 있으면 1 return
        else
            return 0;
    }
}
public abstract class Main{
    public static void main(String[] args){
        int contentprovide;
        Content content = new Content();
        contentprovide = content.find();

    }

}
