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
			File test = new File("timed.txt");

			String contents[] = dir.list();
			for(int k=1;k<6;k++)
			{
				for(int i=0;i<contents.length;i++)
				{
					String filename = String.format("%scheck#%d.txt", contents[i], k);
					File file = new File("tests/"+filename);
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
							System.out.printf("%d\n", arr[j].getIdNumber());
						}
						stream.flush();
						stream.close();
					}
					catch (FileNotFoundException ex)
					{
						System.out.println("FILENOTFOUND");
					}

					try
					{
						FileOutputStream fos = new FileOutputStream(test, true);	
						PrintStream stream = new PrintStream(fos);
						System.setOut(stream);
						System.out.printf("%s Trial#%d TIME:%d-%d=%d\n", contents[i], k, endTime, startTime,endTime-startTime);
						stream.flush();
						stream.close();
					}
					catch (FileNotFoundException ex)
					{
						System.out.println("FILENOTFOUND");
					}
				}
				try
					{
						FileOutputStream fos = new FileOutputStream(test, true);	
						PrintStream stream = new PrintStream(fos);
						System.setOut(stream);
						System.out.println("==========================");
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
