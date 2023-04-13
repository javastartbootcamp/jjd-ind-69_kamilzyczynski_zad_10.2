package pl.javastart.task.PhoneTask;

public class MixPhoneContract extends CardPhoneContract {
    private int smsLimit;
    private int mmsLimit;
    private int callLimit;

    public MixPhoneContract(double balance, double smsCost, double mmsCost, double callCost, int smsLimit, int mmsLimit, int callLimit) {
        super(balance, smsCost, mmsCost, callCost);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
    }

    public int getSmsLimit() {
        return smsLimit;
    }

    void setSmsLimit(int smsLimit) {
        this.smsLimit = smsLimit;
    }

    public int getMmsLimit() {
        return mmsLimit;
    }

    void setMmsLimit(int mmsLimit) {
        this.mmsLimit = mmsLimit;
    }

    public int getCallLimit() {
        return callLimit;
    }

    void setCallLimit(int callLimit) {
        this.callLimit = callLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Pozostało darmowych SMS: " + smsLimit + "\n" +
                "Pozostało darmowych MMS: " + mmsLimit + "\n" + "Pozostało darmowych minut rozmów: " + callLimit;
    }
}
