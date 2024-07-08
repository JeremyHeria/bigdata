package bigdata.Collaborative2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class UserCF1 extends Configured implements Tool {

    public static class Mapper1 extends
            Mapper<LongWritable, Text, Text, Text> {

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
            context.write(new Text(values[1]), new Text(values[0]+"\t"+values[2]));
        }
    }

    public static class Reducer1 extends
            Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            List<String> tmp_list = new ArrayList<String>();
            for(Text tmp:values)
            {
                tmp_list.add(tmp.toString());
            }
            for(int i=0;i<tmp_list.size();i++)
            {
                String []tmp1 =tmp_list.get(i).split("\t");
                int down1 = Integer.parseInt(tmp1[1]) * Integer.parseInt(tmp1[1]);
                for(int j=0;j<tmp_list.size();j++)
                {
                    String []tmp2 =tmp_list.get(j).split("\t");
                    int up = Integer.parseInt(tmp1[1]) * Integer.parseInt(tmp2[1]);
                    int down2 = Integer.parseInt(tmp2[1]) * Integer.parseInt(tmp2[1]);
                    context.write(new Text(tmp1[0]+" "+tmp2[0]), new Text(up+" "+down1+" "+down2));
                }
            }

        }
    }

    @Override
    public int run(String[] arg0) throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "UserCF1");

        job.setJarByClass(UserCF1.class);
        job.setMapperClass(Mapper1.class);
        job.setReducerClass(Reducer1.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(
                "hdfs://192.168.26.130:9000/userCF/train"));
        Path table_path = new Path("hdfs://192.168.26.130:9000/userCF/tmp");
        FileSystem.get(conf).delete(table_path, true);
        FileOutputFormat.setOutputPath(job, table_path);
        job.waitForCompletion(true);
        return 0;
    }
}

