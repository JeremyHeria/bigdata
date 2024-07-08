package bigdata.startstation.paixu;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<tongji,Text,Text, tongji> {

    @Override
    protected void reduce(tongji key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(value,key);
        }

    }
}

