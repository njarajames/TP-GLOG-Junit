package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {

    private Vector<Money> fMonies = new Vector<>();

    public MoneyBag(Money... monies) {
        for (Money m : monies) {
            appendMoney(m);
        }
    }

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }


    public void appendMoney(Money m) {
        if (fMonies.isEmpty()) {
            fMonies.add(m);
        } else {
            int i = 0;
            while (i < fMonies.size() && !fMonies.get(i).currency().equals(m.currency())) {
                i++;
            }
            if (i >= fMonies.size()) {
                fMonies.add(m);
            } else {
                Money existingMoney = fMonies.get(i);
                fMonies.set(i, new Money(existingMoney.amount() + m.amount(), m.currency()));
            }
        }
    }

    @Override
    public IMoney add(IMoney m) {
        MoneyBag result = new MoneyBag();
        for (Money money : fMonies) {
            result.appendMoney(money);
        }
        if (m instanceof Money) {
            result.appendMoney((Money) m);
        } else if (m instanceof MoneyBag) {
            MoneyBag otherBag = (MoneyBag) m;
            for (Money money : otherBag.fMonies) {
                result.appendMoney(money);
            }
        }

        if (result.fMonies.size() == 1) {
            return result.fMonies.get(0);
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MoneyBag other = (MoneyBag) obj;
        if (fMonies.size() != other.fMonies.size()) {
            return false;
        }
        for (int i = 0; i < fMonies.size(); i++) {
            Money thisMoney = fMonies.get(i);
            Money otherMoney = other.fMonies.get(i);
            if (!thisMoney.equals(otherMoney)) {
                return false;
            }
        }
        return true;
    }
}