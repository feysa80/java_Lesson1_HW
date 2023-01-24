package Task;
//1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
//2.Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
//3.Задача 3: Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        String task1Description = "Задача 1: Задать одномерный массив и найти в нем минимальный и максимальный элементы";
        String task2Description = "Задача 2: Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.";
        String task3Description = "Задача 3: Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.";
        System.out.println(task1Description);
        System.out.println(task2Description);
        System.out.println(task3Description);
        System.out.print("Введите номер задачи для проверки: ");
        int taskNumber = taskNumber();
        switch (taskNumber){
            case (1):
                int[] arrayTask1 = createArray(1, 100);
                task1(arrayTask1);
                break;
            case (2):
                task2();
                break;
            case (3):
                int[] arrayTask3 = createArray(1,5);
                System.out.println("Исходный массив:");
                System.out.println(Arrays.toString(arrayTask3));
                int[] arrayResult = task3(arrayTask3, 3);
                System.out.println("Результат:");
                System.out.println(Arrays.toString(arrayResult));
                break;
        }

    }
    public static int[] createArray(int min, int max){
        Scanner num = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int size = Integer.parseInt(num.nextLine());
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(min, max);
        }
        return array;
    }
    public static void task1(int[] someArray){
        int min = someArray[0];
        int max = someArray[0];
        for (int item: someArray){
            min = (item < min) ? item : min;
            max = (item > max) ? item : max;
        }
        System.out.println(Arrays.toString(someArray));
        System.out.printf("В заданном массиве минимальное занчение - %d, а максимальное значение - %d",min, max);
    }
    public static void task2(){
        Boolean result ;
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 400 == 0) {
            result = true;
        } else if (year % 100 == 0) {
            result = false;

        } else if (year % 4 == 0) {
            result = true;
        } else {
            result = false;
        }
        if (result == true){
            System.out.printf("Результат - %b, введенный год - високосный", result);
        } else {
            System.out.printf("Результат - %b, введенный год - не високосный", result);
        }


    }
    public static int[] task3(int[] someArray, int value){
        int right = someArray.length - 1;
        int left = 0;
        while (right != left){
            while(someArray[right] == value){
                right --;
            }
            if (someArray[left] == value) {
                someArray[left] = someArray[right];
                someArray[right]= value;
                right --;
                left ++;
            } else {
                left ++;
            }

        }
        return someArray;
    }
    public static int taskNumber(){
        Scanner scan = new Scanner(System.in);
        int task = scan.nextInt();
        if (task <= 0 || task >3){
            System.out.println("Вы неправильно ввели номер задачи, введите число от 1 до 3");
            task =  taskNumber();
        }
        return task;
    }
}
