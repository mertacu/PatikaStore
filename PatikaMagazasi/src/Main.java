import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Patika Mağazası Ürün Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    handleNotebookOperations(stockMarket, scanner);
                    break;
                case 2:
                    handleMobilePhoneOperations(stockMarket, scanner);
                    break;
                case 3:
                    stockMarket.listBrands();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor");
                    return;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Tekrar deneyin.");
            }
        }
    }

    private static void handleNotebookOperations(StockMarket stockMarket, Scanner scanner) {
        System.out.println("Notebook İşlemleri:");
        System.out.println("1 - Notebook Ekle");
        System.out.println("2 - Notebook Listele");
        System.out.println("3 - Notebook Sil");
        System.out.print("Tercihiniz: ");
        int pick = scanner.nextInt();

        switch (pick) {
            case 1:
                stockMarket.addNoteBook();
                break;
            case 2:
                stockMarket.listNoteBooks();
                break;
            case 3:
                System.out.print("Silmek istediğiniz notebook'un ID'sini giriniz: ");
                int id = scanner.nextInt();
                stockMarket.deleteProductByTheirID(id);
                break;
            default:
                System.out.println("Geçersiz bir seçim yaptınız.");
        }
    }

    private static void handleMobilePhoneOperations(StockMarket warehouse, Scanner scanner) {
        System.out.println("Cep Telefonu İşlemleri:");
        System.out.println("1 - Cep Telefonu Ekle");
        System.out.println("2 - Cep Telefonu Listele");
        System.out.println("3 - Cep Telefonu Sil");
        System.out.print("Tercihiniz: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                warehouse.addMobilePhone();
                break;
            case 2:
                warehouse.listOfMobilePhones();
                break;
            case 3:
                System.out.print("Silmek istediğiniz cep telefonunun ID'sini girin: ");
                int id = scanner.nextInt();
                warehouse.deleteProductByTheirID(id);
                break;
            default:
                System.out.println("Geçersiz bir seçim yaptınız.");
        }
    }
}