package managers;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class HistoryBuyManager {

    private final Scanner scanner;

    public static int TotalSumma;
    public static int Product;
    public static int Buyer;
    public static int QuantityProduct_final;




    public HistoryBuyManager() {
        scanner = new Scanner(System.in);
    }

    public void BuyProduct(List<Product> products, List<Buyer> buyers) {
        System.out.println(" Список покупателей: ");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers.get(i).getFirstname()
                    , buyers.get(i).getLastname()
                    , buyers.get(i).getPhone());
        }
        System.out.print("Выберите покупателя: ");
        Buyer = scanner.nextInt(); scanner.nextLine();

        System.out.println("=====================================");
        System.out.println("Список продуктов: ");
        for (int j = 0; j < products.size(); j++) {
            System.out.printf("%d. Название продукта: %s%n Количество: %s%n Цена продукта: %s%n"
                    , j + 1
                    , products.get(j).getTitle()
                    , products.get(j).getQuantity()
                    , products.get(j).getPrice());
        }
        System.out.println("=====================================");
        System.out.print("Выберите товар: ");

        Product = scanner.nextInt(); scanner.nextLine();

        System.out.println("=====================================");
        System.out.print("Выберите кол-во товара: ");

        int quantityProduct = scanner.nextInt(); scanner.nextLine();
        int a = products.get(Product - 1).getQuantity();
        int b = products.get(Product - 1).getPrice();

        if (quantityProduct <= a) {
            int TotalSummaProduct = b * quantityProduct;
            if (TotalSummaProduct > buyers.get(Buyer - 1).getCash()) {

                System.out.println("=====================================");
                System.out.println("У вас недостаточно средст для совершения данной покупки!");
                System.out.println("=====================================");

            } else {
                int balance = buyers.get(Buyer - 1).getCash() - TotalSummaProduct;
                buyers.get(Buyer - 1).setCash(balance);
                int ark = products.get(Product - 1).getQuantity() - quantityProduct;
                products.get(Product - 1).setQuantity(ark);
                TotalSumma = TotalSummaProduct;
                QuantityProduct_final = quantityProduct;

                System.out.println("=====================================");
                System.out.println("Остаток на счету: " + balance);
                System.out.println("=====================================");
            }
        } else {

            System.out.println("=====================================");
            System.out.println("На складе нет достаточного количества товара!");
            System.out.println("=====================================");
        }


    }

    public void printHistoryBuys(List<HistoryBuy> historyBuys) {
        for (int i = 0; i < historyBuys.size(); i++ ) {
            System.out.println(1+i + ". Название продукта: "+ historyBuys.get(i).getHistoryProductName());
            System.out.println("Цена продукта: "+ historyBuys.get(i).getHistoryProductPrice());
            System.out.println("Колл-во продукта: "+ historyBuys.get(i).getHistoryProductQantity());
            System.out.println("Покупатель: "+ historyBuys.get(i).getBuyer().getFirstname() + " " + historyBuys.get(i).getBuyer().getLastname() + " | Телефон: " + historyBuys.get(i).getBuyer().getPhone());
            System.out.println("Дата покупки: "+ historyBuys.get(i).getBuyOnProduct());
        }
        System.out.println();
    }

    public HistoryBuy createStoryList(List<Product> products, List<Buyer> buyers) {

        String historyProduct = String.valueOf(products.get(Product - 1).getTitle());
        String historyBuyerName = (buyers.get(Buyer - 1).getFirstname());
        String historyBuyerLastName = (buyers.get(Buyer - 1).getLastname());
        String historyBuyerPhone = String.valueOf(buyers.get(Buyer - 1).getPhone());

        HistoryBuy historyBuy = new HistoryBuy();
        historyBuy.setHistoryProductName(historyProduct);
        historyBuy.setHistoryProductPrice(String.valueOf(TotalSumma));
        historyBuy.setHistoryProductQantity(String.valueOf(QuantityProduct_final));
        historyBuy.setBuyer(buyers.get(Buyer - 1));
        historyBuy.setBuyerNames(historyBuyerName);
        historyBuy.setBuyerLastNames(historyBuyerLastName);
        historyBuy.setBuyerPhones(historyBuyerPhone);
        historyBuy.setBuyOnProduct(new GregorianCalendar().getTime());

        return historyBuy;
    }

}