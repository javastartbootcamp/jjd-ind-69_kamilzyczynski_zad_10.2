package pl.javastart.task.PhoneTask;

public class CardPhoneContract extends PhoneContract {
    private double balance;
    private double smsCost;
    private double mmsCost;
    private double callCost;

    public CardPhoneContract(double balance, double smsCost, double mmsCost, double callCost) {
        this.balance = balance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCost = callCost;
    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSmsCost() {
        return smsCost;
    }

    void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }

    public double getCallCost() {
        return callCost;
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

    void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    @Override
    public String toString() {
        return "Na koncie zostało: " + balance +
                " zł";
    }
}
