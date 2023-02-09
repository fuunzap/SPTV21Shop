package managers;


import entity.Buyer;
import entity.Shop;

import java.util.List;


public class ShopManagers {


    public Shop shopCashEveryTime(){
        int SummaProduct = HistoryBuyManager.TotalSumma;
        Shop shop = new Shop();
        shop.setCashShop(SummaProduct);
        return shop;
    }

    public void ShopCashList(List<Shop> shops) {
        for (int i = 0; i < shops.size(); i++) {
            System.out.printf("%d. Прибыль магазина c покупателя: %s%n"
                    , i + 1
                    , shops.get(i).getCashShop());
        }
        int sum = 0;
        for (int i = 0; i < shops.size(); i++) {
            sum = sum + shops.get(i).getCashShop();

        }
        System.out.print("Общая прибыль магазина: " + sum);

        System.out.println();
    }

}