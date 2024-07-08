package com.heria.mapreduce.shangguigu.sort.partition;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowCountAllSortMapper extends Mapper<LongWritable,Text, FlowBean,Text> {


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split("\t");

        FlowBean flowBean=new FlowBean(Long.parseLong(fields[1]),Long.parseLong(fields[2]));
        Text t=new Text();
        t.set(fields[0]);
        //以自定义序列化为key值，电话号码为value值传入Reduce
        context.write(flowBean,t);
    }
}
