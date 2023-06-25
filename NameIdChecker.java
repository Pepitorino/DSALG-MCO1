import java.io.*;
import java.util.Scanner;

public class NameIdChecker {
    
	public static void main(String[] args) {
        // TODO: Use this method to run your experiments.
			boolean sentinel=true;
			FileReader fr = new FileReader();
			SortingAlgorithms sorter = new SortingAlgorithms();

			File testDir = new File("nameidtest");
			File dataDir = new File("data");

			String testContents[] = testDir.list();
			String dataContents[] = dataDir.list();

			for(int i=1;i<dataContents.length;i++) {
				File testContent = new File(testDir+"/"+testContents[i]);
				Record[] dataset = fr.readFile(dataDir+"/"+dataContents[i-1]);
				sorter.mergeSort(dataset, 0, 0);
				dataset = sorter.recordList;
				String[] tests = testContent.list();
				for(int j=1;j<tests.length;j++) {
					String f2 = String.format(testDir+"/"+testContents[i]+"/"+tests[j]);
					File f = new File(f2);
					Scanner file = new Scanner(System.in);
					try {
						file = new Scanner(f);
					}
					catch (FileNotFoundException e) {
						System.out.println("ERROR");
					}
					System.out.printf("TESTING %s - %s\n", tests[j], file.nextLine());
					int k=0;
					while(file.hasNextLine())
					{
						String record1 = String.format("%d %s", dataset[k].getIdNumber(), dataset[k].getName());
						String record2 = file.nextLine();
						if (!record2.equals(record1)) sentinel=false;
						k++;
					}
					if (sentinel) System.out.printf("%s PASSED\n", f2);
					else System.out.printf("%s FAILED\n", f2);
					System.out.println("==================================");
				}
			}
		}
	}
