#include <stdio.h>
#include <string.h>

int main()
{
	FILE* fp1 = fopen("totallyreversed.txtcheck.txt", "r");
	FILE* fp2 = fopen("totallyreversed.txtcheck.txt", "r");
	int skipper;
	char title1[100], title2[100];
	fscanf(fp1, "%s", title1);	
	fscanf(fp2, "%s", title2);
	fscanf(fp2, "%d", &skipper);
	int i=0, first,second;
	while(first!=second&&!feof(fp2))
	{
		fscanf(fp1, "%d", &first);
		fscanf(fp2, "%d", &second);
		if (second<first)
		{
			return 1;
		}
		printf("%d %d\n", first, second);
		i++;
	}	
	return 0;	
}
