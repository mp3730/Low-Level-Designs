package HotelManagementSystem.Model.Payment;

public class CashPayment implements Payment {

    @Override
    public boolean completePayment(double amount) {
        System.out.println("Paid by Cash: " + amount);
        return true;
    }
}
