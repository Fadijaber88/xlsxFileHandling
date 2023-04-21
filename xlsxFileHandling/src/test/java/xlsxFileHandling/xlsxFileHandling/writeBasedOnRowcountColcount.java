package xlsxFileHandling.xlsxFileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeBasedOnRowcountColcount 
{
	public void writeDataBasedOnRowcountColcount(int x1, int x2) throws IOException
	{
		File f=new File("../xlsxFileHandling/xlsx2.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		XSSFWorkbook xs=new XSSFWorkbook();
		XSSFSheet xt=xs.createSheet("FJ");
		
		for(int i=0;i<x1;i++) //loop for rows
		{
			
			XSSFRow xr=xt.createRow(i);  //Row obj created
			for(int j=0;j<x2;j++) //loop for colomns
			{
				Scanner s=new Scanner(System.in);
				System.out.println("Pleases enter the data");
				String s1=s.next();
				XSSFCell xc=xr.createCell(j);
				xc.setCellValue(s1);
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
		writeBasedOnRowcountColcount e=new writeBasedOnRowcountColcount();
		e.writeDataBasedOnRowcountColcount(3,1);
		
	}
	

}
