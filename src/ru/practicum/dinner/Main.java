package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд"); //Выведем список
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDishToMenu(dishType, dishName);
        // добавьте новое блюдо

    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        ArrayList<String> typeDish = new ArrayList<>();
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения "
                + "ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                typeDish.add(nextItem);
            } else {
                System.out.println("Вы ввели несуществующий тип, пожалуйста введите еще раз");
            }
            nextItem = scanner.nextLine();
        }
        // сгенерируйте комбинации блюд и выведите на экран
        Random random = new Random();
        ArrayList<String> typeRandomDish = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            for (String type : typeDish) {
                ArrayList<String> dishList = dc.menu.get(type);
                int randomDish = random.nextInt(dishList.size());
                typeRandomDish.add(dishList.get(randomDish));
            }
            System.out.println("Комбо " + (i+1));
            System.out.println(typeRandomDish);
            typeRandomDish.clear();
        }
    }
}
