package fondClean;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
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
        FileInputFormat.setInputPaths(job,new Path("/Graduation/FinalFund.csv"));
        FileOutputFormat.setOutputPath(job,new Path("/Fund"));
        // 2 设置jar加载路径
        job.setJarByClass(ETLDriver.class);
        // 3 关联map
        job.setMapperClass(ETLMapper.class);
        // 5 设置最终输出kv类型
        job.setReducerClass(ETLReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        // 7 提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }

}