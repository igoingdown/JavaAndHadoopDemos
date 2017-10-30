package hadoop_demos;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by zhaomingxing on 2017/4/1.
 */
public class Dedup {

    public static class map extends Mapper<LongWritable, Text, Text, Text> {
        private Text line;
        public void map(LongWritable key, Text value, Mapper.Context context)
                throws IOException, InterruptedException {
            line = value;
            String s = value.toString();
            System.out.println("value: " +  s);
            context.write(line, new Text(""));
        }
    }

    public static class reduce extends Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException{
            System.out.println("key: " + key.toString());
            for (Text t: values) {
                System.out.println("value: " + t.toString());
            }
            context.write(key, new Text(""));
        }
    }

    public static void main(String[] args) throws Exception {
        String dst = "hdfs://localhost:9000/user/input";
        String dstOut = "hdfs://localhost:9000/output";
        Configuration conf = new Configuration();

        conf.set("fs.hdfs.impl", DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", LocalFileSystem.class.getName());
        Job job = new Job(conf, "Data delete duplication");
        job.setMapperClass(map.class);
        job.setCombinerClass(reduce.class);
        job.setReducerClass(reduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
