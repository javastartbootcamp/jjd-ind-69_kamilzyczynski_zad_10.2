package pl.javastart.task;

import pl.javastart.task.phonetask.CardPhoneContract;
import pl.javastart.task.phonetask.MixPhoneContract;
import pl.javastart.task.phonetask.Phone;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixPhoneContract(0.25, .1, .2, 0.5, 1, 1, 1));

        phone.printAccountState();
        phone.sendSms();
        phone.call(90);
        phone.printAccountState();
    }
}
