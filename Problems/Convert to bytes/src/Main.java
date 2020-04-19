import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int read = inputStream.read();
        String data = "";
        while (read != -1) {
            data += read;
            read = inputStream.read();
        }
        System.out.println(data);
    }
}