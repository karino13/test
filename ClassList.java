import java.io.File;


public class Main {
    public static void main(String[] args) {
        String[] filelist;
        filelist = ClassList.Start();
    }

}
class ClassList {
    public static String[] filelist = new String[9999];
    public static String[] Start() {
        try {
            String path="C:\\test1"; // --------------- 읽어들일 DIR 경로 
            System.out.println("Directory Name:" + path);
            // main process.
            (new ClassList()).showFileList(path);
        } catch (Exception ex) { ex.printStackTrace(); }
        return filelist;
    }
    int j=0;
    public void showFileList(String path) throws Exception {
        File dir = new File(path);
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isFile()) {
                if(file.getCanonicalPath().toString().contains(".class")) filelist[j] = file.getCanonicalPath().toString(); System.out.println(j+filelist[j]);j++;
            //파일 목록 출력 없애려면 바로 윗줄의 System.out.println(j+filelist[j]); 부분을 지우시면 됩니다
            } else if (file.isDirectory()) { try { showFileList(file.getCanonicalPath().toString()); } catch (Exception e) { } }
        }
    }
}
