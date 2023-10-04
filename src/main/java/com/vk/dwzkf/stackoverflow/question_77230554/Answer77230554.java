package com.vk.dwzkf.stackoverflow.question_77230554;

/**
 * @author Roman Shageev
 * @since 04.10.2023
 */
public class Answer77230554 {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender(new MessagePublisher());
        messageSender.newMessage()
                .withDestination("dest")
                .withMessage("msg")
                .publish();
    }
}
