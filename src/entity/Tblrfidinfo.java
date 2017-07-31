package entity;

import java.io.Serializable;

public class Tblrfidinfo implements Serializable {
	private int id;
	private int RFIDTYPE;
	private int RFIDMODE;
	private String RFIDID;
	private String RFIDEPC;
	private String RFIDUSER;
	public Tblrfidinfo() {
		super();
	}
	public Tblrfidinfo(int id, int rFIDTYPE, int rFIDMODE, String rFIDID, String rFIDEPC, String rFIDUSER) {
		super();
		this.id = id;
		RFIDTYPE = rFIDTYPE;
		RFIDMODE = rFIDMODE;
		RFIDID = rFIDID;
		RFIDEPC = rFIDEPC;
		RFIDUSER = rFIDUSER;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRFIDTYPE() {
		return RFIDTYPE;
	}
	public void setRFIDTYPE(int rFIDTYPE) {
		RFIDTYPE = rFIDTYPE;
	}
	public int getRFIDMODE() {
		return RFIDMODE;
	}
	public void setRFIDMODE(int rFIDMODE) {
		RFIDMODE = rFIDMODE;
	}
	public String getRFIDID() {
		return RFIDID;
	}
	public void setRFIDID(String rFIDID) {
		RFIDID = rFIDID;
	}
	public String getRFIDEPC() {
		return RFIDEPC;
	}
	public void setRFIDEPC(String rFIDEPC) {
		RFIDEPC = rFIDEPC;
	}
	public String getRFIDUSER() {
		return RFIDUSER;
	}
	public void setRFIDUSER(String rFIDUSER) {
		RFIDUSER = rFIDUSER;
	}
}
