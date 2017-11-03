import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Velik Georgiev on 11/3/2017.
 */

public class LTPExample2 {
    public LTPExample2() {
        TestExample testExample = new TestExample();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder ps = new ProcessBuilder("javap.exe","-l", "LTPExample2.class");

        ps.redirectErrorStream(true);
        Process pr = ps.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        boolean startPrint = false;
        String line;
        while ((line = in.readLine()) != null) {
            if (line.trim().contains("LocalVariableTable")) {
                startPrint = true;
            } else if (line.trim().contains("}") || line.trim().equals("")) {
                startPrint = false;
            }

            if (startPrint) {
                System.out.println(line);
            }
        }
        pr.waitFor();

        in.close();

        LTPExample2 init = new LTPExample2();
        LTPExample2 example123 = new LTPExample2();
    }
}

class TestExample {

}
