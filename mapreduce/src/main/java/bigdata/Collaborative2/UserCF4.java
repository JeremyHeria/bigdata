package bigdata.Collaborative2;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;

public class UserCF4 extends Configured implements Tool {

    public static class Mapper4 extends
            Mapper<LongWritable, Text, Text, Text> {

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
            String [] tmp = values[0].split(" ");
            context.write(new Text(tmp[0]+"\t"+tmp[1]), new Text(values[1]));
        }
    }

    public static class Reducer4 extends
            Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            double up=0;double down=0;
            for(Text tmp:values)
            {
                String []tmp1 = tmp.toString().split(" ");
                up = up + Double.parseDouble(tmp1[0])*Double.parseDouble(tmp1[1]);
                down = down +Math.abs(Double.parseDouble(tmp1[0]));
            }
            double score = up/down;
            context.write(key, new Text(score+""));
        }
    }

    @Override
    public int run(String[] arg0) throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "UserCF2");

        job.setJarByClass(UserCF4.class);
        job.setMapperClass(Mapper4.class);
        job.setReducerClass(Reducer4.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(
                "hdfs://192.168.26.130:9000/userCF/tmp2"));
        Path table_path = new Path("hdfs://192.168.26.130:9000/userCF/score");
        FileSystem.get(conf).delete(table_path, true);
        FileOutputFormat.setOutputPath(job, table_path);
        job.waitForCompletion(true);
        return 0;
    }
}

