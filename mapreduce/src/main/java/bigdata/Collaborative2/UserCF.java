package bigdata.Collaborative2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;

public class UserCF {
    public static void main(String[] args) throws Exception {

        ToolRunner.run(new Configuration(), new UserCF1(), args);
        ToolRunner.run(new Configuration(), new UserCF2(), args);
        ToolRunner.run(new Configuration(), new UserCF3(), args);
        ToolRunner.run(new Configuration(), new UserCF4(), args);
        ToolRunner.run(new Configuration(), new UserCF5(), args);
        ToolRunner.run(new Configuration(), new UserCF6(), args);
    }
}

/*

�������·����
1���� train �� test ���ݼ����� /userCF ·����
2�����Ԥ�������ļ� /userCF/score  �� ƽ������ƫ�� /userCF/MAE

* */
