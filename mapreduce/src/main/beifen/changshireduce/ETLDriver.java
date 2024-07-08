package fondClean;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ETLDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
//        args = new String[] {"H:/BIGDATA/0note/hadoop/3-mapreduce/Graduation/input/FinalFond.csv",
//                             "H:/BIGDATA/0note/hadoop/3-mapreduce/Graduation/output/Fond"};
//        // 1 获取配置信息以及封装任务
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //FileSystem fs = FileSystem.get(new URI("hdfs://192.168.72.148:9000"), conf, "root");
        FileInputFormat.setInputPaths(job,new Path("/Graduation/FinalFond.csv"));
        FileOutputFormat.setOutputPath(job,new Path("/Output/Fond25"));
        // 2 设置jar加载路径
        job.setJarByClass(ETLDriver.class);

        // 3 关联map
        job.setMapperClass(ETLMapper.class);
        job.setReducerClass(ETLReducer.class);
        job.setMapOutputKeyClass(ETLBean.class);
        job.setMapOutputValueClass(ETLBean.class);
        // 5 设置最终输出kv类型
        job.setOutputKeyClass(ETLBean.class);
        job.setOutputValueClass(ETLBean.class);

        //设置reducetask个数为2
//        job.setPartitionerClass(ETLPartition.class);
        job.setNumReduceTasks(0);
        // 6 设置输入和输出路径
        //FileInputFormat.setInputPaths(job, new Path(args[0]));
        //FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // 7 提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }

}