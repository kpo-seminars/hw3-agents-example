package ru.hse.agent.random;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.hse.agent.Message;

@Data
@AllArgsConstructor
public class RandomMessage extends Message {
    private int min;
    private int max;
}
