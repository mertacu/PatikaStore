import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockMarket {
    private List<Brand> brands = new ArrayList<>();
    private List<Notebook> notebooks = new ArrayList<>();
    private List<MobilePhone> mobiles = new ArrayList<>();

    public StockMarket() {
        initBrands();
        initProducts();
    }

    private void initBrands() {
        brands.add(new Brand(1, "SAMSUNG"));
        brands.add(new Brand(2, "LENOVO"));
        brands.add(new Brand(3, "APPLE"));
        brands.add(new Brand(4, "HUAWEI"));
        brands.add(new Brand(5, "CASPER"));
        brands.add(new Brand(6, "ASUS"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "XIAOMI"));
        brands.add(new Brand(9, "MONSTER"));
    }

    private void initProducts() {
        notebooks.add(new Notebook(1, "HUAWEI MATEBOOK 14", 7000.0, 10.0, 20, findBrandByName("Huawei"), 16, 512, 17.2));
        notebooks.add(new Notebook(2, "LENOVO V14 IGL", 16000.0, 15.0, 8, findBrandByName("Lenovo"), 32, 512, 16.9));
        notebooks.add(new Notebook(2, "ASUS TUF GAMING", 18499.0, 20.0, 12, findBrandByName("Asus"), 16, 1024, 15.6));

        mobiles.add(new MobilePhone(1, "SAMSUNG GALAXY A13", 12599.0, 15.0, 70, findBrandByName("Samsung"), 128, 6.5, 5000, 4, "Siyah"));
        mobiles.add(new MobilePhone(2, "IPHONE 15 PLUS 128 GB", 79599.0, 5.0, 25, findBrandByName("Apple"), 256, 7.1, 3000, 8, "Mavi"));
        mobiles.add(new MobilePhone(3, "REDMI NOTE 12 PRO 12 GB", 18999.0, 20.0, 90, findBrandByName("Xiaomi"), 128, 6.5, 6000, 6, "Beyaz"));
    }
    public void addNoteBook() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID: ");
        int ID = input.nextInt();
        input.nextLine(); //newline

        System.out.println("Model: ");
        String product = input.nextLine();

        System.out.println("Price: ");
        double price = input.nextDouble();

        System.out.print("Discount Rate: ");
        double discountRate = input.nextDouble();

        System.out.print("Stock: ");
        int stock = input.nextInt();

        System.out.print("Brand: ");
        input.nextLine();  // newline

        String brandName = input.nextLine();
        Brand brand = findBrandByName(brandName);

        System.out.print("Storage: ");
        int storage = input.nextInt();

        System.out.print("Screen: ");
        double screen = input.nextDouble();

        System.out.print("Ram : ");
        int ram = input.nextInt();

        Notebook notebook = new Notebook(ID, product, price, discountRate, stock, brand, ram, storage, screen);
        notebooks.add(notebook);
        System.out.println("Notebook başarı ile eklendi.");
    }

    public void addMobilePhone() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Model: ");
        String productName = input.nextLine();

        System.out.print("Price: ");
        double price = input.nextDouble();

        System.out.print("Discount Rate: ");
        double discountRate = input.nextDouble();

        System.out.print("Stock: ");
        int stock = input.nextInt();

        System.out.print("Brand: ");
        input.nextLine();  // Consume newline
        String brandName = input.nextLine();
        Brand brand = findBrandByName(brandName);

        System.out.print("Storage: ");
        int storage = input.nextInt();

        System.out.print("Screen: ");
        double screen = input.nextDouble();

        System.out.print("Battery: ");
        int battery = input.nextInt();

        System.out.print("Ram: ");
        int ram = input.nextInt();

        System.out.print("Color: ");
        input.nextLine();  // Consume newline
        String color = input.nextLine();

        MobilePhone mobilePhone = new MobilePhone(id, productName, price, discountRate, stock, brand, storage, screen, battery, ram, color);
        mobiles.add(mobilePhone);
        System.out.println("Mobile Phone başarı ile eklendi.");
    }

    public void listNoteBooks() {
        System.out.println("Notebook listesi : ");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID| Ürün İsmi                      | Fiyat       | Marka      | Depolama   | Ekran      | RAM     |");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for(Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public void listOfMobilePhones() {
        System.out.println("Mobile Phone listesi : ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID| Ürün İsmi                      | Fiyat       | Marka      | Depolama   | Ekran      | Pil        | RAM        | Renk   |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for(MobilePhone mobilePhone : mobiles) {
            System.out.println(mobilePhone);
        }

        System.out.println("-------------------------------------------------------------------------------------------------------");
    }

    public void deleteProductByTheirID(int id) {
        notebooks.removeIf(notebook -> notebook.getId() == id);
        mobiles.removeIf(mobilePhone -> mobilePhone.getId() == id);
        System.out.println("ID'si " + id + " olan ürün silinmiştir.");
    }

    private Brand findBrandByName(String name) {
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(name)) {
                return brand;
            }
        }
        return null;
    }
    public void listBrands() {
        brands.sort(Brand::compareTo);
        for(Brand brand : brands) {
            System.out.println(" -  " + brand.getName());
        }
    }
}
