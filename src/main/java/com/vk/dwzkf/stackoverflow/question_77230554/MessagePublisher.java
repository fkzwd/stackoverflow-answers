package com.vk.dwzkf.stackoverflow.question_77230554;

/**
 * @author Roman Shageev
 * @since 04.10.2023
 */
public class MessagePublisher {
    public void publish(Message message) {
        System.out.println(
                String.format(
                        "Publish message for:%s, message:%s",
                        message.getDestination(),
                        message.getMessage()
                )
        );
    }
}
