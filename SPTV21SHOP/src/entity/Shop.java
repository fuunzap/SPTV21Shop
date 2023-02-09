package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cashShop;


    public int getCashShop() {
        return cashShop;
    }

    public void setCashShop(int cashShop) {
        this.cashShop = cashShop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }








    @Override
    public String toString() {
        return "Shop{" +
                "cashShop=" + cashShop +
                '}';
    }
}