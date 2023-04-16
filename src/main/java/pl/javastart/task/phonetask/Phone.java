package pl.javastart.task.phonetask;

public class Phone {
    private int callSeconds;
    private int smsSent;
    private int mmsSent;
    private PhoneContract phoneContract;

    public Phone(PhoneContract phoneContract) {
        this.phoneContract = phoneContract;
    }

    public PhoneContract getPhoneContract() {
        return phoneContract;
    }

    public void setPhoneContract(PhoneContract phoneContract) {
        this.phoneContract = phoneContract;
    }

    public void sendSms() {
        if (phoneContract.sendSms()) {
            System.out.println("Wysłano SMS");
            smsSent++;
        } else {
            System.out.println("Nie udało się wysłać SMS");
        }
    }

    public void call(int seconds) {
        int callDuration = phoneContract.call(seconds);

        if (callDuration > 0) {
            System.out.println("Rozmowa trwała " + callDuration + " sekund");
            callSeconds += callDuration;
        } else {
            System.out.println("Nie udało się nawiązać połączenia");
        }
    }

    public void sendMms() {
        if (phoneContract.sendMms()) {
            System.out.println("Wysłano MMS");
            mmsSent++;
        } else {
            System.out.println("Nie udało się wysłać MMS");
        }
    }

    public void printAccountState() {
        System.out.println("Wysłanych SMSów: " + smsSent);
        System.out.println("Wysłanych MMSów: " + mmsSent);
        System.out.println("Liczba sekund rozmowy: " + callSeconds);
        System.out.println(phoneContract);
    }
}
