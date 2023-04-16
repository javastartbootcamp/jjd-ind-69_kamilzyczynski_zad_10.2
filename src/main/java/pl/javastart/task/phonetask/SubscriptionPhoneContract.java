package pl.javastart.task.phonetask;

public class SubscriptionPhoneContract extends PhoneContract {
    private double subscriptionCost;

    public SubscriptionPhoneContract(double subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    public double getSubscriptionCost() {
        return subscriptionCost;
    }

    void setSubscriptionCost(double subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    @Override
    public boolean sendSms() {
        return true;
    }

    @Override
    public boolean sendMms() {
        return true;
    }

    @Override
    public int call(int seconds) {
        return seconds;
    }

    @Override
    public String toString() {
        return "Rachunek do zapłaty: " + subscriptionCost + " zł";
    }
}
