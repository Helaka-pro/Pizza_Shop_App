import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
// Enumarators 
enum PizzaSize{
    SMALL, MEDIUM, LARGE
}
enum CrustType{
    THIN, REGULAR, SECRET
}
enum PizzaType{
    VEG, NON_VEG
}
enum PortionSize{
    LARGE, MEDIUM, SMALL
}
enum PaymentMethod{
    CASH, CARD
}
enum OrderStatus{
    NEW, PLACED, PREPARING, READY, COMPLETED, CANCELLED
}
interface Sellable{
    double getPrice();
}
// Parent class 
class MenuItem implements Sellable{
    protected String id;
    protected String name;
    protected double price;

    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String toString(){
        return id + " \t " + name + "\tRs." + price;
    }
}
// Child classs
class Pizza extends MenuItem{
    private PizzaSize size;
    private CrustType crust;
    private PizzaType type;
    

    public Pizza(String id, String name, double price, PizzaSize size, CrustType crust, PizzaType type) {
        super(id,name,price);
        this.size = size;
        this.crust = crust;
        this.type = type;
    }
    public String toString(){
        return id + " \t " + name + " \tRs." + price + " \t " + size + " | " + crust + " | " + type; 
    }
}

class Side extends MenuItem{
    private PortionSize size ;

    public Side(String id, String name, double price, PortionSize size){
        super(id, name, price);
        this.size = size;
    }
    public String toString(){
        return id + " \t " + name + " \t Rs." + price + " \t " + size;
    }
}
class Drink extends MenuItem{
    public Drink(String id, String name, double price){
        super(id, name, price);
    }
}
// Menu class 
class Menu{
    private ArrayList<MenuItem> items = new ArrayList<>();
    private HashMap<String, MenuItem> itemMap = new HashMap<>();
    private int idCounter = 1;

    public String generateId(){
        String id = "I" + String.format("%03d", idCounter);
        idCounter++;
        return id;
    }

    public void addItem(MenuItem item){
        items.add(item);
        itemMap.put(item.getId(), item);
    }

    public void removeItem(String id){
        MenuItem item = itemMap.get(id);
        if(item != null) {
            items.remove(item);
            itemMap.remove(id);
            System.out.println("Item removed");
        }else{
            System.out.println("Invalid Item ID");
        }   
    }
    public void displayMenu(){
        for (int i = 0; i < items.size(); i++){
            System.out.println(items.get(i));
        }
    }
     
    public MenuItem searchById(String id){
        return itemMap.get(id);
    }

    public void searchByName(){
        items.sort(Comparator.comparing(MenuItem::getName, String.CASE_INSENSITIVE_ORDER));
        displayMenu();
    }

    public void sortByPriceAsc(){
        items.sort(Comparator.comparing(MenuItem::getPrice));
        displayMenu();
    }

    public void sortByPriceDesc(){
        items.sort(Comparator.comparing(MenuItem::getPrice).reversed());
        displayMenu();
    }
}
// Order class
class OrderItem{
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public double getTotal(){
        return item.getPrice() * quantity;
    }
    public MenuItem getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }
    public String toString(){
        return item.getName() + " x " + quantity + " = Rs." + getTotal();
    }
}
class Order {
    private static int counter = 1000;
    private String orderId;
    private String customerName;
    private String notes;
    private ArrayList<OrderItem> items;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

    public Order(String customerName){
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.status = OrderStatus.NEW;
        this.orderId = "ORD" + (++counter);
    }

    public void addItem(MenuItem item){
        items.add(new OrderItem(item, 1));
    }

    public void addItem(MenuItem item, int quantity){
        items.add(new OrderItem(item, quantity));
    }

    public double getTotal(){
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getTotal();
        }
        return total;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public void setPayment(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public void displayOrder(){
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);

        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i));
        }
        if(notes != null && !notes.isEmpty()){
            System.out.println("Notes: " + notes);
        }
        System.out.println("Payment: " + paymentMethod);
        double subtotal = getTotal();
        double discount = 0;
        if(subtotal >3000){
            discount = subtotal * 0.10; // 10% discount
        }
        double finalTotal = subtotal - discount;
        System.out.println("Subtotal: Rs."+ subtotal);
        System.out.println("Discount: Rs."+ discount);
        System.out.println("Final Total: Rs." + finalTotal);
        System.out.println("Status: " + status);
    }
    public String toString(){
        return orderId + " - " + customerName + " - " + status;
    }
}


