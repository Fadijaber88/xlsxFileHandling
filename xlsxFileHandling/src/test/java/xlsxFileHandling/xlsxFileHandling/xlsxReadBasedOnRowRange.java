package xlsxFileHandling.xlsxFileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsxReadBasedOnRowRange 
{
	public void ExcelReadDataBasedUponParticularRow(int x1) throws IOException
	{
		File f=new File("../xlsxFileHandling/xlsx.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook xw=new XSSFWorkbook(fi);
		XSSFSheet xs=xw.getSheetAt(0);
		int r=xs.getPhysicalNumberOfRows();
		
		for (int i=0;i<=r;i++)
		{
			if (i==x1)
			{
			XSSFRow xr=xs.getRow(i);
			
			for(int j=0;j<r;j++)
			{
				XSSFCell xc=xr.getCell(j);
				System.out.println(xc.getStringCellValue());
			}
			}
		}

	}
	

	public static void main(String[] args) throws IOException 
	{
		xlsxReadBasedOnRowRange rf=new xlsxReadBasedOnRowRange();
		rf.ExcelReadDataBasedUponParticularRow(0);
		
	}
}
