package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entity.Tblrfidinfo;
import jxl.Sheet;
import jxl.Workbook;

public class Excel {
	/**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<Tblrfidinfo> getAllByExcel(String file,String sheetname){
        List<Tblrfidinfo> list=new ArrayList<Tblrfidinfo>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet(sheetname);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < 1; j++) {
                    //第一个是列数，第二个是行数
                    String RFIDs=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String s = RFIDs;   
                    String a[] = s.split(";");  
                    String id = a[0];
                    String epc = a[2];
                    //System.out.println("RFIDID:"+id+" RFIDEPC:"+epc);
                    Tblrfidinfo rfid = new Tblrfidinfo();
                    rfid.setRFIDID(id);
                    rfid.setRFIDEPC(epc);
                    list.add(rfid);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
    }
}