public class PizzaShopApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addItem(new Pizza(menu.generateId(), "Chicken Pizza", 1500,PizzaSize.MEDIUM, CrustType.REGULAR, PizzaType.NON_VEG));
        menu.addItem(new Pizza(menu.generateId(), "Veg Pizza", 1200,PizzaSize.SMALL, CrustType.THIN, PizzaType.VEG));
        menu.addItem(new Side(menu.generateId(), "Garlic Bread", 400, PortionSize.MEDIUM));
        menu.addItem(new Side(menu.generateId(), "Chicken Wings", 600, PortionSize.LARGE));

        menu.addItem(new Drink(menu.generateId(), "Soft Drinks", 300));
        menu.addItem(new Drink(menu.generateId(), "Bottled Water", 500));
        ArrayList<Order> allOrders = new ArrayList<>();
        int role = 0;
        while(role != 3){
            System.out.println(" ----- Pizza Sri Lanka ----- ");
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.println("\nSelect your role: ");

            role = sc.nextInt();
            sc.nextLine();
            if(role == 1){
                int managerChoice = 0;
                while(managerChoice != 10){
                    System.out.println("\n ----- Manager Menu ----- ");
                    System.out.println("1. Add Menu Item");
                    System.out.println("2. Remove Menu Item");
                    System.out.println("3. View Menu");
                    System.out.println("4. Search Menu Item");
                    System.out.println("5. Sort Menu By Name");
                    System.out.println("6. Sort Price Ascending");
                    System.out.println("7. Sort Price Descending");
                    System.out.println("8. View Orders");
                    System.out.println("9. Update Order Status");
                    System.out.println("10. Back");
                    System.out.println("\nSelect an option: ");
                    managerChoice = sc.nextInt();
                    sc.nextLine();
                    if(managerChoice == 1){
                        System.out.println(" ----- Add Menu Item ----- ");
                        System.out.println("Enter item type (1.Pizza/2.Side/3.Drink): ");
                        int itemType = sc.nextInt();
                        sc.nextLine();
                        if (itemType == 1){
                            String id = menu.generateId();
                            System.out.println("Enter Pizza Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Pizza Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Select Pizza Size (1.Small/2.Medium/3.Large): ");
                            int sizeChoice = sc.nextInt();
                            sc.nextLine();
                            if(sizeChoice == 1){
                                System.out.println("Select Crust Type (1.Thin/2.Regular/3.Secret): ");
                                int crustChoice = sc.nextInt();
                                sc.nextLine();
                                if(crustChoice == 1){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.THIN, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.THIN, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 2){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.REGULAR, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.REGULAR, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 3){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.SECRET, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.SMALL, CrustType.SECRET, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                            }
                            else if(sizeChoice == 2){
                                System.out.println("Select Crust Type (1.Thin/2.Regular/3.Secret): ");
                                int crustChoice = sc.nextInt();
                                sc.nextLine();
                                if(crustChoice == 1){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.THIN, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.THIN, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 2){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.REGULAR, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.REGULAR, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 3){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.SECRET, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.MEDIUM, CrustType.SECRET, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                            }
                            else if (sizeChoice == 3){
                                System.out.println("Select Crust Type (1.Thin/2.Regular/3.Secret): ");
                                int crustChoice = sc.nextInt();
                                sc.nextLine();
                                if(crustChoice == 1){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.THIN, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.THIN, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 2){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.REGULAR, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.REGULAR, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                                else if (crustChoice == 3){
                                    System.out.println("Select Pizza Type (1.VEG/2.NON_VEG): ");
                                    int typeChoice = sc.nextInt();
                                    sc.nextLine();
                                    if(typeChoice == 1){
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.SECRET, PizzaType.VEG));
                                        System.out.println("\nPizza added to menu");
                                    }else {
                                        menu.addItem(new Pizza(id, name, price, PizzaSize.LARGE, CrustType.SECRET, PizzaType.NON_VEG));
                                        System.out.println("\nPizza added to menu");
                                    }
                                }
                            }
                        }
                        else if (itemType == 2){
                            String id = menu.generateId();
                            System.out.println("Enter Side Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Side Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Select Portion Size (1.Small/2.Medium/3.Large): ");
                            int sizeChoice = sc.nextInt();
                            sc.nextLine();
                            if(sizeChoice == 1){
                                menu.addItem(new Side(id, name, price, PortionSize.SMALL));
                                System.out.println("\nSide added to menu");
                            }
                            else if(sizeChoice == 2){
                                menu.addItem(new Side(id, name, price, PortionSize.MEDIUM));
                                System.out.println("\nSide added to menu");
                            }
                            else if(sizeChoice == 3){
                                menu.addItem(new Side(id, name, price, PortionSize.LARGE));
                                System.out.println("\nSide added to menu");
                            }
                        }
                        else if (itemType ==3){
                            String id = menu.generateId();
                            System.out.println("Enter Drink Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Drink Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            menu.addItem(new Drink(id, name, price));
                            System.out.println("\nDrink added to menu");
                        }
                    }
                    else if(managerChoice == 2){
                        System.out.println("Enter ID to remove: ");
                        String id = sc.nextLine();
                        menu.removeItem(id);
                    }
                    else if(managerChoice ==3){
                        System.out.println("\n============================== MENU ==============================");
                        menu.displayMenu();
                        
                    }
                    else if(managerChoice == 4){
                        System.out.println("Enter ID to search: ");
                        String id = sc.nextLine();
                        MenuItem item = menu.searchById(id);
                        if(item != null){
                            System.out.println(item);
                        }else{
                            System.out.println("Item not found");
                        }
                    }
                    else if(managerChoice == 5){
                        System.out.println("\n---------------------------------------------------\n");
                        menu.searchByName();
                        System.out.println("\n---------------------------------------------------\n");
                    }
                    else if(managerChoice == 6){
                        System.out.println("\n---------------------------------------------------\n");
                        menu.sortByPriceAsc();
                        System.out.println("\n---------------------------------------------------\n");
                    }
                    else if(managerChoice == 7){
                        System.out.println("\n---------------------------------------------------\n");
                        menu.sortByPriceDesc();
                        System.out.println("\n---------------------------------------------------\n");
                    }
                    else if(managerChoice == 8){
                        if(allOrders.size() ==0){
                            System.out.println("No orders yet");
                        }else{
                            for(int i = 0; i < allOrders.size(); i++){
                                allOrders.get(i).displayOrder();
                                System.out.println("\n-----------------------------\n");
                            }
                        }
                    }
                    else if(managerChoice == 9){
                        if(allOrders.size() == 0 ){
                            System.out.println("No Orders available");
                        }else{
                            for(int i=0; i< allOrders.size(); i++){
                                System.out.println(i + " - " + allOrders.get(i));
                            }
                        }

                        System.out.println("Select order Index: ");
                        int index = sc.nextInt();
                        sc.nextLine();

                        if(index >= 0 && index < allOrders.size()){
                            Order selectOrder = allOrders.get(index);

                            System.out.println("Update Status: ");
                            System.out.println("1. PREPARING");
                            System.out.println("2. READY");
                            System.out.println("3. COMPLETED");

                            int status = sc.nextInt();
                            sc.nextLine();

                            if(status == 1){
                                selectOrder.setStatus(OrderStatus.PREPARING);
                            }
                            else if (status ==2){
                                selectOrder.setStatus(OrderStatus.READY);
                            }
                            else if (status == 3){
                                selectOrder.setStatus(OrderStatus.COMPLETED);
                            }
                            System.out.println("Order status updated!");
                        }else{
                            System.out.println("Invalid selection");
                        }
                    }
                }
            }else if(role == 2){
                int customerChoice = 0;
                while(customerChoice !=  5){
                    System.out.println("\n============================== Customer Menu ==============================");
                    System.out.println("\n============================== MENU ==============================");
                    menu.displayMenu();
                    System.out.println(" -----------------------------------------------------------------\n");
                    System.out.println("1. Search Menu Item");
                    System.out.println("2. Sort Price Ascending");
                    System.out.println("3. Sort Price Descending");
                    System.out.println("4. Create Order");
                    System.out.println("5. Back");
                    System.out.println("\nSelect an option: ");
                    customerChoice = sc.nextInt();
                    sc.nextLine();
                    if(customerChoice == 1){
                        menu.searchByName();
                    }
                    else if(customerChoice == 2){
                        menu.sortByPriceAsc();
                    }
                    else if(customerChoice == 3){
                        menu.sortByPriceDesc();
                    }
                    else if(customerChoice == 4){
                        System.out.println("\nIf the Order total is over 3000 a discount of 10% will be applied!!");
                        System.out.println("-----------------------------------------------------------------\n");
                        System.out.println("Enter customer name: ");
                        String name = sc.nextLine();
                        Order order = new Order(name);
                        int addMore = 1;
                        while(addMore == 1){
                            System.out.println("Enter item ID: ");
                            String id = sc.nextLine();
                            MenuItem item = menu.searchById(id);
                            if(item != null){
                                System.out.println("Enter quantity: ");
                                int qty = sc.nextInt();
                                sc.nextLine(); // To counter the Java Error
                                order.addItem(item,qty);
                            }else{
                                System.out.println("Item not found");
                            }
                            System.out.println("Add more? 1 = yes, 0 = no");
                            addMore = sc.nextInt();
                            sc.nextLine(); // To counter the Java Error
                        }
                        System.out.println("\nSelect payment method (1.Cash/2.Card): ");
                        int paymentChoice = sc.nextInt();
                        sc.nextLine();
                        if(paymentChoice == 1){
                            order.setPayment(PaymentMethod.CASH);
                        }else{
                            order.setPayment(PaymentMethod.CARD);
                        }
                        System.out.println("\nProcessing your order...");
                        System.out.println("Special notes: (1.Yes/2.NO)");
                        int noteChoice = sc.nextInt();
                        sc.nextLine();
                        if(noteChoice == 1){
                            System.out.println("Enter your special notes: ");
                            String notes = sc.nextLine();
                            order.setNotes(notes);
                            System.out.println("Note added to order");
                        }else{

                        }
                        System.out.println("Calculating the Total...");
                        // Setting Status of the Order
                        order.setStatus(OrderStatus.PLACED);
                        // Display Order Summary
                        System.out.println("\n ============================== Order Summary ==============================");
                        order.displayOrder();
                        // Add to all orders
                        allOrders.add(order);
                        System.out.println("\n Order placed successfully!");
                        System.out.println("-----------------------------------------------------------------------\n");
                    }
                }
            }
        }
        sc.close();
    }
}