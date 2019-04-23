package DesignMode.工厂模式;

interface Sender{
    public void send();
}

class MailSender implements Sender{

    @Override
    public void send(){
        System.out.println("this is a MailSender!!");
    }
}

class SmsSender implements  Sender{

    @Override
    public void send(){
        System.out.println("this is a SmsSender!!!");
    }
}

interface Provider{
    public Sender produce();
}

class SmsSenderFactory implements Provider{

    @Override
    public Sender produce(){
        return new SmsSender();
    }
}

class MailSenderFactory implements Provider{

    @Override
    public Sender produce(){
        return new MailSender();
    }
}


public class Test {
    public static void main(String[] args){
        Provider provider = new MailSenderFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
