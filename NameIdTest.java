import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class NameIdTest {
    
	public static void main(String[] args) {
        // TODO: Use this method to run your experiments.
			FileReader files = new FileReader();
			SortingAlgorithms sorter = new SortingAlgorithms();

			File dir = new File("data");
			File test = new File("timed.txt");

			String contents[] = dir.list();
			for(int i=0;i<contents.length;i++)
			{
				String filename = String.format("%sNameIdCheck-bubbleSort.txt", contents[i]);
				File file = new File("nameidtest/"+contents[i]+"/"+filename);
				Record[] arr = files.readFile(("data/"+contents[i]));
				long startTime = System.currentTimeMillis();
				sorter.bubbleSort(arr);
				long endTime = System.currentTimeMillis();
				try
				{
					FileOutputStream fos = new FileOutputStream(file, true);	
					PrintStream stream = new PrintStream(fos);
					System.setOut(stream);
					System.out.printf("%s\n", contents[i]);
					for(int j=0;j<arr.length;j++)
					{
						System.out.printf("%d %s\n", arr[j].getIdNumber(), arr[j].getName());
					}
					stream.flush();
					stream.close();
				}
				catch (FileNotFoundException ex)
				{
					System.out.println("FILENOTFOUND");
				}
			}
			
		}
	}
