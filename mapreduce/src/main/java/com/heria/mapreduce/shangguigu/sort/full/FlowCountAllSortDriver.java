package com.heria.mapreduce.shangguigu.sort.full;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
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
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        //指定自定义的reduce以及reduce的输出数据类型，总输出类型

        job.setReducerClass(FlowCountAllSortReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);


        //配置输入数据的路径，这一部分演示的在本地运行
        FileInputFormat.setInputPaths(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/output2/part-r-00000"));

        //配置输出数据的路径
        FileOutputFormat.setOutputPath(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/sort/allsort"));

        /*//配置输入数据的路径,这一部分是打包上传到集群运行
        FileInputFormat.setInputPaths(job,new Path(args[0]));

        //配置输出数据的路径
        FileOutputFormat.setOutputPath(job,new Path(args[1]));*/

        //提交任务
        job.waitForCompletion(true);
    }
}
