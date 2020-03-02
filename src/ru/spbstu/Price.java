package ru.spbstu;

import java.util.Objects;

public class Price {
    int rubles;
    int pennies;

    public Price(int rubles, int pennies) {
        if (rubles >= 0 && pennies >= 0 && pennies <= 99) {
            this.rubles = rubles;
            this.pennies = pennies;
        } else {
            throw new IllegalArgumentException("Incorrect price");
        }
    }

    public int getPennies() {
        return pennies;
    }

    public int getRubles() {
        return rubles;
    }

    @Override
    public String toString() {
        return (this.getRubles() + " rubles  " + this.getPennies() + " pennies");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Price) {
            Price other = (Price) obj;
            return (rubles == other.rubles && pennies == other.pennies);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (Objects.hash(rubles, pennies));
    }
}
