import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        do {
            count++;
            num = scanner.nextInt();
        }while (num != 0);
        System.out.println(count);
    }
}