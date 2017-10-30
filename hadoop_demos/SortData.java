package hadoop_demos;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.IOException;

/**
 * Created by zhaomingxing on 2017/4/7.
 */
public class SortData {
    public static class map extends Mapper<LongWritable, Text, Text, Text> {
        private Text line;
        public void map(LongWritable key, Text value, Mapper.Context context)
                throws IOException, InterruptedException {
            line = value;
            String s = value.toString();
            System.out.println("value: " +  s);
            context.write(line, line);
        }
    }

    public static class reduce extends Reducer<Text, Text, Text, Text> {
        private static IntWritable lineNum = new IntWritable(1);

        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException{
            System.out.println("\n\n\n" + "reduce");
            for (Text t: values) {
                context.write(new Text(String.valueOf(lineNum.get())), t);
                lineNum = new IntWritable(lineNum.get() + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String dst = "hdfs://localhost:9000/user/input";
        String dstOut = "hdfs://localhost:9000/output_sort";
        Configuration conf = new Configuration();

        conf.set("fs.hdfs.impl", DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", LocalFileSystem.class.getName());
        Job job = new Job(conf, "sort data");
        job.setMapperClass(SortData.map.class);
        job.setCombinerClass(SortData.reduce.class);
        job.setReducerClass(SortData.reduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}

