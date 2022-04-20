//package com.cube;
//
//import java.util.concurrent.TimeUnit;
//
//public class CubeTask extends Thread{
//    private String params;
//
//    public CubeTask (String params) {
//        this.params = params;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Starting CubeTask");
//        long timeout = 5;
//        try {
//            TimeUnit.SECONDS.sleep(timeout);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Cube Task is done");
//    }
//
//    public String getResult() {
//        return "response: " + this.params;
//    }
//}
