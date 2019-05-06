import java.io.IOException;
import java.util.Scanner;

public class JarDecompress {


    public static void main(String[] args) {
        // 실행 커맨드
        String[] cmd = { "cmd", "/c", "cd C:\\test && jar xvf InsecureBankv2-dex2jar.jar"};

        Process process = null;

        try {
            // 프로세스빌더 실행
            process = new ProcessBuilder(cmd).start();

            // 스캐너클래스를 사용해 InputStream을 스캔함
            Scanner s = new Scanner(process.getInputStream(), "EUC-KR");
            while (s.hasNextLine() == true) {
                // 표준출력으로 출력
                System.out.println(s.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
