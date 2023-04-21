package xlsxFileHandling.xlsxFileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{
	public void writeData() throws IOException
	{
		File f=new File("../xlsxFileHandling/xlsx2.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		XSSFWorkbook xs=new XSSFWorkbook();
		XSSFSheet xt=xs.createSheet("FJ");
		
		for(int i=0;i<5;i++) //loop for rows
		{
			XSSFRow xr=xt.createRow(i);  //Row obj created
			for(int j=0;j<5;j++) //loop for colomns
			{
				XSSFCell xc=xr.createCell(j);
				xc.setCellValue("FF");
			}
		}
		xs.write(fo); //move the data from workbook to the stream
		fo.flush(); //move the data from stream to the file
		fo.close();
		
	}
	
	
	
	
	
	public void readData() throws IOException
	{
	File f=new File("../xlsxFileHandling/xlsx.xlsx");
	FileInputStream fi=new FileInputStream(f);
	XSSFWorkbook xs=new XSSFWorkbook(fi);
	XSSFSheet xt=xs.getSheetAt(0);
	int r=xt.getPhysicalNumberOfRows();
	for(int i=0;i<r;i++)
	{
		XSSFRow xr=xt.getRow(i); //Row obj created
		int c=xr.getPhysicalNumberOfCells(); //number of cells in a row
		for(int j=0;j<c;j++) //loop for cells
		{
			XSSFCell xc=xr.getCell(j);
			System.out.println(xc.getStringCellValue());
		}
	}

	}
	public static void main(String[] args) throws IOException 
	{
		ExcelRead e=new ExcelRead();
		e.writeData();
		
	}
	

}
