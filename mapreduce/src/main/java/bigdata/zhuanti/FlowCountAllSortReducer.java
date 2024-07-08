package bigdata.zhuanti;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowCountAllSortReducer extends Reducer<Student, NullWritable, Student, NullWritable> {
    @Override
    public void reduce(Student key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
