package com.heria.mapreduce.shangguigu.flowsum;
import java.io.DataInput;
import java.io.DataOutput;

import java.io.IOException;
import org.apache.hadoop.io.Writable;

// 1 ʵ��writable�ӿ�
public class FlowBean implements Writable{

	private long upFlow;
	private long downFlow;
	private long sumFlow;

	//2  �����л�ʱ����Ҫ������ÿղι��캯�������Ա�����
	public FlowBean() {
		super();
	}

	public FlowBean(long upFlow, long downFlow) {
		super();
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		this.sumFlow = upFlow + downFlow;
	}

	//3  д���л�����
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(downFlow);
		out.writeLong(sumFlow);
	}

	//4 �����л�����
	//5 �����л�������˳������д���л�������д˳�����һ��
	@Override
	public void readFields(DataInput in) throws IOException {
		this.upFlow  = in.readLong();
		this.downFlow = in.readLong();
		this.sumFlow = in.readLong();
	}

	// 6 ��дtoString���������������ӡ���ı�
	@Override
	public String toString() {
		return upFlow + "\t" + downFlow + "\t" + sumFlow;
	}

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDownFlow() {
		return downFlow;
	}

	public void setDownFlow(long downFlow) {
		this.downFlow = downFlow;
	}

	public long getSumFlow() {
		return sumFlow;
	}

	public void setSumFlow(long sumFlow) {
		this.sumFlow = sumFlow;
	}

	public void set(long downFlow2, long upFlow2) {
		upFlow = upFlow2;
		downFlow=downFlow2;
		sumFlow=upFlow2+downFlow2;
	}
}
