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
import java.util.StringTokenizer;


/**
 * Created by zhaomingxing on 2017/4/10.
 */

public class AverageScore {

    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            System.out.println("map input key: " + key.get());
            System.out.println("map input value " + value.toString());
            String line = value.toString();
            StringTokenizer tokenizerArticle = new StringTokenizer(line, "\n");
            while (tokenizerArticle.hasMoreElements()) {
                StringTokenizer tokenizerLine =
                        new StringTokenizer(tokenizerArticle.nextToken());
                String strName = tokenizerLine.nextToken();
                String strScore = tokenizerLine.nextToken();
                Text name = new Text(strName);
                int intScore = Integer.parseInt(strScore);
                IntWritable score = new IntWritable(intScore);
                context.write(name, score);
            }
        }
    }

    public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

        public void reduce (Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            int counter = 0;

            for (IntWritable s: values) {
                sum += s.get();
                counter++;
            }

            int averageScore = (int) sum / counter;
            context.write(key, new IntWritable(averageScore));
        }
    }

    public static void main(String[] args) throws Exception {
        String dst = "hdfs://localhost:9000/user/input";
        String dstOut = "hdfs://localhost:9000/output_average";
        Configuration conf = new Configuration();

        conf.set("fs.hdfs.impl", DistributedFileSystem.class.getName());
        conf.set("fs.file.impl", LocalFileSystem.class.getName());

        Job job = new Job(conf, "calculate average score");
        job.setMapperClass(AverageScore.Map.class);
        job.setCombinerClass(AverageScore.Reduce.class);
        job.setReducerClass(AverageScore.Reduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
