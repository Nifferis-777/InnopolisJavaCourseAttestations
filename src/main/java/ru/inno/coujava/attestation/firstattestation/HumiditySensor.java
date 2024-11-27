package ru.inno.coujava.attestation.firstattestation;
import java.util.Random;

public class HumiditySensor {
    private Random random = new Random();

    public int getHumidity() {
        return random.nextInt(100); // возврат случайного значения влажности от 0 до 99
    }
}

