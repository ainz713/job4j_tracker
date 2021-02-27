package ru.job4j.stream;

public class Auto {
    private String marka;

    private String model;

    private String modifikaciya;

    private String privod;

    private boolean available;

    static class Builder {
        private String marka;
        private String model;
        private String modifikaciya;
        private String privod;
        private boolean available;

        Builder buildMarka(String marka) {
            this.marka = marka;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildModofikaciya(String modifikaciya) {
            this.modifikaciya = modifikaciya;
            return this;
        }

        Builder buildPrivod(String privod) {
            this.privod = privod;
            return this;
        }

        Builder buildAvailable(boolean available) {
            this.available = available;
            return this;
        }

        Auto build() {
            Auto auto = new Auto();
            auto.marka = marka;
            auto.model = model;
            auto.modifikaciya = modifikaciya;
            auto.privod = privod;
            auto.available = available;
            return auto;
        }
    }
}
