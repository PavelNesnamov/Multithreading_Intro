package ait.multti.task;

public class MyTaskExtends extends Thread{
    private String name;
    private int max;

    public MyTaskExtends(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {

        System.out.println(name + " task started");
        for (int i = 0; i < max; i++) {
            System.out.println("Task " + name + ", cont = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " task finished");
    }
}