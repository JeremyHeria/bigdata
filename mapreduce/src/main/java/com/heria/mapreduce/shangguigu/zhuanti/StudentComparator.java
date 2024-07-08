package com.heria.mapreduce.shangguigu.zhuanti;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class StudentComparator extends WritableComparator {
    protected StudentComparator(){
        super(Student.class,true);
    }

    @Override
    //只求每个班级的最大值
    public int compare(WritableComparable a,WritableComparable b){
        Student aBean = (Student) a;
        Student bBean = (Student) b;
        int result;
        if( aBean.getClassname() > bBean.getClassname()){
            result = 1;
        }else if (aBean.getClassname() < bBean.getClassname()){
            result = -1;
        }else {
            result = 0;
        }
        return result;
    }
}
