package com.flaseSharing;

public class CacheLine {

    public static void main(String[] args) {
        long[][] array = new long[1024*1024][];
        for(int i=0;i<1024*1024;i++){
            long[] ready = new long[8];
            for(int j=0;j<8;j++){
                ready[j]=1l;
            }
            array[i] = ready;
        }



        //使用cacheLine
        long sum ;
        long loopTimes = 0l;
        long start1 = System.currentTimeMillis();
        for(int i=0;i<1024*1024;i++){
            for(int j=0;j<8;j++){
                sum = array[i][j];
                loopTimes++;
            }
        }
        System.out.println("times:"+(System.currentTimeMillis()-start1)+",循环次数："+loopTimes);

        //不使用cacheLine
        long sum2;
        long loopTimes2 = 0l; //循环次数
        long start2 = System.currentTimeMillis();
        for(int i=0;i<8;i++){
            for(int j=0;j<1024*1024;j++){
                sum2 = array[j][i];
                loopTimes2++;
            }
        }
        System.out.println("times2:"+(System.currentTimeMillis()-start2)+",循环次数："+loopTimes2);

        /**
         * 性能测试大概差一倍
         */



    }
}
