package org.example;

import java.math.BigDecimal;
import java.util.*;

/**
 * Класс хранящий множество объектов и обрабатывающий поисковые запросы
 */
public class DataBase {
    Laptop lap1 = new Laptop("Lenovo", "Legion 5 PRO", 16.0, 2021,
            "Windows", "AMD", "Ryzen 5 5600H", 16,
            "Discrete/BuiltIn", "AMD Radeon Graphics",
            "Nvidia RTX 3060", 6, "SSD", 512, 0,
            "Game", "Gray", new BigDecimal(1000));
    Laptop lap2 = new Laptop("Asus", "VivoBook", 15.6, 2021,
            "NoOS", "Intel", "Core i3-1115G4", 8,
            "BuiltIn", "Intel UHD Graphics", "-",
            0, "SSD", 512, 0,
            "Hybrid", "Blue", new BigDecimal(500));
    Laptop lap3 = new Laptop("MSI", "Modern 15", 15.6, 2022,
            "Windows", "Intel", "Core i3-1215U", 8,
            "BuiltIn", "Intel UHD Graphics", "-",
            0, "SSD", 512, 0,
            "Hybrid", "Black", new BigDecimal(700));
    Laptop lap4 = new Laptop("HP", "255", 15.6, 2020,
            "NoOS", "AMD", "Athlon Gold 3150U", 8,
            "BuiltIn", "AMD Radeon Graphics", "-",
            0, "HDD", 0, 1000,
            "Office", "Silver", new BigDecimal(300));
    public List<Laptop> allLaptops = new ArrayList<>(Arrays.asList(lap1, lap2, lap3, lap4));


    /**
     * Предлагает пользователю список для поиска с выбором числового значения (меню поисковика)
     * @param mapList лист для выбора
     * @return выбор пользователя с типом int
     */
    public static int findChoice(Map<Integer, String> mapList) {
        int choice = -1;

        printMap(mapList);

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        while (choice < 1 || choice > mapList.size()) {
            if (sc.hasNextInt()) choice = sc.nextInt();
            if (!(choice > 0 && choice < mapList.size()+1)) {
                System.out.println("Не корректный ввод!");
                System.out.print("Введите цифру: ");
                sc.nextLine();
            }
        }
        return choice;
    }

    /**
     * Фильтрация множества объектов
     * @param num выбор пользователя в меню
     */
    public void filterList(Integer num){
        int count = 1;
        int choice;
        Map <Integer, String> findList = new HashMap<>();
        switch (num){
            case (1):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getManufacturer())){
                        findList.put(count, el.getManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getManufacturer().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (2):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getScreenDiagonal().toString())){
                        findList.put(count, el.getScreenDiagonal().toString());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getScreenDiagonal().toString().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (3):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getProcessorManufacturer())){
                        findList.put(count, el.getProcessorManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getProcessorManufacturer().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (4):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getTypeOfGraphicsAccelerator())){
                        findList.put(count, el.getTypeOfGraphicsAccelerator());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getTypeOfGraphicsAccelerator().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (5):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getStorageType())){
                        findList.put(count, el.getStorageType());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getStorageType().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case(6):
                System.out.println("Будет показан ноутбук с минимально близкой ценой!");
                int sum = 0;
                Scanner sc = new Scanner(System.in);
                System.out.print("Введите сумму: ");
                while (sum <= 0) {
                    if (sc.hasNextInt()) sum = sc.nextInt();
                    if (sum <= 0) {
                        System.out.println("Не корректный ввод!");
                        System.out.print("Введите сумму: ");
                        sc.nextLine();
                    }
                }
                NavigableSet <BigDecimal> priceSet = new TreeSet<>();
                for (Laptop el: allLaptops) {
                    priceSet.add(el.getPrice());
                }
                BigDecimal find = priceSet.floor(BigDecimal.valueOf(sum));
                if (find == null) find = priceSet.ceiling(BigDecimal.valueOf(sum));

                for (Laptop el: allLaptops) {
                    if (el.getPrice().compareTo(find) == 0){
                        System.out.println(el);
                    }
                }
                break;


        }
    }

    /**
     * Печать Map в консоль
     * @param map
     */
    public static void printMap(Map <Integer, String> map){
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.printf("%d - %s;%n", item.getKey(), item.getValue());
        }
    }
}
