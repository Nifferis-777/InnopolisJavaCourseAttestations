//

package ru.inno.coujava.attestation.firstattestation;
import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        // Пример даты последнего полива (год, месяц, день)
        LocalDate lastWateredDate = LocalDate.of(2024, 11, 20); // Указываем нужную дату
        Cactus cactus = new Cactus(lastWateredDate);

        LocalDate currentDate = LocalDate.now(); // Текущая дата
        HumiditySensor sensor = new HumiditySensor();
        int humidity = sensor.getHumidity();

        System.out.println("Текущая дата: " + currentDate);
        System.out.println("Последний полив: " + cactus.getLastWatered());
        System.out.println("Текущая влажность: " + humidity + "%");

        // Расчет следующей даты полива
        String nextWatering = cactus.nextWateringDate(currentDate, humidity);

        // Вывод результата
        if (humidity < 30) {
            System.out.println("Кактус нуждается в поливе. Следующая дата полива: " + nextWatering);
        } else {
            System.out.println(nextWatering);
        }
    }
}

