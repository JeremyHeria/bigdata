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


public class UserCF3 extends Configured implements Tool {

    public static class Mapper3 extends
            Mapper<LongWritable, Text, Text, Text> {

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            context.write(new Text(values[0]), new Text(values[1]+"\t"+values[2]));
        }
    }

    public static class Reducer3 extends
            Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            List<String> user_list = new ArrayList<String>();
            List<String> item_list = new ArrayList<String>();
            for(Text tmp:values)
            {
                String []tmp1=tmp.toString().split("\t");
                String []tmp2= tmp1[1].split(" ");

                if(tmp2.length==2)
                {
                    user_list.add(tmp1[0]+"\t"+tmp2[0]);
                }
                else
                {
                    item_list.add(tmp1[0]+"\t"+tmp2[0]);
                }
            }

            for(int i=0;i<user_list.size();i++)
            {
                String []tmp1 = user_list.get(i).split("\t");
                for(int j=0;j<item_list.size();j++)
                {
                    String []tmp2 = item_list.get(j).split("\t");
                    context.write(new Text(tmp1[0]+" "+tmp2[0]), new Text(tmp1[1]+" "+tmp2[1]));
                }
            }

        }
    }

    @Override
    public int run(String[] arg0) throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "UserCF1");

        job.setJarByClass(UserCF3.class);
        job.setMapperClass(Mapper3.class);
        job.setReducerClass(Reducer3.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(
                "hdfs://192.168.26.130:9000/userCF/train"));
        FileInputFormat.addInputPath(job, new Path(
                "hdfs://192.168.26.130:9000/userCF/simi"));
        Path table_path = new Path("hdfs://192.168.26.130:9000/userCF/tmp2");

        FileSystem.get(conf).delete(table_path, true);
        FileOutputFormat.setOutputPath(job, table_path);
        job.waitForCompletion(true);
        return 0;
    }
}

