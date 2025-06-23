package HotelManagementSystem.Model.Payment;

public class CreditCardPayment implements Payment{
    @Override
    public boolean completePayment(double amount) {
        System.out.println("Paid by Credit Card: " + amount);
        return true;
    }
}
