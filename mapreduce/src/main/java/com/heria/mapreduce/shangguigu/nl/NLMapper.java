package com.heria.mapreduce.shangguigu.nl;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NLMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

    private Text k = new Text();
    private LongWritable v = new LongWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context)	throws IOException, InterruptedException {

        // 1 ��ȡһ��
        String line = value.toString();

        // 2 �и�
        String[] splited = line.split(" ");

        // 3 ѭ��д��
        for (int i = 0; i < splited.length; i++) {

            k.set(splited[i]);

            context.write(k, v);
        }
    }
}
