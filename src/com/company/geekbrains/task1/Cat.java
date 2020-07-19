package com.company.geekbrains.task1;

public class Cat implements Runable, Jumpable {
    private int maxJump;
    private int maxRun;

    public Cat(int maxJump, int maxRun) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public boolean jump(Wall wall) {
        if (maxJump < wall.getHigh()) {
            System.out.println("Кот не смог перепрыгнуть через стену");
            return false;
        }
        else {
            System.out.println("Кот смог перепрыгнуть через стену");
            return true;
        }
    }

    @Override
    public boolean run(RaceTrack raceTrack) {
        if (maxRun < raceTrack.getLength()) {
            System.out.println("Кот не смог пробежать такое расстояние по беговой дорожке");
            return false;
        }
        else {
            System.out.println("Кот пробежался по беговой дорожке");
            return true;
        }
    }
}
