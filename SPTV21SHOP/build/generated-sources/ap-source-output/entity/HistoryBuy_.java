package entity;

import entity.Buyer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-02-09T18:10:54")
@StaticMetamodel(HistoryBuy.class)
public class HistoryBuy_ { 

    public static volatile SingularAttribute<HistoryBuy, String> HistoryProductPrice;
    public static volatile SingularAttribute<HistoryBuy, Date> BuyOnProduct;
    public static volatile SingularAttribute<HistoryBuy, String> buyerLastNames;
    public static volatile SingularAttribute<HistoryBuy, String> HistoryProductName;
    public static volatile SingularAttribute<HistoryBuy, Long> id;
    public static volatile SingularAttribute<HistoryBuy, String> buyerPhones;
    public static volatile SingularAttribute<HistoryBuy, String> buyerNames;
    public static volatile SingularAttribute<HistoryBuy, String> HistoryProductQantity;
    public static volatile SingularAttribute<HistoryBuy, Buyer> buyer;

}