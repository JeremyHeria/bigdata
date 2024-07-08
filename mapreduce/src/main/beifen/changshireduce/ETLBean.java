package fondClean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
// 1 ʵ��writable�ӿ�
public class ETLBean implements Writable{
    //��ѯ����,���׽��,�������,�����־,����ʱ��,���׶Է�����,����ժҪ,������������,������ˮ��,����IP��ַ,����MAC��ַ,�Է�IP��ַ,�Է�MAC��ַ
    //�����ֶ�
    private String BCard;
    //���׽��
    private Float JMoney;
    //�����־
    private String Credit;
    //���׶Է�����
    private String DCard;
    //���׳ɹ���־
    private String SOF;
    //���״���
    private int Number;


    //2  �����л�ʱ����Ҫ������ÿղι��캯�������Ա�����
    public ETLBean() {
        super();
    }

    public ETLBean (Float JMoney,int Number) {
        super();
        this.JMoney = JMoney;
        this.Number = Number;

    }

    //3  д���л�����
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(BCard);
        out.writeFloat(JMoney);
        out.writeUTF(Credit);
        out.writeUTF(DCard);
        out.writeUTF(SOF);
        out.writeInt(Number);
    }

    //4 �����л�����
    //5 �����л�������˳������д���л�������д˳�����һ��
    @Override
    public void readFields(DataInput in) throws IOException {
        this.BCard = in.readUTF();
        this.JMoney = in.readFloat();
        this.Credit = in.readUTF();
        this.DCard = in.readUTF();
        this.SOF = in.readUTF();
        this.Number = in.readInt();
    }

    // 6 ��дtoString���������������ӡ���ı�
    @Override
    public String toString() {
        return BCard + "," + JMoney  + ","  + DCard + ","  + Number;
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
    public void setDCard(String DCard) {
        this.DCard = DCard;
    }
    public int getNumber() {
        return Number;
    }
    public void setNumber(int Number) {
        this.Number = Number;
    }


}

