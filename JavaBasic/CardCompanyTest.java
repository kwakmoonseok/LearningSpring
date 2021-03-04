package JavaBasic;

class CardCompany {
    private static CardCompany instance = new CardCompany();

    private CardCompany() {

    }

    public static CardCompany getInstance() {
        if (instance == null) {
            instance = new CardCompany();
        }
        return instance;
    }

    public Card createCard() {
        Card card = new Card();
        card.cardNum = ++Card.basicNum;
        return card;
    }
}

class Card {
    static int basicNum = 10000;
    int cardNum;

    public int getCardNumber() {
        return cardNum;
    }
}

public class CardCompanyTest {
    public static void main(String[] args) {
        CardCompany company = CardCompany.getInstance();

        Card myCard = company.createCard();
        Card yourCard = company.createCard();

        System.out.println(myCard.getCardNumber());
        System.out.println(yourCard.getCardNumber());
    }


}
