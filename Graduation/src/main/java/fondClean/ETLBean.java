package fondClean;//package fondClean;
//
//import java.io.DataInput;
//import java.io.DataOutput;
//import java.io.IOException;
//
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Writable;
//// 1 实现writable接口
//public class ETLBean extends Text implements Writable{
//    //查询卡号,交易金额,交易对方卡号
//    //定义字段
//    private String BCard;
//    //交易金额
//    private Float JMoney;
//    //交易对方卡号
//    private String DCard;
////    //交易次数
////    private int Number;
//
//
//    @Override
//    public String toString () {
//        return "ETLBean{" +
//                "BCard='" + BCard + '\'' +
//                ", JMoney=" + JMoney +
//                ", DCard='" + DCard + '\'' +
//                '}';
//    }
//
//    //2  反序列化时，需要反射调用空参构造函数，所以必须有
//    public ETLBean() {
//        super();
//    }
//
//    public ETLBean (String BCard,Float JMoney,String DCard) {
//        super();
//        this.JMoney = JMoney;
////        this.Number = Number;
//        this.DCard = DCard;
//        this.BCard = BCard;
//    }
//
//    //3  写序列化方法
//    @Override
//    public void write(DataOutput out) throws IOException {
//        out.writeUTF(BCard);
//        out.writeFloat(JMoney);
//        out.writeUTF(DCard);
//    }
//
//    //4 反序列化方法
//    //5 反序列化方法读顺序必须和写序列化方法的写顺序必须一致
//    @Override
//    public void readFields(DataInput in) throws IOException {
//        this.BCard = in.readUTF();
//        this.JMoney = in.readFloat();
//        this.DCard = in.readUTF();
//    }
//
//    public void setBCard(String BCard) {
//        this.BCard = BCard;
//    }
//    public void setJMoney(Float JMoney) {
//        this.JMoney = JMoney;
//    }
//    public void setDCard(String DCard) {
//        this.DCard = DCard;
//    }
//}
//
