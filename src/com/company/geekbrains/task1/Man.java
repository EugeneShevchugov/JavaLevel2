package com.company.geekbrains.task1;

public class Man implements Taskable {
    private int maxJump;
    private int maxRun;

    public Man(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        if (maxJump < obstacle.getSize()) {
            System.out.println("Человек не смог перепрыгнуть через стену");
            return false;
        }
        else {
            System.out.println("Человек смог перепрыгнуть через стену");
            return true;
        }
    }

    @Override
    public boolean run(Obstacle obstacle) {
        if (maxRun < obstacle.getSize()) {
            System.out.println("Человек не смог пробежать такое расстояние по беговой дорожке");
            return false;
        }
        else {
            System.out.println("Человек пробежался по беговой дорожке");
            return true;
        }
    }
}
