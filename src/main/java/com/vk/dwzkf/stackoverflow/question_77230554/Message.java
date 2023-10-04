package com.vk.dwzkf.stackoverflow.question_77230554;

import lombok.*;

/**
 * @author Roman Shageev
 * @since 04.10.2023
 */
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private String message;
    private String destination;

    public static class MessageBuilder {
        public void publish() {

        }
    }
}
