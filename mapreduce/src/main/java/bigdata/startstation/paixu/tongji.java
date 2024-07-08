package bigdata.startstation.paixu;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class tongji implements WritableComparable <tongji>{
    private long number;

    public tongji(long number) {
        this.number = number;
    }

    public tongji() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }




    @Override
    public int compareTo(tongji o) {
        int result;

        // 按照总流量大小，倒序排列
        if (number > o.getNumber()) {
            result = -1;
        }else if (number < o.getNumber()) {
            result = 1;
        }else {
            result = 0;
        }

        return result;
    }




    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(number);

    }

    @Override
    public void readFields(DataInput in) throws IOException {
        number =in.readLong();

    }
}

