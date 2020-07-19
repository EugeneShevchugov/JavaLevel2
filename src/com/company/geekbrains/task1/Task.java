package com.company.geekbrains.task1;

public class Task {
    public static void doRunAndJump() {
        Jumpable[] jumpables = new Jumpable[3];
        jumpables[0] = new Cat(5, 200);
        jumpables[1] = new Man(3, 400);
        jumpables[2] = new Robot(10, 10 );
        Wall wall = new Wall(4);
        RaceTrack raceTrack = new RaceTrack(150);
        for (int i = 0; i < jumpables.length; i++) {
            if (jumpables[i].jump(wall)) {
                ((Runable) jumpables[i]).run(raceTrack);
            }
        }
    }
}
