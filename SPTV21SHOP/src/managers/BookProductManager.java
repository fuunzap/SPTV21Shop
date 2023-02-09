package managers;

import entity.Product;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookProductManager {

    Scanner scanner;
    File fileNames = new File("Список продуктов.txt");

    public BookProductManager() {
        scanner = new Scanner(System.in);
    }

    public Product createBookProduct() {
        System.out.print("Введите название продукта: ");
        String productName = scanner.nextLine();
        System.out.print("Введите количество продуктов: ");
        String quantity = scanner.nextLine();
        System.out.print("Введите цену продукта: ");
        String price = scanner.nextLine();
        Product product = createProduct(productName, Integer.parseInt(quantity), new Integer(price));
        return product;
    }

    public Product createProduct(String productName, int quantity, int price) {
        Product product = new Product();
        product.setTitle(productName);
        product.setQuantity(quantity);
        product.setPrice(price);

        return product;
    }


    public void printListBookProduct(List<Product> products) {

        System.out.println("=====================================");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. | Название: %s | Кол-во: %s | Цена: %s%n"
                    , i + 1
                    , products.get(i).getTitle()
                    , products.get(i).getQuantity()
                    , products.get(i).getPrice());
        }
    }


    public List<Product> ProductChange(List<Product> products) {
        System.out.println("=====================================");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. Название продукта: %s Количество: %s Цена продукта: %s%n"
                    , i + 1
                    , products.get(i).getTitle()
                    , products.get(i).getQuantity()
                    , products.get(i).getPrice());
        }
        System.out.println("=====================================");
        System.out.print("Выберите номер продукта для редактирования: ");
        int ProductNumberValues = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Наименование продукта: ");
        System.out.println(products.get(ProductNumberValues - 1).getTitle());
        System.out.print("Изменить название продукта ? (да/нет)");
        String edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое название продукта: ");
            products.get(ProductNumberValues - 1).setTitle(scanner.nextLine());
        }
        System.out.print("Изменить цену продукта: ");
        System.out.println(products.get(ProductNumberValues - 1).getPrice());
        System.out.print("Изменить цену продукта? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите новое цену продукта: ");
            products.get(ProductNumberValues - 1).setPrice(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.print("Количество товара: ");
        System.out.println(products.get(ProductNumberValues - 1).getQuantity());
        System.out.print("Изменить количество данного товара на складе? (да/нет)");
        edit = scanner.nextLine();
        if (edit.equals("да")) {
            System.out.print("Введите другое количество книги: ");
            products.get(ProductNumberValues - 1).setQuantity(scanner.nextInt());
            scanner.nextLine();
        }
        return products;
    }
}