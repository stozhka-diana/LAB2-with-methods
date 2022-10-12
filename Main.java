package Matritsa;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int IntegralNumber(int min){ //метод для обробки виключення, коли в масиві відсутнє від'ємне число
        if(min > 0) {
            throw new IllegalArgumentException("В матрицю не було введено негативних чисел."); //«кинуто вийняток» та створено екземпляр RuntimeException з повідомленням

        }
        else System.out.println("Мінімальне від'ємне число: ");
        return min;
    }

    public static void Input(int[][] array) { //метод введення масиву чисел
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++){
                try { //обробка виключення введення рядка замість числа
                    array[i][j] = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.err.println("Введений рядок замість числа.");
                    sc.nextLine();
                }
            }
        }
    }
    public static int Min(int[][] array){ //визначення мінімального числа масиву
        int min = array[0][0]; //
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < min)
                    min = array[i][j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Задайте кількість стовпців матриці: ");
        int m = sc.nextInt();

        System.out.print("Задайте кількість строк матриці: ");
        int n = sc.nextInt();

        int[][] array = new int[n][m];

        System.out.println("Введіть елементи матриці:" + "\t");
        Input(array); //виведення методу Input

        System.out.println("Введений масив: " + Arrays.deepToString(array));

        System.out.println(IntegralNumber(Min(array))); //виведення мінімального елементу масиву з використанням методу Min

    }
}