package com.heria.mapreduce.shangguigu.kv;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueLineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class KVDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args=new String[]{"h:/BIGDATA/0note/hadoop/3-mapreduce/input/kv.txt", "h:/BIGDATA/0note/hadoop/3-mapreduce/output/kvoutput"};
        Configuration conf = new Configuration();
        // �����и��
        conf.set(KeyValueLineRecordReader.KEY_VALUE_SEPERATOR, " ");
        // 1 ��ȡjob����
        Job job = Job.getInstance(conf);

        // 2 ����jar��λ�ã�����mapper��reducer
        job.setJarByClass(KVDriver.class);
        job.setMapperClass(KVMapper.class);
        job.setReducerClass(KVReducer.class);

        // 3 ����map���kv����
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        // 4 �����������kv����
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 5 ���������������·��
        FileInputFormat.setInputPaths(job, new Path(args[0]));

        // ���������ʽ
        job.setInputFormatClass(KeyValueTextInputFormat.class);

        // 6 �����������·��
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 7 �ύjob
        job.waitForCompletion(true);
    }
}
