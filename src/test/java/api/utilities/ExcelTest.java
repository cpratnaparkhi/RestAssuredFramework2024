package api.utilities;
import java.io.IOException;
public class ExcelTest 
{
	public static void getAllUSers() throws IOException 
	{
		String path = System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLSUtility xl = new XLSUtility(path);
		int rowCount = xl.getRowCount("Sheet1");
		int colCount = xl.getCellCount("Sheet1", 1);
		String apiData [][] = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++)
		{
			for(int j = 0 ; j < colCount; j++) 
			{
				apiData [i-1] [j] = xl.getCellData("Sheet1", i, j);
				System.out.print(xl.getCellData("Sheet1", i, j)+"   ");
			}
			System.out.print("\n");
		}
	}
	public static void getOneUser() throws IOException 
	{
		String path = System.getProperty("user.dir")+"//testData//UserData.xlsx";
		XLSUtility xl = new XLSUtility(path);
		int rowCount = xl.getRowCount("Sheet1");
		String apiData [] = new String[rowCount];
		for (int i = 1; i <= rowCount; i++) 
		{
			apiData [i-1] = xl.getCellData("Sheet1", i, 1);
			System.out.println(xl.getCellData("Sheet1", i, 1));
		}
	}
}
