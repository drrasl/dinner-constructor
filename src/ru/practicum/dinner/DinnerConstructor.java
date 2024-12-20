package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> menu;

    public DinnerConstructor() {
        menu = new HashMap<>();
    }

    void addNewDishToMenu (String dishType, String dishName) {
        if (!(menu.containsKey(dishType))) {
            ArrayList<String> dishList = new ArrayList<>();
            dishList.add(dishName);
            menu.put(dishType, dishList);
        } else {
            ArrayList<String> dishList = menu.get(dishType);
            if (!dishList.contains(dishName)) {
                dishList.add(dishName);
            } else {
                System.out.println("Такое блюдо уже внесено в данный тип, пожалуйста, введите новое");
            }
        }
    }

    boolean checkType(String type) {

        return menu.containsKey(type); //rev.1 Блок кода сократил до 1 строки
    }
}
