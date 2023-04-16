package pl.javastart.task.phonetask;

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

    @Override
    public boolean sendSms() {
        if (balance - smsCost >= 0) {
            balance -= smsCost;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMms() {
        if (balance - mmsCost >= 0) {
            balance -= mmsCost;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int call(int seconds) {
        double totalCost = (callCost / 60.0) * seconds;
        if (balance >= totalCost) {
            balance = balance - totalCost;
            return seconds;
        } else {
            double interruptedCall = (60 * balance) / callCost;
            balance = balance - (callCost / 60) * interruptedCall;
            return (int) interruptedCall;
        }
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

    void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    @Override
    public String toString() {
        return "Na koncie zostało: " + balance +
                " zł";
    }
}
