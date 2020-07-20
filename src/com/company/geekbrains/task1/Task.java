package com.company.geekbrains.task1;

import java.util.Random;

public class Task {
    public static void doRunAndJump() {
        Jumpable[] jumpables = new Jumpable[3];
        jumpables[0] = new Cat(5, 200);
        jumpables[1] = new Man(3, 400);
        jumpables[2] = new Robot(10, 10);
        Obstacle[] obstacles = new Obstacle[2];
        fillObstaclesByRandom(obstacles, 4, 150);
        for (int i = 0; i < jumpables.length; i++) {
            if (obstacles[0] instanceof Wall) {
                if (jumpables[i].jump(obstacles[0])) {
                    ((Runable) jumpables[i]).run(obstacles[1]);
                }
            }
            else {
                if (((Runable) jumpables[i]).run(obstacles[0])) {
                    jumpables[i].jump(obstacles[1]);
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
