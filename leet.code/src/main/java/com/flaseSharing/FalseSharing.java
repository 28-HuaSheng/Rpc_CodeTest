package com.flaseSharing;


public class FalseSharing implements Runnable{

    private final long ITERATOR = 500l * 1000l * 100l;

    private int arrayindex;

    private static ObjectNoPadding[] objectArrays;


    public FalseSharing (final int arrayindex){
        this.arrayindex = arrayindex;
    }

    public static void main(String[] args) throws InterruptedException{
        for(int i=1;i<20;i++){
            System.gc();
            final long start = System.currentTimeMillis();
            test(i);
            System.out.println("Thread num "+i+" duration = " + (System.currentTimeMillis() - start));
        }
    }

    private static void test(int threadNums) throws InterruptedException{
        objectArrays = new ObjectNoPadding[threadNums];
        Thread[] threads = new Thread[threadNums];
        for(int i=0;i<objectArrays.length;i++){
            objectArrays[i] = new ObjectNoPadding();
        }
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(new FalseSharing(i));
        }
        for(Thread thread:threads){
            thread.start();
        }
        for(Thread thread:threads){
            thread.join();
        }

    }


    @Override
    public void run() {
        long i = ITERATOR+1;
        while (0 != --i){
            objectArrays[arrayindex].value = 10l;
        }

    }

    /**
     *
     */
    private final static class ObjectNoPadding{
        protected volatile long value = 0l;


    }

    private final static class ObjectWithPadding{
        protected long p1, p2, p3, p4, p5, p6, p7;
        protected volatile long value = 0L;
        protected long p9, p10, p11, p12, p13, p14;
        protected long p15;
    }
}
