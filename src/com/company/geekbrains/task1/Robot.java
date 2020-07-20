package com.company.geekbrains.task1;

public class Robot implements Runable, Jumpable {
    private int maxJump;
    private int maxRun;

    public Robot(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        if (maxJump < obstacle.getSize()) {
            System.out.println("Робот не смог перепрыгнуть через стену");
            return false;
        }
        else {
            System.out.println("Робот смог перепрыгнуть через стену");
            return true;
        }
    }

    @Override
    public boolean run(Obstacle obstacle) {
        if (maxRun < obstacle.getSize()) {
            System.out.println("Робот не смог пробежать такое расстояние по беговой дорожке");
            return false;
        }
        else {
            System.out.println("Робот пробежался по беговой дорожке");
            return true;
        }
    }
}
