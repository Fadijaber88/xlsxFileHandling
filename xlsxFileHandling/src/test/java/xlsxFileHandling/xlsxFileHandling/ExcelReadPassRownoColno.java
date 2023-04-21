package xlsxFileHandling.xlsxFileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadPassRownoColno 
{
	public void ExcelReadDataBasedUponRownoColno(int x1, int x2) throws IOException
	{
		File f=new File("../xlsxFileHandling/xlsx.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook xw=new XSSFWorkbook(fi);
		XSSFSheet xs=xw.getSheetAt(0);
		int r=xs.getPhysicalNumberOfRows();
		 
		for (int i=0;i<=x1;i++)
		{
			XSSFRow xr=xs.getRow(i);
			int c=xr.getPhysicalNumberOfCells();
						
			for(int j=0;j<=x2;j++)
			{
				XSSFCell xc=xr.getCell(j);
				System.out.println(xc.getStringCellValue());
			}
		}
	}
	public static void main(String[] args) throws IOException 
	{
		ExcelReadPassRownoColno rf=new ExcelReadPassRownoColno();
		rf.ExcelReadDataBasedUponRownoColno(3,0);
		
	}

}
