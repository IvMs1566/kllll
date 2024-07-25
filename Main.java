import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение в формате \"строка\" операция число:");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректный формат выражения");
            }

            String str = parts[0];
            String operation = parts[1];
            int num = Integer.parseInt(parts[2]);

            String result = calculate(str, operation, num);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static String calculate(String str, String operation, int num) {
        if (operation.equals("+")) {
            return str + num;
        } else if (operation.equals("-")) {
            if (str.contains(String.valueOf(num))) {
                return str.replace(String.valueOf(num), "");
            } else {
                return str;
            }
        } else if (operation.equals("*")) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < num; i++) {
                result.append(str);
            }
            return result.toString();
        } else if (operation.equals("/")) {
            int length = str.length() / num;
            if (length > 40) {
                return str.substring(0, 40) + "...";
            } else {
                return str.substring(0, length);
            }
        } else {
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operation);
        }
    }
}


