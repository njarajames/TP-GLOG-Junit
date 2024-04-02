package fr.emse.test;

public class Money implements IMoney {

    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    @Override
    public IMoney add(IMoney m) {
        if (m instanceof Money && ((Money) m).currency().equals(currency())) {
            return new Money(amount() + ((Money) m).amount(), currency());
        } else {
            MoneyBag result = new MoneyBag();
            result.appendMoney(this);
            result.appendMoney((Money) m);
            return result;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;
        return fAmount == other.fAmount && fCurrency.equals(other.fCurrency);
    }


}