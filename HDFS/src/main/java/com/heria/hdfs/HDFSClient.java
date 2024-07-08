package com.heria.hdfs;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class HDFSClient {
	public static void main(String[] args) throws IOException,Exception, URISyntaxException{
		Configuration conf = new Configuration();
		//conf.set("fs.defaultFS","hdfs://master:9000");
		 // 1 获取文件系统
		//FileSystem fSystem =FileSystem.get(conf);
		FileSystem fs = FileSystem.get(new URI("hdfs://192.168.72.148:9000"), conf, "root");
		// 2在hdfs上创建路径
		fs.mkdirs(new Path("/18/hehehe"));
		//3 关闭资源
		fs.close();
		System.out.println("over");
	}
}