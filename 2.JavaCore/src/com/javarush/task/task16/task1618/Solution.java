package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

import com.sun.webkit.ThemeClient;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread Thread = new TestThread();
        Thread.start();
        Thread.interrupt();

    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        @Override
        public void run() {

        }
    }
}