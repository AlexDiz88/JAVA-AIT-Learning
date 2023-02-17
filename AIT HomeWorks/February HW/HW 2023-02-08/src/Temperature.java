public enum Temperature {
    COLD(5), WARM(25), HOT(65);
    int temperature;

    Temperature (int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
