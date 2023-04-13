package pl.javastart.task.PhoneTask;

public abstract class PhoneContract {
    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract int call(int seconds);

}
