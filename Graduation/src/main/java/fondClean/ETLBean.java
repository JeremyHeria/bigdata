package fondClean;//package fondClean;
//
//import java.io.DataInput;
//import java.io.DataOutput;
//import java.io.IOException;
//
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Writable;
//// 1 ʵ��writable�ӿ�
//public class ETLBean extends Text implements Writable{
//    //��ѯ����,���׽��,���׶Է�����
//    //�����ֶ�
//    private String BCard;
//    //���׽��
//    private Float JMoney;
//    //���׶Է�����
//    private String DCard;
////    //���״���
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
//    //2  �����л�ʱ����Ҫ������ÿղι��캯�������Ա�����
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
//    //3  д���л�����
//    @Override
//    public void write(DataOutput out) throws IOException {
//        out.writeUTF(BCard);
//        out.writeFloat(JMoney);
//        out.writeUTF(DCard);
//    }
//
//    //4 �����л�����
//    //5 �����л�������˳������д���л�������д˳�����һ��
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
