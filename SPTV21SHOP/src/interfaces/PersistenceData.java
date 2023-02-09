package interfaces;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;
import entity.Shop;

import java.io.Reader;
import java.util.List;

public interface PersistenceData {
    public void saveProduct(List<Product> products);
    public List<Product> loadProdoct();
    public void saveBuyers(List<Buyer> buyers);

    public List<Buyer> loadBuyer();

    public void saveHistories(List<HistoryBuy> historyBuys);
    public List<HistoryBuy> loadHistories();

    public void saveShopCash(List<Shop> shops);
    public List<Shop> loadShopCash();
}