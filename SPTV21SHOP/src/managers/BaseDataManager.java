package managers;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

import entity.Shop;
import interfaces.PersistenceData;
import java.util.List;

public class BaseDataManager implements PersistenceData {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTV21SHOPPU");
    private final EntityManager em = emf.createEntityManager();
    private final EntityTransaction tx = em.getTransaction();

    @Override
    public void saveProduct(List<Product> products) {
        tx.begin();
        for (int i=0; i<products.size();i++) {
            Product product = products.get(i);
            if (product.getId() == null) {
                em.persist(product);
            } else {
                em.merge(product);
            }
        }
        tx.commit();

    }

    @Override
    public List<Product> loadProdoct() {
        try {
            return em.createQuery("SELECT p FROM Product p")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void saveBuyers(List<Buyer> buyers) {
        tx.begin();
        for (int i = 0; i < buyers.size(); i++) {
            Buyer buyer = buyers.get(i);
            if(buyer.getId() == null){
                em.persist(buyer);
            }else{
                em.merge(buyer);
            }
        }
        tx.commit();
    }

    @Override
    public List<Buyer> loadBuyer() {
        try {
            return em.createQuery("SELECT b FROM Buyer b")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void saveHistories(List<HistoryBuy> historyBuys) {
        tx.begin();
        for (int i = 0; i < historyBuys.size(); i++) {
            HistoryBuy historyBuy = historyBuys.get(i);
            if(historyBuy.getId() == null){
                em.persist(historyBuy);
            }else{
                em.merge(historyBuy);
            }
        }
        tx.commit();

    }

    @Override
    public List<HistoryBuy> loadHistories() {
        try {
            return em.createQuery("SELECT h FROM HistoryBuy h")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void saveShopCash(List<Shop> shops) {
        tx.begin();
        for (int i = 0; i < shops.size(); i++) {
            Shop shop = shops.get(i);
            if(shop.getId() == null){
                em.persist(shop);
            }else{
                em.merge(shop);
            }
        }
        tx.commit();
    }

    @Override
    public List<Shop> loadShopCash() {
        try {
            return em.createQuery("SELECT s FROM Shop s")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


}