package ru.roman.sem2;

import java.util.Comparator;

public class Notebook implements Comparable<Notebook> {

    private final double price;
    private final int ram;
    private final Brand brand;

    public Notebook(double price, int ram, Brand brand) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public int compareTo(Notebook o) {
        return Comparator.comparing(Notebook::getPrice)
                .thenComparing(Notebook::getRam)
                .thenComparing(Notebook::getBrand)
                .compare(this, o);
    }

    public enum Brand {
        Lenuvo(1),
        Asos(2),
        MacNote(3),
        Eser(4),
        Xamiou(5);

        private final int number;

        Brand(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
