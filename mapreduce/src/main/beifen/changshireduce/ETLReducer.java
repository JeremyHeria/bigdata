package fondClean;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ETLReducer extends Reducer<Text, ETLBean,Text,ETLBean> {
    @Override
    protected void reduce(Text k, Iterable<ETLBean> values, Context context) throws IOException, InterruptedException {
        Float sumMoney = 0f;
        int number = 0;


        for(ETLBean etlBean : values){
            sumMoney = sumMoney + etlBean.getJMoney();
            number = number + etlBean.getNumber();
        }
        ETLBean resultBean = new ETLBean(sumMoney,number);
        context.write(k, resultBean);
    }

}
