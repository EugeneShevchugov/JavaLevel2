package com.company.geekbrains.task1;

public class Task {
    public static void doRunAndJump() {
        Taskable[] taskables = new Taskable[3];
        taskables[0] = new Cat(5, 200);
        taskables[1] = new Man(3, 400);
        taskables[2] = new Robot(10, 10 );
        Wall wall = new Wall(4);
        RaceTrack raceTrack = new RaceTrack(150);
        for (int i = 0; i < taskables.length; i++) {
            if (taskables[i].jump(wall)) {
                taskables[i].run(raceTrack);
            }
        }
    }
}
