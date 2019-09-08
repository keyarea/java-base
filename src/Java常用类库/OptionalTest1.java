package Java常用类库;


import 包的定义及使用.message.Message;

import java.util.Optional;

interface IMessage{
    public String getContent();
}

class MessageUtil {
    private MessageUtil(){}

    public static Optional<IMessage> getMessage() {
        return Optional.ofNullable(null);
    }

    public static void useMessage(IMessage msg) {
        System.out.println(msg.getContent());
    }
}

class MessageImpl implements IMessage{
    @Override
    public String getContent() {
        return "www.qipo.net";
    }
}

public class OptionalTest1 {
    public static void main(String[] args) {
        IMessage temp = MessageUtil.getMessage().orElse(new MessageImpl());
        MessageUtil.useMessage(temp);
    }
}
