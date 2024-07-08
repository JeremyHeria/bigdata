package com.heria.mapreduce.shangguigu.sort.partition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class partiton extends Partitioner<FlowBean, Text> {
    @Override
    public int getPartition(FlowBean key, Text value, int numPartitions) {
        //按照手机号前三位排序
        String prePhone = value.toString().substring(0,3);
        int partition=4;
        // 2 判断是哪个省
        if ("136".equals(prePhone)) {
            partition = 0;
        }else if ("137".equals(prePhone)) {
            partition = 1;
        }else if ("138".equals(prePhone)) {
            partition = 2;
        }else if ("139".equals(prePhone)) {
            partition = 3;
        }

        return partition;
    }
}
