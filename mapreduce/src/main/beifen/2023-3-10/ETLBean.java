package fondClean;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
// 1 实现writable接口
public class ETLBean implements Writable{
    //查询卡号,交易金额,交易余额,借贷标志,交易时间,交易对方卡号,交易摘要,交易网点名称,交易流水号,本方IP地址,本方MAC地址,对方IP地址,对方MAC地址
    //定义字段
    private String BCard;
    //交易金额
    private Float JMoney;
    //借贷标志
    private String Credit;
    //交易时间
    private String TradeTime;
    //交易对方卡号
    private String DCard;
    //交易成功标志
    private String SOF;
    //本方IP地址
    private String B_IP;
    //本方MAC地址
    private String B_MAC;
    //对方IP地址
    private String D_IP;
    //对方MAC地址
    private String D_MAC;

    //2  反序列化时，需要反射调用空参构造函数，所以必须有
    public ETLBean() {
        super();
    }

    public ETLBean (String BCard, Float JMoney, String Credit, String TradeTime, String DCard,
                    String SOF, String B_IP, String B_MAC, String D_IP,String D_MAC) {
        super();
        this.BCard = BCard;
        this.JMoney = JMoney;
        this.Credit = Credit;
        this.TradeTime = TradeTime;
        this.DCard = DCard;
        this.B_IP = B_IP;
        this.B_MAC = B_MAC;
        this.D_IP = D_IP;
        this.D_MAC = D_MAC;
        this.SOF = SOF;

    }

    //3  写序列化方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(BCard);
        out.writeFloat(JMoney);
        out.writeUTF(Credit);
        out.writeUTF(TradeTime);
        out.writeUTF(DCard);
        out.writeUTF(B_IP);
        out.writeUTF(B_MAC);
        out.writeUTF(D_IP);
        out.writeUTF(D_MAC);
        out.writeUTF(SOF);
    }

    //4 反序列化方法
    //5 反序列化方法读顺序必须和写序列化方法的写顺序必须一致
    @Override
    public void readFields(DataInput in) throws IOException {
        this.BCard = in.readUTF();
        this.JMoney = in.readFloat();
        this.Credit = in.readUTF();
        this.TradeTime = in.readUTF();
        this.DCard = in.readUTF();
        this.SOF = in.readUTF();
        this.B_IP = in.readUTF();
        this.B_MAC = in.readUTF();
        this.D_IP = in.readUTF();
        this.D_MAC = in.readUTF();
    }

    // 6 编写toString方法，方便后续打印到文本
    @Override
    public String toString() {
        return BCard + "," + JMoney  + "," + TradeTime + "," + DCard +
                "," + B_IP + "," + B_MAC + "," + D_IP + "," + D_MAC + "," + SOF;
    }
    public String getBCard() {
        return BCard;
    }
    public void setBCard(String BCard) {
        this.BCard = BCard;
    }
    public Float getJMoney() {
        return JMoney;
    }
    public void setJMoney(Float JMoney) {
        this.JMoney = JMoney;
    }
    public String getCredit() {
        return Credit;
    }
    public void setCredit(String Credit) {
        this.Credit = Credit;
    }
    public String getTradeTime() {
        return TradeTime;
    }
    public void setTradeTime(String TradeTime) {
        this.TradeTime = TradeTime;
    }
    public String getDCard() {
        return DCard;
    }
    public void setDCard(String DCard) {
        this.DCard = DCard;
    }
    public String getSOF() {
        return SOF;
    }
    public void setSOF(String SOF) {
        this.SOF = SOF;
    }
    public String getB_IP() {
        return B_IP;
    }
    public void setB_IP(String B_IP) {
        this.B_IP = B_IP;
    }
    public String getB_MAC() {
        return B_MAC;
    }
    public void setB_MAC(String B_MAC) {
        this.B_MAC = B_MAC;
    }
    public String getD_IP() {
        return D_IP;
    }
    public void setD_IP(String D_IP) {
        this.D_IP = D_IP;
    }
    public String getD_MAC() {
        return D_MAC;
    }
    public void setD_MAC(String D_MAC) {
        this.D_MAC = D_MAC;
    }
}

