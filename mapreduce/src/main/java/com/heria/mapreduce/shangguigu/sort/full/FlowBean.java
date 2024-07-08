package com.heria.mapreduce.shangguigu.sort.full;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean> {

    //alt + insert �Զ�����get/set()
    //�ϴ�������������Ϊ��������
    private long upFlow;
    //��������
    private long downFlow;
    //������
    private long sumFlow;

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownflow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumupFlow) {
        this.sumFlow = sumupFlow;
    }

    //�ղι������������Զ������л���Ҫ
    public FlowBean(){

    }
    //�Զ��幹����
    public FlowBean(long upFlow,long downFlow){
        this.upFlow=upFlow;
        this.downFlow=downFlow;
        this.sumFlow=upFlow+downFlow;


    }
    public void write(DataOutput out) throws IOException {
        out.writeLong(this.upFlow);
        out.writeLong(this.downFlow);
        out.writeLong(this.sumFlow);

    }

    public void readFields(DataInput in) throws IOException {

        this.upFlow = in.readLong();
        this.downFlow = in.readLong();
        this.sumFlow = in.readLong();
    }
    public String toString(){
        return this.upFlow+"\t"+this.downFlow+"\t"+this.sumFlow;
    }


    public int compareTo(FlowBean o) {
        // �������У��Ӵ�С
        return this.sumFlow > o.getSumFlow() ? -1 : 1;

    }
}

