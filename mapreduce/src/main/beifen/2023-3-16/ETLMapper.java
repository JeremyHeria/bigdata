package fondClean;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//map阶段
//KEYIN输入数据的value
//KEYOUT输出数据的key类型
//VALUEOUT 输出的value类型
public class ETLMapper extends Mapper<LongWritable,Text,Text, NullWritable> {
//    ETLBean k = new ETLBean();
//    ETLBean v = new ETLBean();
    @Override
    protected void map(LongWritable key, Text value,Context context)
            throws IOException, InterruptedException {
        // 1 获取一行

        String line = value.toString();
        Text k = new Text();
        // 2 筛选对统计结果影响较小的数据
        String[] fields = line.split(",");
        Float jmoney = Float.valueOf(fields[1]);
        String SOF = "成功";
        SOF = new String(SOF.getBytes("gbk"),"utf-8");
        if(  jmoney>= 100  && fields[13].contains(SOF)){
            //统一资金交易方向
            String direction = "转出";
            direction= new String(direction.getBytes("gbk"),"utf-8");
            if(fields[3].contains(direction)) {
            //保留双方交易卡号、交易金额、交易ip与mac地址
                k.set(fields[0]+","+fields[1]+","+fields[5]+","+fields[9]+","+fields[10]+","+fields[11]+","+fields[12]);
                //System.out.println(k);
                context.write(k, NullWritable.get());
            }else{
                //如果交易标志为"汇入"时，更换两张卡号、IP、MAC的位置
                k.set(fields[5]+","+fields[1]+","+fields[0]+","+fields[11]+","+fields[12]+","+fields[9]+","+fields[10]);
                context.write(k, NullWritable.get());
            }
       }
    }
}


//static String TimeClean(String A){
//
//
//}