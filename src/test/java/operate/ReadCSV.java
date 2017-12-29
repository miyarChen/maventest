package operate;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class ReadCSV {
	
	public static void readCSVFile(String filePath){
		try{
				ArrayList<String[]> csvList = new ArrayList<String[]>();//保存数据
				CsvReader reader = new CsvReader(filePath,',',Charset.forName("SJIS"));
				reader.readHeaders();//跳过表头
				
				while(reader.readRecord()){//逐行读入
					
					csvList.add(reader.getValues());
				}
				
				reader.close();
				
				for(int row=0;row<csvList.size();row++){
					
					//System.out.println(csvList.get(row)[0]);//第row行的第0+1=1列的内容
					System.out.println(csvList.get(row)[1]);//第row行的第1+1=2列的内容
					System.out.println(csvList.get(row)[2]);
					
					System.out.println("*********************");
				}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
