package bigdata.startstation.huizong;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//map阶段
//KEYIN输入数据的value
//KEYOUT输出数据的key类型
//VALUEOUT 输出的value类型
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    Text k = new Text();
    IntWritable v = new IntWritable(1);
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        
        // 2 切割
        String[] words = line.split(",");



        String x=words[3];
        k.set(x);

        context.write(k, v);



    }
}