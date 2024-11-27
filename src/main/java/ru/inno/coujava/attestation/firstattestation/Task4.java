//4.Камень-ножницы-бумага
// Напишите консольное приложение, которое играет с пользователем в камень-ножницы-бумагу.
//Требования:
//1. Пользователь вводит значение через консоль К - камень Н - ножницы Б - бумага
//2. Программа выбирает свой вариант случайным образом
//3. Игра состоит из 5 раундов
//4. Баллы считаются по формуле ниже.
//5. По итогу 5 раундов, программа пишет счет и объявляет победителя.
//Конец игры.
//Как считать баллы:
//1. Если сторона одержала победу с помощью камня (К), победитель получает 1 балл
//2. Если сторона одержала победу с помощью ножниц (Н), победитель получает 2 балла
//3. Если сторона одержала победу с помощью бумаги (Б), победитель получает 5 баллов

package ru.inno.coujava.attestation.firstattestation;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Объявление переменных для счета
        int userScore = 0;
        int computerScore = 0;

        // Реализация 5 раундов
        for (int round = 1; round <= 5; round++) {
            System.out.println("Раунд " + round + ": Введите 'К' для камня, 'Н' для ножниц, 'Б' для бумаги:");
            String userInput = scanner.nextLine().toUpperCase();

            // Генерация выбора компьютера
            String computerChoice = generateComputerChoice(random);
            System.out.println("Компьютер выбрал: " + computerChoice);

            // Определение результата
            int result = determineWinner(userInput, computerChoice);
            if (result == 1) {
                userScore += getPoints(userInput);
                System.out.println("Вы победили в раунде!");
            } else if (result == -1) {
                computerScore += getPoints(computerChoice);
                System.out.println("Компьютер победил в раунде!");
            } else {
                System.out.println("Ничья в раунде!");
            }
            System.out.println("Текущий счет: Вы " + userScore + " - Компьютер " + computerScore);
            System.out.println();
        }

        // Итоговый результат
        System.out.println("Игра окончена!");
        System.out.println("Ваш счет: " + userScore + " - Счет компьютера: " + computerScore);
        if (userScore > computerScore) {
            System.out.println("Вы выиграли игру!");
        } else if (userScore < computerScore) {
            System.out.println("Компьютер выиграл игру!");
        } else {
            System.out.println("Игра закончилась вничью!");
        }

        scanner.close();
    }

    // Метод для генерации выбора компьютера
    private static String generateComputerChoice(Random random) {
        int choice = random.nextInt(3); // 0, 1, или 2
        return switch (choice) {
            case 0 -> "К"; // Камень
            case 1 -> "Н"; // Ножницы
            case 2 -> "Б"; // Бумага
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    // Метод для определения победителя
    private static int determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return 0; // Ничья
        }
        // Определение победителя
        return switch (userChoice) {
            case "К" -> (computerChoice.equals("Н") ? 1 : -1);
            case "Н" -> (computerChoice.equals("Б") ? 1 : -1);
            case "Б" -> (computerChoice.equals("К") ? 1 : -1);
            default -> 0; // Ошибка ввода
        };
    }

    // Метод для получения очков в зависимости от вариантов
    private static int getPoints(String choice) {
        return switch (choice) {
            case "К" -> 1; // 1 очко за камень
            case "Н" -> 2; // 2 очка за ножницы
            case "Б" -> 5; // 5 очков за бумагу
            default -> 0; // Неправильный выбор
        };
    }
}

