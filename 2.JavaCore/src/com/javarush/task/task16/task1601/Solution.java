package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {
    class TestThread implements Runnable{

        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }
    public void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }
}
