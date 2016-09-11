package word_counter;

import org.apache.hadoop.io.Text;


import org.apache.hadoop.mapreduce.Mapper; 
import org.apache.hadoop.io.LongWritable; 


import java.util.*; 
import java.io.*;


public class Map_service extends Mapper<LongWritable,Text,Text,Text> {
	
	private Text map_key_output = new Text(); 
	private Text map_value_output= new Text();

	public void map (LongWritable key, Text Value, Context context) throws IOException, InterruptedException {
	StringTokenizer map_input= new StringTokenizer(Value.toString()," ");
	map_value_output.set("1");

	while (map_input.hasMoreTokens()) {
	map_key_output.set(map_input.nextToken());
	context.write(map_key_output,map_value_output);
	}

	}
}
