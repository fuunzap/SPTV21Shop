package managers;

import entity.Buyer;
import entity.HistoryBuy;
import entity.Product;

import entity.Shop;
import interfaces.PersistenceData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager implements PersistenceData {
    private final String PRODUCT_FILE = "files/MyProducts";
    private final String BUYER_FILE = "files/MyBuyers";
    private final String HISTORIES_FILE = "files/MyHistories";
    private final String CASHSHOP_FILE = "files/MyCashShop";

    public FileDataManager() {
        File file = new File("files");
        file.mkdirs();
    }

    @Override
    public void saveProduct(List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    @Override
    public List<Product> loadProdoct() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PRODUCT_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return products;    }

    @Override
    public void saveBuyers(List<Buyer> buyers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BUYER_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(buyers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyReaders");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    @Override
    public List<Buyer> loadBuyer() {
        List<Buyer> buyers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(BUYER_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            buyers = (List<Buyer>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyReaders");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return buyers;    }

    @Override
    public void saveHistories(List<HistoryBuy> historyBuys) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(HISTORIES_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(historyBuys);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyHistories");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    @Override
    public List<HistoryBuy> loadHistories() {
        List<HistoryBuy> histories = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(HISTORIES_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            histories = (List<HistoryBuy>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyHistories");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return histories;
    }

    @Override
    public void saveShopCash(List<Shop> shops) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CASHSHOP_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(shops);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла CASHSHOP_FILE");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    @Override
    public List<Shop> loadShopCash() {
        List<Shop> shops = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(CASHSHOP_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            shops = (List<Shop>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла CASHSHOP_FILE");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return shops;
    }


}