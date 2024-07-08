package bigdata.startstation.paixu;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordcountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args = new String[] {"h:/BIGDATA/0note/hadoop/3-mapreduce/output/startstation/huizong/part-r-00000","h:/BIGDATA/0note/hadoop/3-mapreduce/output/startstation/paixu"};
        Configuration conf = new Configuration();
        //��ȡjob
        Job job = Job.getInstance(conf);
        //����jar��
        job.setJarByClass(WordcountDriver.class);
        //����mapper��reducer
        job.setMapperClass(WordcountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        //map�����k��v
        job.setMapOutputKeyClass(tongji.class);
        job.setMapOutputValueClass(Text.class);
        //�������kv
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(tongji.class);
        //��������·��
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //�ύjob
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);
    }

}
