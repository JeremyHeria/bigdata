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
//        //ֻ���һ�Σ�ÿһ����������ظ��ģ�ֻ���һ�����ﵽȥ�ص�Ч��
//        context.write(k,NullWritable.get());
//    }
//
//}
