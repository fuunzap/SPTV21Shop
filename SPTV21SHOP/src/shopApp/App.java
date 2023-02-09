package shopApp;

//import entity.BookProduct;
import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;
import entity.Shop;
import interfaces.PersistenceData;
import managers.BookProductManager;
import managers.BuyerManager;
import managers.HistoryBuyManager;
import managers.ShopManagers;
import managers.BaseDataManager;
import managers.FileDataManager;


import java.util.List;
import java.util.Scanner;

public class App {

    static boolean saveToBase;
    private final Scanner scanner;
    private List<Buyer> buyers;

    private List<Shop> shops;

    private List<Product> products;
    private List<HistoryBuy> historyBuys;
    private final BuyerManager buyerManager;
    private final BookProductManager bookProductManager;
    private final HistoryBuyManager historyBuyManager;

    private final PersistenceData dataManager;

    private final ShopManagers shopManagers;

    private HistoryBuy historyBuy;

    public App(){
        scanner = new Scanner(System.in);
        if (App.saveToBase){
            dataManager = new BaseDataManager();
        } else {
            dataManager = new FileDataManager();
        }
        buyers = dataManager.loadBuyer();
        products = dataManager.loadProdoct();
        historyBuys = dataManager.loadHistories();
        buyerManager = new BuyerManager();
        bookProductManager = new BookProductManager();
        historyBuyManager = new HistoryBuyManager();
        shopManagers = new ShopManagers();
        shops = dataManager.loadShopCash();
    }

    public void run()  {
        boolean repeat = true;
        do {
            System.out.println("");
            System.out.println("================= Задачи ===================");
            System.out.println("");
            System.out.println("===> (0)     Выйти из програм       (0) <===");
            System.out.println("===> (1)     Добавить продукт       (1) <===");
            System.out.println("===> (2)    Добавить покупателя     (2) <===");
            System.out.println("===> (3)     Список продуктов       (3) <===");
            System.out.println("===> (4)    Список покупателей      (4) <===");
            System.out.println("===> (5)      Купить товар          (5) <===");
            System.out.println("===> (6) История покупок в магазине (6) <===");
            System.out.println("===> (7)     Пополнить счет         (7) <===");
            System.out.println("===> (8)    Посмотреть баланс       (8) <===");
            System.out.println("===> (9)  Изменить данные о товаре  (9) <===");
//            System.out.println("===> (10)    Удаление продукта     (10) <===");
            System.out.println("===> (11)    Прибыль магазина      (11) <===");

            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить продукт");
                    products.add(bookProductManager.createBookProduct());
                    dataManager.saveProduct(products);
                    break;
                case 2:
                    System.out.println("2. Добавить покупателя");
                    buyers.add(buyerManager.newBuyer());
                    dataManager.saveBuyers(buyers);
                    break;
                case 3:
                    System.out.println("3. Список продуктов");
                    bookProductManager.printListBookProduct(products);
                    break;
                case 4:
                    System.out.println("4. Список покупателей");
                    buyerManager.printListBuyer(buyers);
                    break;
                case 5:
                    System.out.println("5. Купить товар");
                    historyBuyManager.BuyProduct(products, buyers);
                    shops.add(shopManagers.shopCashEveryTime());
                    dataManager.saveShopCash(shops);
                    historyBuys.add(historyBuyManager.createStoryList(products,buyers));
                    dataManager.saveHistories(historyBuys);
                    break;
                case 6:
                    System.out.println("6. История покупок в магазине");
                    historyBuyManager.printHistoryBuys(historyBuys);
                    break;
                case 7:
                    System.out.println("7. Пополнить счет");
                    buyerManager.Refill(buyers);
                    dataManager.saveBuyers(buyers);
                    break;
                case 8:
                    System.out.println("8. Посмотреть баланс");
                    buyerManager.PrintCash(buyers);
                    break;
                case 9:
                    System.out.println("9. Изменить данные о товаре");
                    this.products = bookProductManager.ProductChange(products);
                    dataManager.saveProduct(products);
                    break;
//                case 10:
//                    System.out.println("10. Удаление продукта");
//                    bookProduct.removeProduct();
//                    break;
                case 11:
                    System.out.println("11. Прибыль магазина");
                    shopManagers.ShopCashList(shops);

            }


        } while (repeat);
        System.out.println("============> Закрытие программы, пока! <================");

    }

}