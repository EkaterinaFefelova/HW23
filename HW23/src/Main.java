import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final String VALID_NUMBER = "[7-8](9)[0-9]{9}+";

    private static Set<String> numbers = new TreeSet<String>();

    public static void main(String[] args) {
       while (true){
           String input = getInput();
           if(isValidNumber(input))
               addNumber(formatNumber(input));
            else if (input.equalsIgnoreCase("Печать"))
                printAll();
            else if (input.equalsIgnoreCase("Выход"))
                return;
            else
                System.out.println("Неверный ввод!");
       }
    }

    public static String getInput(){
        System.out.println("Пожалуйста, введите российский номер телефона, команду Печать или Выход: ");
        return new Scanner(System.in).nextLine().trim();
    }

    public static boolean isValidNumber (String input){
        String result = input.replaceAll("\\D+", "");
        if(result.length()==10)
            result = "7" + result;
        return result.matches(VALID_NUMBER);
    }

    public static String formatNumber (String number){
        String result = number.replaceAll("\\D+", "");
        if(result.length()==10)
            return result;
        return result.substring(1);
    }

    public static void addNumber (String number){
        if(numbers.add(number))
            System.out.println("Номер успешно добавлен");
       else
            System.out.println("Такой номер уже есть в базе");
    }

    public static void printAll() {
        if(numbers.isEmpty()) {
            System.out.println("Cписок номеров пуст!");
            return;
        }
        for (String number : numbers)
            System.out.println(number);
    }
}