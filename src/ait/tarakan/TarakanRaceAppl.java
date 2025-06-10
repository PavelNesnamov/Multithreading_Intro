package ait.tarakan;

import ait.tarakan.model.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TarakanRaceAppl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of tarakans:");
        int ntarakans = Integer.parseInt(br.readLine());
        System.out.println("Distance:");
        int distance = Integer.parseInt(br.readLine());
        Tarakan.setDistance(distance);
        Thread[] tarakans = startRace(ntarakans);
        waitFinish(tarakans);
        System.out.println("Congratulation to tarakan " + Tarakan.getWinner() + " (winner)");
    }

    private static void waitFinish(Thread[] tarakans) {
        for (int i = 0; i < tarakans.length; i++) {
            try {
                tarakans[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Thread[] startRace(int nTarakans) {
        Thread[] threads = new Thread[nTarakans];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Tarakan("Tarakan " + (i + 1)));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return threads;
    }
}
