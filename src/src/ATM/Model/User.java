package ATM.Model;

public class User {
    private BankAccount bankAccount;
    private Card card;

    public User(BankAccount bankAccount, Card card){
        this.bankAccount = bankAccount;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
