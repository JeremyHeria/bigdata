package fondClean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
        if(  jmoney>= 100  && fields[13].contains(SOF) && ETL_contain(fields[0]) && ETL_contain(fields[5])){
            String direction = "转出";
            direction= new String(direction.getBytes("gbk"),"utf-8");
            if(fields[3].contains(direction)) {
            //保留双方交易卡号、交易金额、交易余额、交易时间
                String time = fields[4].replaceAll("/", "-")+":00";
                k.set(fields[0]+","+fields[1]+","+fields[2]+","+fields[5]+","+time+","+1);
                //System.out.println(k);
                context.write(k, NullWritable.get()); }else{
                String time = fields[4].replaceAll("/", "-")+":00";
                //如果交易标志为"汇入"时，借贷标志设置为0
                k.set(fields[0]+","+fields[1]+","+fields[2]+","+fields[5]+","+time+","+0);
                context.write(k, NullWritable.get()); } } }
    private boolean ETL_contain(String k){
        if (k.contains("-") &&  k.contains("nan") && k.contains("E+")){
            return false; }
            return true; }}



//static String TimeClean(String A){
//
//
//}