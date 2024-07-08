package com.heria.mapreduce.shangguigu.kv;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KVMapper extends Mapper<Text, Text, Text, LongWritable>{

    // 1 ����value
    LongWritable v = new LongWritable(1);

    @Override
    protected void map(Text key, Text value, Context context)
            throws IOException, InterruptedException {

// banzhang ni hao

        // 2 д��
        context.write(key, v);
    }
}

