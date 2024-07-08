package com.heria.mapreduce.inputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class WholeRecordReader extends RecordReader<Text, BytesWritable> {
    FileSplit split;
    Configuration configuration;

    @Override

    //≥ı ºªØ
    public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {

        this.split=(FileSplit) split;
        configuration = context.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        return false;
    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return null;
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return null;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
