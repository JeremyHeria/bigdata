package com.heria.mapreduce.shangguigu.sort.partition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class partiton extends Partitioner<FlowBean, Text> {
    @Override
    public int getPartition(FlowBean key, Text value, int numPartitions) {
        //�����ֻ���ǰ��λ����
        String prePhone = value.toString().substring(0,3);
        int partition=4;
        // 2 �ж����ĸ�ʡ
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
