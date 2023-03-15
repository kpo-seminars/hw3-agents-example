package ru.hse;

import lombok.extern.slf4j.Slf4j;
import ru.hse.agent.Agent;
import ru.hse.agent.AgentRepository;
import ru.hse.agent.random.RandomAgent;
import ru.hse.agent.random.RandomMessage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Так создаем агентов и запускаем
        RandomAgent agent1 = new RandomAgent();
        RandomAgent agent2 = new RandomAgent();
        Agent.start(agent1);
        Agent.start(agent2);


        for (int i = 0; i < 15; i++) {
            // Можно выбрать агента из всех доступных
            // Не стесняйтесь дополнять класс AgentRepository своими методами, которые вам удобны
            List<RandomAgent> agents = AgentRepository.findByType(RandomAgent.class);
            RandomAgent selected = agents.get(ThreadLocalRandom.current().nextInt(agents.size()));

            // так шлем сообщения конкретному агенту
            selected.registerMessage(new RandomMessage(100, 1000));



            Thread.sleep(100);
        }

        // Так можем завершить работу агентов
        Agent.stop(agent1);
        Agent.stop(agent2);
    }
}