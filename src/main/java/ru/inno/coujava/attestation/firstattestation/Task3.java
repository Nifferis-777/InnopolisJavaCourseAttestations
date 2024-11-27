//3.Второй элемент
//Напишите программу, которая находит в массиве чисел второй по величине элемент.
//Например, для массива [1,5,7,3,2,0,4,9,6], программа выведет 7, потому что самый большой элемент - 9, а, после него, 7.

package ru.inno.coujava.attestation.firstattestation;
public class Task3 {
        public static void main(String[] args) {
            double[] numbers = {1.3, 5, 7, 3.1, 2, 0, 4.6, 9.3, 6, 12.1}; // Заданный массив
            double firstLargest = Double.MIN_VALUE; // Инициализация первого по величине элемента
            double secondLargest = Double.MIN_VALUE; // Инициализация второго по величине элемента

            for (double number : numbers) {
                if (number > firstLargest) {
                    secondLargest = firstLargest;
                    firstLargest = number;
                } else if (number > secondLargest && number < firstLargest) {
                    secondLargest = number;
                }
            }
            if (secondLargest == Double.MIN_VALUE) {
                System.out.println("Второй по величине элемент не найден.");
            } else {
                System.out.println("Второй по величине элемент: " + secondLargest);
            }
        }
    }