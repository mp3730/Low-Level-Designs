package ATM;

//created this ATM LLD based on shreyansh jain's repo
// 1. State design pattern - for ATM states
// 2. Chain of responsibility - for cash dispenser/withdrawal
public class Main {
    public static void main(String[] args) {
        ATMController atmController = new ATMController();
        atmController.initialise();
        atmController.performOperations();
    }
}
