package ru.hse.agent.random;

import lombok.extern.slf4j.Slf4j;
import ru.hse.agent.Agent;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomAgent extends Agent<RandomMessage> {
    @Override
    protected void proceed(RandomMessage message) throws InterruptedException {
        // Симулируем работу случайное количество времени
        Thread.sleep(ThreadLocalRandom.current()
                .nextInt(message.getMin(), message.getMax()));
    }
}
