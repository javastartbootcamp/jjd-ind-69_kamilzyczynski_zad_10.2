package pl.javastart.task.phonetask;

public abstract class PhoneContract {
    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract int call(int seconds);

}
