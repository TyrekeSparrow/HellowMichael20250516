package com.michael.hellomichael.loop;

public class FaceThread extends Thread{
    private final Object mLock = new Object();



    private volatile boolean isTerminated = false;





    @Override
    public void run() {
        synchronized (mLock) {
            while (isTerminated) {
                doWork();
            }
            try {
                mLock.wait(0L, 0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mLock.notifyAll();
        }
    }

    private boolean isWorking;

    private void doWork() {
        // get task
        // run task



        // TODO













    }

    public void submitTask() {


    }

    public void shutdown() {
        isTerminated = true;
    }











}
