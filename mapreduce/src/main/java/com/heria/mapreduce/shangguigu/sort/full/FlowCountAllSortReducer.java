package com.heria.mapreduce.shangguigu.sort.full;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountAllSortReducer extends Reducer<FlowBean,Text,Text,FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //虽然values只有一个元素，但还是需要用到循环
        //所以每次循环输出一次
        for(Text value:values){
            context.write(value,key);
        }
    }
}
