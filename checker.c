#include <stdio.h>
#include <string.h>
#include <dirent.h>

int main()
{
	DIR* folder = opendir("tests/");
	struct dirent *entry;
	entry=readdir(folder);
	entry=readdir(folder);
	
	while(entry=readdir(folder))
	{
		char name[100] = "tests/";
		strcat(name, entry->d_name);
		FILE* fp1 = fopen(name, "r");
		FILE* fp2 = fopen(name, "r");
		int skipper;
		char title1[100], title2[100];
		fscanf(fp1, "%s", title1);	
		fscanf(fp2, "%s", title2);
		fscanf(fp2, "%d", &skipper);
		int i=0, first=0,second=1;
		
		while(first!=second&&!feof(fp2))
		{
			fscanf(fp1, "%d", &first);
			fscanf(fp2, "%d", &second);
			if (second<first)
			{
				return 1;
			}
			i++;
		}
		
		printf("%s PASSED\n", entry->d_name);
		fclose(fp1);
		fclose(fp2);
	}
	
	return 0;	
}
