package p1;


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;

public class MagicSquare {
	
	static boolean flag=true;
	boolean Right;
	int square[][] = new int[10000][10000];
	int hang = 0,lie = 0,s = 0,flaghang = 0,flaglie = 0;
	char flagchar;


	public void Read(String fileName) {
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String Str = br.readLine();
			int now,sum,max;
			char ch;
			hang=0;
			now=0;
			max=0;
			while (Str != null && now<Str.length()) {
				hang++;
				lie = 1;now = 0;sum = 0;
				ch = Str.charAt(now);
				while (ch=='\t'||(ch>='0'&&ch<='9')) {
					
					if (ch=='\t')	{
						lie++;
						square[hang][lie]=sum;
						sum = 0;
						if(max<lie) max=lie;
					}
					else {
						sum = sum*10+(int)ch-(int)('0');
					}
					now++;
					ch = Str.charAt(now);
				}
				if (sum!=0)	square[hang][++lie]=sum;
				if (!Str.endsWith(String.valueOf(ch)))	{
					flagchar=ch;
					flag=false;
					flaghang=hang;
					flaglie=lie;
				}
				
				Str = br.readLine();
			}
			br.close();
			fr.close();
			lie = max;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public boolean isLeagalMagicSquare (String fileName) {
		
		/*Scanner in = new Scanner(Path.of(fileName),StandardCharsets.UTF_8);
		FileReader fileReader = new FileReader(fileName);
		*/
		Read(fileName);
		s = 0;
		int sum = 0;
		int i,j;
		if (hang==lie) {
			if (flag==false)	{
				System.out.println(fileName+":���ݴ���");
				System.out.println("��������λ�� ");
				System.out.println("��"+flaghang+"�� ��"+flaglie+"��");
				System.out.println(square[flaghang][flaglie]);
				System.out.print("�����־"+flagchar);
				if (flagchar=='\t')	System.out.println("(����ȱʧ)");
				if (flagchar<'0'||flagchar>'9')	System.out.println("(�����ʽ����)");
				if (flagchar=='.')	System.out.println("(�������ݴ���,����С��)");
				if (flagchar=='-')	System.out.println("(�������ݴ���,���ڸ���)");

				return false;
			}
			for (j=1;j<=lie;j++) {
				s+=square[1][j];
			}
			//�����һ�еĺ�
			for ( i=2;i<=hang;i++) {
				
				for ( j=1;j<=lie;j++) {
					sum+=square[i][j];
					
				}
				if (s!=sum)	{
					flag=false;
					System.out.println(fileName+":�˾����޷����ɻ÷�");
					return false;
				}
			}
			//���������еĺ���������ڵ�һ�еĺ��򷵻ش���
			sum = 0;
			for ( j=1;j<=lie;j++) {
				for ( i=1;i<=hang;i++) {
					sum+=square[i][j];
					}
				if (s!=sum)	{
					flag=false;
					System.out.println(fileName+":�˾����޷����ɻ÷�");
					return false;
					}
				}
			//����ÿһ�еĺ���������ڵ�һ�еĺ��򷵻ش���
			sum = 0;
			for (i=1;i<=lie;i++) {
				sum+=square[i][i];
				
			}
			if (s!=sum)	{
				flag=false;
				System.out.println(fileName+":�˾����޷����ɻ÷�");
				return false;
			}
			//����Խ��ߵĺ�
			
			sum = 0;
			for (i=lie;i<=lie;i++) {
				sum+=square[i][lie-i+1];
				
			}
			if (s!=sum)	{
				flag=false;
				System.out.println(fileName+":�˾����޷����ɻ÷�");
				return false;
			}
			//���㷴�Խ��ߵĺ�
			
			if (flag==true) {
				return true;
			}
		}
		flag=false;
		System.out.println(fileName+":�˾����޷����ɻ÷�");
		return false;
		
	}
		

	
public static boolean generateMagicSquare(int n) {
	if (n>0)	{
		if (n%2==0)	{
			System.out.println("�������������ż��");
			return false;
		}
	}
	else	{
		System.out.println("������������˸���");
		return false;
	}
	int magic[][] = new int[n][n];
	int row = 0, col = n / 2, i, j, square = n * n;
	for (i = 1; i <= square; i++) {
		magic[row][col] = i;
		if (i % n == 0) {	
			row++; 
		}
		else {
	          if (row == 0)	row = n - 1;
	          else row--;
	          if (col == (n - 1))	col = 0;
	          else col++;
		} 
		
	}
	File file = new File("src/p1/txt/6.txt");
	try{
		if (!file.exists())	System.out.println(file.createNewFile());
		FileWriter writer = new FileWriter(file);
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				writer.write(magic[i][j] + "\t");
			writer.write("\n");
			}
		writer.flush();
        writer.close();
		}	catch (IOException e) {
			e.printStackTrace();
		}
	return true;
}

public static void main(String []args) {
	MagicSquare M = new MagicSquare();
	M.isLeagalMagicSquare("src/p1/txt/1.txt");
	System.out.println("Test1:"+flag+"\n");
	flag=true;
	M.isLeagalMagicSquare("src/p1/txt/2.txt");
	System.out.println("Test2:"+flag+"\n");
	flag=true;
	M.isLeagalMagicSquare("src/p1/txt/3.txt");
	System.out.println("Test3:"+flag+"\n");
	flag=true;
	M.isLeagalMagicSquare("src/p1/txt/4.txt");
	System.out.println("Test4:"+flag+"\n");
	flag=true;
	M.isLeagalMagicSquare("src/p1/txt/5.txt");
	System.out.println("Test5:"+flag+"\n");
	flag=true;
	int n = 3;
	Scanner scanner = new Scanner(System.in);
	System.out.println("���������ɵĻ÷�����:");
	n = scanner.nextInt();
	M.generateMagicSquare(n);
	//System.out.println(myMagicSquare.generateMagicSquare(n));
	M.isLeagalMagicSquare("src/p1/txt/6.txt");
	System.out.println("Test6:"+flag+"\n");
	flag=true;
	}
}
	