 public class alphaNumeric {
    public static void main(String[] args) {
    Langauge lang=Langauge.Ukrainian;
        int num=3;
    String result = numbers(num, lang);
        System.out.println(result);
    }

    public static String numbers(int value, Langauge langauge) {
        String letters=null;
        switch (langauge)  {
            case English:
                switch (value) {
                    case 0:
                        letters = "Null";
                        break;
                    case 1:
                        letters = "One";
                        break;
                    case 2:
                        letters = "Two";
                        break;
                    case 3:
                        letters = "Three";
                        break;
                    case 4:
                        letters = "Four";
                        break;
                    case 5:
                        letters = "Five";
                        break;
                }
                break;
            case Russian:
                switch (value) {
                    case 0:
                        letters = "Ноль";
                        break;
                    case 1:
                        letters = "Один";
                        break;
                    case 2:
                        letters = "Два";
                        break;
                    case 3:
                        letters = "Три";
                        break;
                    case 4:
                        letters = "Четыре";
                        break;
                    case 5:
                        letters = "Пять";
                        break;
                }
                break;
            case Ukrainian:
                switch (value) {
                    case 0:
                        letters = "Нуль";
                        break;
                    case 1:
                        letters = "Перший";
                        break;
                    case 2:
                        letters = "Другий";
                        break;
                    case 3:
                        letters = "Третій";
                        break;
                    case 4:
                        letters = "Четвертий";
                        break;
                    case 5:
                        letters = "Пятий";
                        break;
                }
                break;
            }
        return letters;
    }
    enum Langauge {
        English, Russian, Ukrainian;
    }
    }


