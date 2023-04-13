package pl.javastart.task.PhoneTask;

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
        if (phoneContract.getSmsLimit() > 0) {
            System.out.println("SMS wysłany");
            phoneContract.setSmsLimit(phoneContract.getSmsLimit() - 1);
            smsSent++;
        } else if (phoneContract.getBalance() - phoneContract.getSmsCost() > 0) {
            System.out.println("SMS wysłany");
            phoneContract.setBalance(phoneContract.getBalance() - phoneContract.getSmsCost());
            smsSent++;
        } else {
            System.out.println("Nie udało się wysłać SMS");
        }
    }

    public void call(int seconds) {
        int callDuration = 0;
        if (phoneContract.getCallLimit() >= seconds) {
            callDuration += seconds;
            callSeconds += callDuration;
            phoneContract.setCallLimit(phoneContract.getCallLimit() - seconds);
            System.out.println("Rozmowa trwała " + seconds + " sekund");
        } else if (seconds > phoneContract.getCallLimit()) {
            callDuration += phoneContract.getCallLimit();
            callSeconds += callDuration;
            phoneContract.setCallLimit(0);
        }

        if (phoneContract.getBalance() >= (phoneContract.getCallCost() / 60) * seconds && phoneContract.getCallLimit() == 0) {
            callDuration += seconds;
            callSeconds += callDuration;
            phoneContract.setBalance(phoneContract.getBalance() - (phoneContract.getCallCost() / 60) * seconds);
            System.out.println("Rozmowa trwała " + callDuration + " sekund");
        } else if (phoneContract.getBalance() < (phoneContract.getCallCost() / 60) * seconds) {
            double interruptedCall = (60 * phoneContract.getBalance()) / phoneContract.getCallCost();
            callDuration += interruptedCall;
            phoneContract.setBalance(phoneContract.getBalance() - (phoneContract.getCallCost() / 60) * interruptedCall);
            System.out.println("Rozmowa trwała " + callDuration + " sekund");
            callSeconds += callDuration;
        } else {
            System.out.println("Nie udało się wykonać połączenia");
        }
    }

    public void sendMms() {
        if (phoneContract.getMmsLimit() > 0) {
            System.out.println("MMS wysłany");
            phoneContract.setMmsLimit(phoneContract.getMmsLimit() - 1);
            mmsSent++;
        } else if (phoneContract.getBalance() - phoneContract.getMmsCost() > 0) {
            System.out.println("MMS wysłany");
            phoneContract.setBalance(phoneContract.getBalance() - phoneContract.getMmsCost());
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
