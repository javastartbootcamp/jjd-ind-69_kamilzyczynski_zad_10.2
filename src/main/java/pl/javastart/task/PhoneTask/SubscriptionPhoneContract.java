package pl.javastart.task.PhoneTask;

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
    public double getBalance() {
        return Double.MAX_VALUE;
    }

    @Override
    void setBalance(double balance) {

    }

    @Override
    public double getSmsCost() {
        return 0;
    }

    @Override
    public double getMmsCost() {
        return 0;
    }

    @Override
    public double getCallCost() {
        return 0;
    }

    @Override
    public int getSmsLimit() {
        return 0;
    }

    @Override
    void setSmsLimit(int smsLimit) {

    }

    @Override
    public int getMmsLimit() {
        return 0;
    }

    @Override
    void setMmsLimit(int mmsLimit) {

    }

    @Override
    public int getCallLimit() {
        return 0;
    }

    @Override
    void setCallLimit(int callLimit) {

    }

    @Override
    public String toString() {
        return "Rachunek do zapłaty: " + subscriptionCost + " zł";
    }
}
