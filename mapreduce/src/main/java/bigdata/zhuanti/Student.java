package bigdata.zhuanti;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Student implements WritableComparable<Student>{
    private int classname;
    private String stuname;
    private int score;


    public int getClassname() {
        return classname;
    }

    public void setClassname(int classname) {
        this.classname = classname;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(){
        super();
    }
    public Student(int classname,String stuname,int score){
        super();
        this.classname=classname;
        this.stuname=stuname;
        this.score=score;
    }
    @Override
    public int compareTo(Student o) {
        int result;
        //按照班级升序，再按成绩降序
        if(classname > o.getClassname()){
            result = 1;
        }else if(classname  < o.getClassname()){
            result = -1;
        }else{
            if(score > o.getScore()){
                result = -1;
            }else if(score < o.getScore()){
                result = 1;
            }else {
                result = 0;
            }
        }

        return result;
    }

    //3  写序列化方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(classname);
        out.writeUTF(stuname);
        out.writeInt(score);
    }
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.classname = dataInput.readInt();
        this.stuname = dataInput.readUTF();
        this.score = dataInput.readInt();
    }

    @Override
    public String toString(){
        return classname + "\t" + stuname +"\t" + score;
    }



}
