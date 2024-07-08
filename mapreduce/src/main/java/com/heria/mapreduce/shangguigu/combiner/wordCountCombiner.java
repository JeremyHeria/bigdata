package com.heria.mapreduce.shangguigu.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class wordCountCombiner extends Reducer<Text , IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
       int sum=0;
        IntWritable v = new IntWritable();
        //1.累加求和
        for (IntWritable value:values) {
            sum+=value.get();
        }

        v.set(sum);
        //2写出
        context.write(key, v);
    }
}
