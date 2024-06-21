public class MobilePhone extends Product {
    private int storage;
    private double screenSize;
    private int battery;
    private int ram;
    private String color;

    public MobilePhone(int id, String name, double price, double discount, int stock, Brand brand, int storage, double screenSize, int battery, int ram, String color) {
        super(id, name, price, discount, stock, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("| %d | %-30s | %-8.1f TL | %-10s | %-10d | %-10.1f | %-10d | %-10d | %-10s |",
                getId(), getName(), getPrice(), getBrand().getName(), storage, screenSize, battery, ram, color);
    }
}
