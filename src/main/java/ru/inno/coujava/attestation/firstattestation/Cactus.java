package ru.inno.coujava.attestation.firstattestation;
import java.time.LocalDate;

public class Cactus {
    private LocalDate lastWatered;

    public Cactus(LocalDate lastWatered) {
        this.lastWatered = lastWatered;
    }

    public LocalDate getLastWatered() {
        return lastWatered;
    }

    public void setLastWatered(LocalDate lastWatered) {
        this.lastWatered = lastWatered;
    }

    public String nextWateringDate(LocalDate currentDate, int humidity) {
        if (isWinter(currentDate)) {
            return lastWatered.plusMonths(1).toString();
        } else if (isSpring(currentDate) || isAutumn(currentDate)) {
            return lastWatered.plusWeeks(1).toString();
        } else { // Summer
            if (humidity < 30) {
                return currentDate.plusDays(1).toString();
            } else {
                return "Полив не требуется, влажность достаточная.";
            }
        }
    }

    private boolean isWinter(LocalDate date) {
        return date.getMonthValue() == 12 || date.getMonthValue() <= 2;
    }

    private boolean isSpring(LocalDate date) {
        return date.getMonthValue() >= 3 && date.getMonthValue() <= 5;
    }

    private boolean isAutumn(LocalDate date) {
        return date.getMonthValue() >= 9 && date.getMonthValue() <= 11;
    }
}

