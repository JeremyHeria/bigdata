package bigdata.startstation.paixu;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordcountMapper extends Mapper<LongWritable, Text, tongji, Text>{

    tongji k = new tongji();
    Text v = new Text();
    @Override
    protected void map(LongWritable key, Text value,Context context)
            throws IOException, InterruptedException {
        //��ȡһ��
        String line = value.toString();
        //�и��
        String[] fields = line.split("\t");
        // 3 ��װ����
        String danci = fields[0];
        long number = Long.parseLong(fields[1]);
        k.setNumber(number);
        v.set(danci);
        context.write(k, v);
    }
}
