package managers;

import entity.Buyer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BuyerManager {

    Scanner scanner;

    public BuyerManager() {
        scanner = new Scanner(System.in);
    }

    public Buyer newBuyer() {
        Buyer buyer = new Buyer();
        System.out.print("Введите имя покупателя: ");
        buyer.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию покупателя: ");
        buyer.setLastname(scanner.nextLine());
        System.out.print("Введите телефон покупателя: ");
        buyer.setPhone(scanner.nextLine());

        return buyer;
    }

    public void printListBuyer(List<Buyer> buyers)  {
        System.out.println("=====================================");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers.get(i).getFirstname()
                    , buyers.get(i).getLastname()
                    , buyers.get(i).getPhone());
        }
        System.out.println("=====================================");
    }

    public void Refill(List<Buyer> buyers) {
        System.out.println("=====================================");
        System.out.println("Выберите покупателя для зачисления на его счет денежных средств");
        System.out.println("=====================================");
        System.out.println("Список покупателей: ");

        printListBuyer(buyers);

        System.out.print("Введите индекс покупателя: ");
        int buyer = scanner.nextInt(); scanner.nextLine();
        System.out.println("=====================================");
        System.out.println("На данном счете в данный момент находиться: " + buyers.get(buyer-1).getCash());
        System.out.println("=====================================");
        System.out.print("Сколько денег желаете добавить на счет? : ");
        int addMoney = scanner.nextInt(); scanner.nextLine();
        int TotalMoney = buyers.get(buyer - 1).getCash() + addMoney;
        buyers.get(buyer - 1).setCash(TotalMoney);
        System.out.println("=====================================");
        System.out.println("Счет пополнен!");
        System.out.println("=====================================");
        System.out.println("Желаете ли вы увидеть сколько средств у вас на счету? (да/нет)");
        String balansView = scanner.nextLine();
        if (balansView.equals("да")) {
            System.out.println("=====================================");
            System.out.println("На счету на данный момент: " + buyers.get(buyer - 1).getCash());
            System.out.println("=====================================");
        }
    }
    public void PrintCash(List<Buyer> buyers){
        System.out.println("список покупателей");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i + 1
                    , buyers.get(i).getFirstname()
                    , buyers.get(i).getLastname()
                    , buyers.get(i).getPhone());
        }
        System.out.print("Введите индекс покупателя, чтобы посмотреть его баланс: ");
        int balans = scanner.nextInt(); scanner.nextLine();
        int printCash = buyers.get(balans - 1).getCash();
        System.out.println("=====================================");
        System.out.println("Баланс данного покупателя: " + printCash);
        System.out.println("=====================================");
    }
}