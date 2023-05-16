package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run()
        {
            try
            {
                for (int i = numSeconds; i >= 0; i--)
                {
                    Thread.sleep(1000);
                    if (i == 0)
                        System.out.print("Прервано");
                    else
                        System.out.print(i + " ");
                }
            }
            catch (InterruptedException e)
            {
                System.out.print("Марш!");
            }
        }
    }
}