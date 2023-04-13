package pl.javastart.task;

import pl.javastart.task.PhoneTask.CardPhoneContract;
import pl.javastart.task.PhoneTask.Phone;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new CardPhoneContract(0.2, .1, .2, 0.5));

        phone.printAccountState();

        phone.sendSms();
        phone.printAccountState();
    }
}
