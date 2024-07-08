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

输入输出路径：
1、将 train 和 test 数据集放在 /userCF 路径下
2、输出预测评分文件 /userCF/score  和 平均绝对偏差 /userCF/MAE

* */
