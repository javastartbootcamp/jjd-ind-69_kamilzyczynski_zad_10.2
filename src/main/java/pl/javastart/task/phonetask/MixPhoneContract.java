package pl.javastart.task.phonetask;

public class MixPhoneContract extends CardPhoneContract {
    private int smsLimit;
    private int mmsLimit;
    private double callLimit;

    public MixPhoneContract(double balance, double smsCost, double mmsCost, double callCost, int smsLimit, int mmsLimit, double callLimit) {
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

    public double getCallLimit() {
        return callLimit;
    }

    void setCallLimit(double callLimit) {
        this.callLimit = callLimit;
    }

    @Override
    public boolean sendSms() {
        if (smsLimit > 0) {
            smsLimit--;
            return true;
        }
        return super.sendSms();
    }

    @Override
    public boolean sendMms() {
        if (mmsLimit > 0) {
            mmsLimit--;
            return true;
        }
        return super.sendMms();
    }

    @Override
    public int call(int seconds) {
        int callDuration = 0;
        if ((callLimit * 60.0) >= seconds) {
            callDuration += seconds;
            callLimit -= seconds / 60.0;
        } else if (seconds > callLimit * 60.0) {
            callDuration += callLimit * 60.0;
            callLimit = 0;
        }

        if (callLimit == 0 && seconds > callDuration) {
            callDuration += super.call(seconds - callDuration);
        }
        return callDuration;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Pozostało darmowych SMS: " + smsLimit + "\n" +
                "Pozostało darmowych MMS: " + mmsLimit + "\n" + "Pozostało darmowych minut rozmów: " + callLimit;
    }
}
