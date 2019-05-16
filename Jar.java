import java.io.IOException;
import java.util.Scanner;

//jar파일 압축 풀기
class Jar {
    public static String FileName = "InsecureBankv2";
    public static String JarFunc(String args) {
        String[] cmd = { "cmd", "/c",  "cd C:\\test && jar xvf ",args+"-dex2jar.jar"};
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
    }
    public static void main(String[] args){
        String JarClass;
        JarClass = JarFunc(FileName);
    }
}
