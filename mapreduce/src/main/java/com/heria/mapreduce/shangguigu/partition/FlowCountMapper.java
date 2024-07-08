package com.heria.mapreduce.shangguigu.partition;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean>{

	FlowBean v = new FlowBean();
	Text k = new Text();

	@Override
	protected void map(LongWritable key, Text value, Context context)	throws IOException, InterruptedException {

		// 1 ��ȡһ��
		String line = value.toString();

		// 2 �и��ֶ�
		String[] fields = line.split("\t");

		// 3 ��װ����
		// ȡ���ֻ�����
		String phoneNum = fields[1];

		// ȡ��������������������
		long upFlow = Long.parseLong(fields[fields.length - 3]);
		long downFlow = Long.parseLong(fields[fields.length - 2]);

		k.set(phoneNum);
		v.set(downFlow, upFlow);

		// 4 д��
		context.write(k, v);
	}
}