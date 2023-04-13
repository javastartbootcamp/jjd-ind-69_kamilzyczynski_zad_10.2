package pl.javastart.task.PhoneTask;

public abstract class PhoneContract {

    public abstract double getBalance();

    abstract void setBalance(double balance);

    public abstract double getSmsCost();

    public abstract double getMmsCost();

    public abstract double getCallCost();

    public abstract int getSmsLimit();

    abstract void setSmsLimit(int smsLimit);

    public abstract int getMmsLimit();

    abstract void setMmsLimit(int mmsLimit);

    public abstract int getCallLimit();

    abstract void setCallLimit(int callLimit);
}
