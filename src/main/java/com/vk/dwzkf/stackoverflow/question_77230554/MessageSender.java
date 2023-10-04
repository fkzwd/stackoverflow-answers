package com.vk.dwzkf.stackoverflow.question_77230554;

import lombok.RequiredArgsConstructor;

/**
 * @author Roman Shageev
 * @since 04.10.2023
 */
@RequiredArgsConstructor
public class MessageSender {
    private final MessagePublisher messagePublisher;

    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender(new MessagePublisher());
        messageSender.newMessage()
                .destination("dest")
                .message("msg")
                .publish();
    }   

    public MessageBuilder0 newMessage() {
        return new MessageBuilder0();
    }

    public class MessageBuilder0 extends Message.MessageBuilder {
        public void publish() {
            messagePublisher.publish(build());
        }
    }
}
