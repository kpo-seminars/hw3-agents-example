package ru.hse.agent;

import lombok.Getter;

/**
 * представляет сообщение, которое может обработать агент
 */
public class Message {
    private static int messagesCount = 0;

    @Getter
    private final int id;

    public Message() {
        this.id = ++messagesCount;
    }
}
