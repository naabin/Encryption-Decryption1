import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int data = reader.read();
            String word = "";
            while (data != -1) {
                word += (char) (data);
                data = reader.read();
            }
            reader.ready();
            reader.close();
            String filteredWord = word.trim();
            if (filteredWord.length() == 0) {
                System.out.println(0);
            } else {
                int wordCount = filteredWord.split("\\s+").length;
                System.out.println(wordCount);
            }
        }
    }

}