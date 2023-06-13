import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    
	public static void main(String[] args) {
        // TODO: Use this method to run your experiments.
			FileReader files = new FileReader();
			SortingAlgorithms sorter = new SortingAlgorithms();
			
			File dir = new File("data");
			File file = new File("insertioncheck.txt");

			String contents[] = dir.list();
			for(int i=0;i<contents.length;i++)
			{
				Record[] arr = files.readFile(("data/"+contents[i]));
				long startTime = System.currentTimeMillis();
				sorter.selectionSort(arr, arr.length);
				long endTime = System.currentTimeMillis();
				try
				{
					FileOutputStream fos = new FileOutputStream(file, true);	
					PrintStream stream = new PrintStream(fos);
					System.setOut(stream);
					System.out.printf("%s\n", contents[i]);
					System.out.printf("%d-%d\n\n ", endTime, startTime);
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
