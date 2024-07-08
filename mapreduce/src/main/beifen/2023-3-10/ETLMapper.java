ETLBean.java
        ETLDriver.java
        ETLMapper.javapackage fondClean;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//map阶段
//KEYIN输入数据的value
//KEYOUT输出数据的key类型
//VALUEOUT 输出的value类型
public class ETLMapper extends Mapper<LongWritable,Text,ETLBean, NullWritable> {
    ETLBean k = new ETLBean();
    @Override
    protected void map(LongWritable key, Text value,Context context)
            throws IOException, InterruptedException {
        // 1 获取一行

        String line = value.toString();

        // 2 筛选对统计结果影响较小的数据
        String[] fields = line.split(",");
        Float jmoney = Float.valueOf(fields[1]);
        String SOF = "成功";
        SOF = new String(SOF.getBytes("gbk"),"utf-8");
        if(  jmoney>= 100  && fields[13].contains(SOF)){
            //统一资金交易方向
            String direction = "转出";
            direction= new String(direction.getBytes("gbk"),"utf-8");
            System.out.println(direction);
            System.out.println(fields[3]);
            if(fields[3].contains(direction)) {
                System.out.println(direction);
                k.setBCard(fields[0]);
                k.setJMoney(Float.valueOf(fields[1]));
                k.setCredit(fields[3]);
                k.setTradeTime(fields[4]);
                k.setDCard(fields[5]);
                k.setB_IP(fields[9]);
                k.setB_MAC(fields[10]);
                k.setD_IP(fields[11]);
                k.setD_MAC(fields[12]);
                k.setSOF(fields[13]);
                context.write(k, NullWritable.get());
            }else{
                //如果交易标志为"汇入"时，更换两张卡号、IP、MAC的位置
                k.setBCard(fields[5]);
                k.setJMoney(Float.valueOf(fields[1]));
                k.setCredit(direction);
                k.setTradeTime(fields[4]);
                k.setDCard(fields[0]);
                k.setB_IP(fields[11]);
                k.setB_MAC(fields[12]);
                k.setD_IP(fields[9]);
                k.setD_MAC(fields[10]);
                k.setSOF(fields[13]);
                context.write(k, NullWritable.get());
            }
       }
    }
}


//static String TimeClean(String A){
//
//
//}