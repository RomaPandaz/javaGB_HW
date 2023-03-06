package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Класс объекта ноутбук
 */

@Data
@AllArgsConstructor
public class Laptop {

    private final BigDecimal MIN_PRICE = new BigDecimal(0);
    private String manufacturer;
    private String model;
    private Double screenDiagonal;
    private Integer releaseYear;
    private String operatingSystem;
    private String processorManufacturer;
    private String processorModel;
    private Integer ram;
    private String typeOfGraphicsAccelerator;
    private String builtInVideoCardModel;
    private String discreteGraphicsCardModel;
    private Integer videoMemorySize;
    private String storageType;
    private Integer ssdVolume;
    private Integer hddVolume;
    private String laptopType;
    private String color;
    private BigDecimal price;


    public void setPrice(BigDecimal price) {
        if (price.compareTo(MIN_PRICE) <= 0){
            System.out.println("Цена не может быть равна или меньше нуля!");
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Ноутбук " + manufacturer + " " + model + ":\n" +
                "Диагональ экрана = " + screenDiagonal + '\n' +
                "Год релиза = " + releaseYear + '\n' +
                "ОС = " + operatingSystem + '\n' +
                "Производитель процессора = " + processorManufacturer + '\n' +
                "Модель процессора = " + processorModel + '\n' +
                "ОЗУ = " + ram + "Гб" + '\n' +
                "Тип графики = " + typeOfGraphicsAccelerator + '\n' +
                "Встроенная графика = " + builtInVideoCardModel + '\n' +
                "Дискретная графика = " + discreteGraphicsCardModel + '\n' +
                "Объем видеопамяти = " + videoMemorySize + "Гб" + '\n' +
                "Хранение данных = " + storageType + '\n' +
                "Объем SSD = " + ssdVolume + "Гб" + '\n' +
                "Объем HDD = " + hddVolume + "Гб" + '\n' +
                "Тип ноутбука = " + laptopType + '\n' +
                "Цвет = " + color + '\n' +
                "Цена = " + price + '\n';
    }
}
