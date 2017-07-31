package application;

import java.util.List;

import entity.Tblrfidinfo;
import util.DBHelper;
import util.Excel;

public class Atest {

	public static void main(String[] args) {
		//从数据库读取标签信息
//		List<Tblrfidinfo> rfidlist = DBHelper.DBselect();
//		for(Tblrfidinfo t:rfidlist ){
//			System.out.println(t.getId()+"***"+t.getRFIDTYPE()+"***"+t.getRFIDMODE()+"***"+t.getRFIDID()+"***"+t.getRFIDEPC());
//		}
		List<Tblrfidinfo> list = Excel.getAllByExcel("C:\\Users\\zanrun\\Desktop\\芯片定义(2).xls", "方巾-万信");
		for(Tblrfidinfo t:list ){
			System.out.println(t.getRFIDID()+"***"+t.getRFIDEPC());
			Tblrfidinfo rfid = new Tblrfidinfo();
			rfid.setRFIDID(t.getRFIDID());
			rfid.setRFIDEPC(t.getRFIDEPC());
			DBHelper.DBinsert(rfid);
		}
	}
}
