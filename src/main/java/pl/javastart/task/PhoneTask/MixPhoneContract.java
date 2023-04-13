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
    public boolean sendSms() {
        if (smsLimit > 0) {
            smsLimit--;
            return true;
        } else if (getBalance() - getSmsCost() >= 0) {
            setBalance(getBalance() - getSmsCost());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendMms() {
        if (mmsLimit > 0) {
            mmsLimit--;
            return true;
        } else if (getBalance() - getMmsCost() >= 0) {
            setBalance(getBalance() - getMmsCost());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int call(int seconds) {
        int callDuration = 0;
        if ((callLimit / 60.0) >= seconds) {
            callDuration += seconds;
            callLimit -= seconds * 60.0;
        } else if (seconds > callDuration / 60.0) {
            callDuration += callLimit / 60.0;
            callLimit = 0;
        }

        if (getBalance() >= (getCallCost() / 60.0) * seconds && callLimit == 0) {
            callDuration += seconds;
            setBalance(getBalance() - (getCallCost() / 60) * seconds);
        } else if (getBalance() < (getCallCost() / 60.0) * seconds) {
            double interruptedCall = (60.0 * getBalance()) / getCallCost();
            callDuration += interruptedCall;
            setBalance(getBalance() - (getCallCost() / 60.0) * interruptedCall);
        }
        return callDuration;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Pozostało darmowych SMS: " + smsLimit + "\n" +
                "Pozostało darmowych MMS: " + mmsLimit + "\n" + "Pozostało darmowych minut rozmów: " + callLimit;
    }
}
