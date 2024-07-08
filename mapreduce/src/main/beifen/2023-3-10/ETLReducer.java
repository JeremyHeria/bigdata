//package fondClean;
//
//import org.apache.hadoop.io.NullWritable;
//import org.apache.hadoop.mapreduce.Reducer;
//
//import java.io.IOException;
//
//public class ETLReducer extends Reducer<ETLBean, NullWritable,ETLBean,NullWritable> {
//    @Override
//    protected void reduce(ETLBean k, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
//        //只输出一次，每一组的数据是重复的，只输出一次来达到去重的效果
//        context.write(k,NullWritable.get());
//    }
//
//}
