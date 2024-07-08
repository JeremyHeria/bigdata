package bigdata.zhuanti;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlowCountAllSortMapper extends Mapper<LongWritable,Text, Student, NullWritable> {
    Student k = new Student();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split("\t");

        k.setClassname(Integer.parseInt(fields[0]));
        k.setStuname(fields[1]);
        k.setScore(Integer.parseInt(fields[2]));
        context.write(k,NullWritable.get());
    }
}
