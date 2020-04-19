import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberString = scanner.next();
        while (!numberString.equals("0")) {
            try {
                int parseInt = Integer.parseInt(numberString);
                System.out.println(parseInt * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + numberString);
            }
            numberString = scanner.next();
        }
    }
}