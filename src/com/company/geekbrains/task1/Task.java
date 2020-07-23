package com.company.geekbrains.task1;

import java.util.Random;

public class Task {
    public static void doRunAndJump() {
        Taskable[] taskables = new Taskable[3];
        taskables[0] = new Cat(5, 200);
        taskables[1] = new Man(3, 400);
        taskables[2] = new Robot(10, 10);
        Obstacle[] obstacles = new Obstacle[2];
        fillObstaclesByRandom(obstacles, 4, 150);
        for (int i = 0; i < taskables.length; i++) {
            if (obstacles[0] instanceof Wall) {
                if (taskables[i].jump(obstacles[0])) {
                    (taskables[i]).run(obstacles[1]);
                }
            }
            else {
                if (taskables[i].run(obstacles[0])) {
                    taskables[i].jump(obstacles[1]);
                }
            }
        }
    }

    private static void fillObstaclesByRandom(Obstacle[] obstacles, int wallSize, int roadSize) {
        Random random = new Random();
        for (int i = 0; i < obstacles.length; i++) {
            int value = random.nextInt(2);
            if (value == 0) {
                obstacles[i] = new Wall(wallSize);
            }
            else {
                obstacles[i] = new RaceTrack(roadSize);
            }
        }
    }
}
