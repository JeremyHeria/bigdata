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
        //ʵ���������ļ�
        Configuration conf = new Configuration();
        //����һ��job����
        Job job = Job.getInstance(conf);
        //����job����Ϣ
        job.setJarByClass(FlowCountAllSortDriver.class);
        //ָ���Զ����mapper��mapper���������͵�job��
        job.setMapperClass(FlowCountAllSortMapper.class);
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        //ָ���Զ����reduce�Լ�reduce������������ͣ����������

        job.setReducerClass(FlowCountAllSortReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);


        //�����������ݵ�·������һ������ʾ���ڱ�������
        FileInputFormat.setInputPaths(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/output2/part-r-00000"));

        //����������ݵ�·��
        FileOutputFormat.setOutputPath(job,new Path("H:/BIGDATA/0note/hadoop/3-mapreduce/output/sort/allsort"));

        /*//�����������ݵ�·��,��һ�����Ǵ���ϴ�����Ⱥ����
        FileInputFormat.setInputPaths(job,new Path(args[0]));

        //����������ݵ�·��
        FileOutputFormat.setOutputPath(job,new Path(args[1]));*/

        //�ύ����
        job.waitForCompletion(true);
    }
}
