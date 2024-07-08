package com.heria.mapreduce.shangguigu.sort.full;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountAllSortReducer extends Reducer<FlowBean,Text,Text,FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //��Ȼvaluesֻ��һ��Ԫ�أ���������Ҫ�õ�ѭ��
        //����ÿ��ѭ�����һ��
        for(Text value:values){
            context.write(value,key);
        }
    }
}
