package com.heria.mapreduce.shangguigu.wordcount;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
    int sum;
    IntWritable v = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
        sum=0;
        //1 累加求和
        for(IntWritable value : values) {
            sum+= value.get();
        }
        //2 写出
        v.set(sum);
        context.write(key,v);

    }

}