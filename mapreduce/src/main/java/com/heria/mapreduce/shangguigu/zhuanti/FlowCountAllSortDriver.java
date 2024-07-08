package com.heria.mapreduce.shangguigu.zhuanti;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowCountAllSortDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //ʵ���������ļ�
        Configuration conf = new Configuration();
        //����һ��job����
        Job job = Job.getInstance(conf);
        //����job����Ϣ
        job.setJarByClass(FlowCountAllSortDriver.class);
        //ָ���Զ����mapper��mapper���������͵�job��
        job.setMapperClass(FlowCountAllSortMapper.class);
        job.setMapOutputKeyClass(Student.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setGroupingComparatorClass(StudentComparator.class);
        //ָ���Զ����reduce�Լ�reduce������������ͣ����������

        job.setReducerClass(FlowCountAllSortReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Student.class);



        //�����������ݵ�·������һ������ʾ���ڱ�������
        FileInputFormat.setInputPaths(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/input/zhuanti/1.txt"));

        //����������ݵ�·��
        FileOutputFormat.setOutputPath(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/zhuantisai/"));

//        FileInputFormat.addInputPath(job,new Path(args[0]));
//        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //�ύ����
        job.waitForCompletion(true);
    }
}
