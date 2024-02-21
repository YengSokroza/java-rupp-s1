
interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}


class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }

    @Override
    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10;
            default:
                return 0.0;
        }
    }
}

class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double totalExpense = serviceExpense * (1 - customer.getServiceMemberDiscount())
                + productExpense * (1 - customer.getProductMemberDiscount());
        return totalExpense;
    }

    public void displayInfo() {
        System.out.println("Transaction Information:");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Total Expense: $" + getTotalExpense());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Kanika", "Premium");
        Sale sale = new Sale(customer, "2024-02-21");
        sale.setServiceExpense(100.0);
        sale.setProductExpense(50.0);
        sale.displayInfo();


        Customer customer3 = new Customer("Bora", "Gold");
        Sale sale3 = new Sale(customer3, "2024-02-13");
        sale3.setServiceExpense(100.0);
        sale3.setProductExpense(50.0);
        sale3.displayInfo();


        Customer customer4 = new Customer("Mina", "Silver");
        Sale sale4 = new Sale(customer4, "2024-02-01");
        sale4.setServiceExpense(100.0);
        sale4.setProductExpense(50.0);
        sale4.displayInfo();


        Customer customer2 = new Customer("Bora", "Normal");
        Sale sale2 = new Sale(customer2, "2024-01-23");
        sale2.setServiceExpense(100.0);
        sale2.setProductExpense(50.0);
        sale2.displayInfo();
    }
}

