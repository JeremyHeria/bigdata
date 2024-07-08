package fondClean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
// 1 实现writable接口
public class ETLBean extends Text implements Writable{
    //查询卡号,交易金额,交易余额,借贷标志,交易时间,交易对方卡号,交易摘要,交易网点名称,交易流水号,本方IP地址,本方MAC地址,对方IP地址,对方MAC地址
    //定义字段
    private String BCard;
    //交易金额
    private Float JMoney;
    //交易对方卡号
    private String DCard;
//    //交易次数
//    private int Number;


    //2  反序列化时，需要反射调用空参构造函数，所以必须有
    public ETLBean() {
        super();
    }

    public ETLBean (String BCard,Float JMoney,String DCard) {
        super();
        this.JMoney = JMoney;
//        this.Number = Number;
        this.DCard = DCard;
        this.BCard = BCard;
    }

    //3  写序列化方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(BCard);
        out.writeFloat(JMoney);
        out.writeUTF(DCard);
    }

    //4 反序列化方法
    //5 反序列化方法读顺序必须和写序列化方法的写顺序必须一致
    @Override
    public void readFields(DataInput in) throws IOException {
        this.BCard = in.readUTF();
        this.JMoney = in.readFloat();
        this.DCard = in.readUTF();
    }

    // 6 编写toString方法，方便后续打印到文本
    @Override
    public String toString() {
        return BCard + "," + JMoney  + ","  + DCard;}
    public String getBCard() {
        return BCard;
    }
    public void setBCard(String BCard) {
        this.BCard = BCard;
    }
//    public Float getJMoney() {
//        return JMoney;
//    }
    public Float getJMoney() {
    return JMoney;
}
    public void setJMoney(Float JMoney) {
        this.JMoney = JMoney;
    }
    public String getDCard() {
        return DCard;
    }
    public void setDCard(String DCard) {
        this.DCard = DCard;
    }
}

