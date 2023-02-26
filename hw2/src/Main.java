//***Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//        Пример 1: а = 3, b = 2, ответ: 9
//        Пример 2: а = 2, b = -2, ответ: 0.25
//        Пример 3: а = 3, b = 0, ответ: 1
//        Пример 4: а = 0, b = 0, ответ: не определено
//        Пример 5
//        входные данные находятся в файле input.txt в виде
//        b 3
//        a 10
//        Результат нужно сохранить в файле output.txt
//        1000

//        нельзя использовать math.pow


import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        int[] array = readFile();
        int a = array[0];
        int b = array[1];
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        String str = "";
        if(a == 0 && b == 0) writeFile("не определено");
        else if(b < 0) writeFile(str = a + "^" + b + " = " + negativPow(a, b));
        else writeFile(str = a + "^" + b + " = " + positivPow(a, b));
    }

    // Метод считывания файла:
    public static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        int[] intArray = new int[2];
        String[] stringArray = line.split(" ");
        String x = "a";
        if(stringArray[0].codePointAt(0) == x.codePointAt(0)){
            intArray[0] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[1] = Integer.parseInt(stringArray[1]);
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        scanner.close();
        return intArray;
    }

    // ВЫчисление положительной степени
    public static String positivPow(int a, int b) {
        int temp = 1;
        String result = "";
        for(int i = 0; i < b; i++){
            temp *= a;
        }
        result = String.valueOf(temp);
        return result;
    }

    // Вычисление отрицательной степени
    public static String negativPow(int a, int b) {
        double temp = 1;
        String result = "";
        for(int i = 0; i < b * -1; i++){
            temp *= a;
        }
        result = String.valueOf(1/temp);
        return result;
    }

    // Метод записи в файл:
    public static void writeFile(String string) throws FileNotFoundException {
        File file = new File("output.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println(string);
        pw.close();
    }
}