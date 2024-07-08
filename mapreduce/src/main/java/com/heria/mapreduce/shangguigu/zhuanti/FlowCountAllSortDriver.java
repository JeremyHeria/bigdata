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
        //实例化配置文件
        Configuration conf = new Configuration();
        //定义一个job任务
        Job job = Job.getInstance(conf);
        //配置job的信息
        job.setJarByClass(FlowCountAllSortDriver.class);
        //指定自定义的mapper、mapper的数据类型到job中
        job.setMapperClass(FlowCountAllSortMapper.class);
        job.setMapOutputKeyClass(Student.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setGroupingComparatorClass(StudentComparator.class);
        //指定自定义的reduce以及reduce的输出数据类型，总输出类型

        job.setReducerClass(FlowCountAllSortReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Student.class);



        //配置输入数据的路径，这一部分演示的在本地运行
        FileInputFormat.setInputPaths(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/input/zhuanti/1.txt"));

        //配置输出数据的路径
        FileOutputFormat.setOutputPath(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/zhuantisai/"));

//        FileInputFormat.addInputPath(job,new Path(args[0]));
//        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        //提交任务
        job.waitForCompletion(true);
    }
}
