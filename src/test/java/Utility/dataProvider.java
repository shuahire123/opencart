package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name = "LoginData")
	public static Object[][] DPLogin() throws IOException
	{	String path=".\\TestData\\OpenCartTestData.xlsx";
		int Rows=ExcelUtility.NumOfRowInSheet(path,"Sheet1");
		int Cells= ExcelUtility.NumOfCellInSheet(path, "Sheet1", 3);
		Object [][] data= new Object[Rows][Cells];
		for(int i=1;i<=Rows;i++)
		{
			for(int j=0;j<Cells;j++)
			{
				data[i-1][j]=ExcelUtility.GetData(path, "Sheet1", i, j);
			}
		}
		
		return data;
	}
	

}
