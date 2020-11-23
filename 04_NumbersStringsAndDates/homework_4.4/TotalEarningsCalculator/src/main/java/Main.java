public class Main {
    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        int digitStr = 0;
        String indexStr = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) && text.charAt(i - 1) == ' ') {
                indexStr += i;
            }
            if (Character.isDigit(text.charAt(i)) && text.charAt(i + 1) == ' ') {
                indexStr += i + 1;
            }
        }
        for (int i = 0; i <= 8; i += 4) {
            digitStr += Integer.parseInt(text.substring(Integer.parseInt(indexStr.substring(i, i + 2)), Integer.parseInt(indexStr.substring(i + 2, i + 4))));
        }
        System.out.println(digitStr);
    }
}