import java.io.IOException;
import java.util.Scanner;
import java.io.File;


//jar파일 압축 풀기
class Jar {
    public static String[] JarFunc(String args) {
        String[] cmd = {"cmd", "/c", "cd C:\\test && jar xvf ", args + "-dex2jar.jar"};
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


        String dirName = "C:\\test\\com\\android\\insecurebankv2";
        File dir = new File(dirName);
        String files[] = dir.list();
        //디렉토리의 파일목록(디렉토리포함)을 String배열로 반환

        File[] files2 = dir.listFiles();
        System.out.println(files);
        for (File f : files2) {
            String str = f.getName();
                    System.out.print(str+"\n");
            }
        return files;
        }

    }
    
    public class Main{
        public static String FileName = "InsecureBankv2";
        public static void main(String[] args){

        String JarClass[]; //class 파일들 이름 들어간 list 변수
        JarClass = Jar.JarFunc(FileName);

    }
}
