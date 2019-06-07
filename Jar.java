import java.io.IOException;
import java.util.Scanner;
import java.io.File;


//jar파일 압축 풀기 ------------ 이 클래스는 jar파일 압축만 풀어줍니다.
class Jar {
    public static void JarFunc(String args) {
        String[] cmd = {"cmd", "/c", "cd C:\\test && jar xvf ", args + "-dex2jar.jar"};
        Process process = null;
        try {
            process = new ProcessBuilder(cmd).start();
            Scanner s = new Scanner(process.getInputStream(), "EUC-KR");
            while (s.hasNextLine() == true) { System.out.println(s.nextLine()); }
        } catch (IOException e) { e.printStackTrace(); }
    }
}

public class Main{
    public static String FileName = "InsecureBankv2";
    public static void main(String[] args){

        Jar.JarFunc(FileName); // jar 파일 압축 풀기 함수선언
    }
}
