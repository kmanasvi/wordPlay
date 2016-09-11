package word_counter;




import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class driver {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		 {
		        Configuration conf = new Configuration();
		        Job job = new Job(conf, "driver");
		        job.setJarByClass(driver.class);
		        job.setMapperClass(Map_service.class);
		        job.setReducerClass(final_reducer.class);
		        job.setOutputKeyClass(Text.class);
		        job.setOutputValueClass(Text.class);
		 
		        job.setMapOutputKeyClass(Text.class);
		        job.setMapOutputValueClass(Text.class);
		 
		        job.setInputFormatClass(KeyValueTextInputFormat.class);
		        job.setOutputFormatClass(TextOutputFormat.class);
		        FileInputFormat.addInputPath(job, new Path(args[0])); 
		        FileOutputFormat.setOutputPath(job, new Path(args[1]));
		        boolean result = job.waitForCompletion(true);
		        System.exit(result ? 0 : 1);
		    }
			


	}

}
