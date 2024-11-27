//1. Мальчик хочет написать на заборе признание в любви девочке из пятнадцати букв и трех пробелов.
//На каждые три буквы мальчик тратит по 62 см длины забора, а на каждый пробел - 12 см.
//Напишите программу, которая поможет по длине забора (введенной пользователем) выяснить,
//поместится ли на забор такой длины надпись мальчика

package ru.inno.coujava.attestation.firstattestation;
import java.util.Scanner;
public class Task1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Данные
            int numberOfLetters = 15;
            int numberOfSpaces = 3;
            double lengthPerThreeLetters = 62; // длина на каждые 3 буквы
            double lengthPerSpace = 12; // длина на каждый пробел

            // Расчет длины надписи
            double totalLength = (numberOfLetters / 3.0 * lengthPerThreeLetters) + (numberOfSpaces * lengthPerSpace);

            // Запрос длины забора у пользователя
            System.out.print("Введите длину забора (в сантиметрах): ");
            double fenceLength = scanner.nextDouble();

            // Проверка, поместится ли надпись на заборе
            if (totalLength <= fenceLength) {
                System.out.println("Надпись поместится на заборе.");
            } else {
                System.out.println("Надпись не поместится на заборе.");
            }

            scanner.close();
        }
    }

