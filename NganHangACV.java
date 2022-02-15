package tuan3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NganHangACV implements Comparable<NganHangACV>{
	private final float LAI=0.035F;
	private final double PHI=2;
	private long soTaiKhoan;
	private String tenTaiKhoan;
	private double soDu;
	public long getSoTaiKhoan() 
	{
		return soTaiKhoan;
	}
	public void setSoTaiKhoan(long soTaiKhoan) 
	{
		this.soTaiKhoan = soTaiKhoan;
	}
	public String getTenTaiKhoan() 
	{
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan)
	{

		this.tenTaiKhoan = tenTaiKhoan;
	}
	public double getSoDu() 
	{
		return soDu;
	}
	public void setSoDu(double soDu) 
	{
		this.soDu = soDu;
	}
	public NganHangACV(long soTaiKhoan, String tenTaiKhoan, double soDu) 
	{
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soDu = soDu;
	}
	public NganHangACV() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NganHangACV(long soTaiKhoan, String tenTaiKhoan) 
	{
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.soDu=50;
	}
	public void napTien(double tienNap)
	{
		double tienCon=getSoDu();
		tienCon+=tienNap;
		this.setSoDu(tienCon);
	}
	public void rutTien(double tienRut)
	{
		double tienCon=0;
		if(this.getSoDu()>=tienRut+PHI+50000)
		{
			tienCon= this.getSoDu()-(tienRut+PHI);
			this.setSoDu(tienCon);;
		}
	}
	public void chuyenTien(NganHangACV tkNhan, double soTien)
	{
		this.rutTien(soTien);
		tkNhan.napTien(soTien);
	}
	public void daoHan()
	{
		double tienCon=this.getSoDu();
		double tienLoi=tienCon*LAI;
		this.setSoDu(tienCon+tienLoi);
	}
	@Override
	public String toString() {
		String str = "";
		DecimalFormat df = new DecimalFormat("###,000");
		str += str.format("%d\t%20s%20s", getSoTaiKhoan(), getTenTaiKhoan(), df.format(getSoDu()));
		return str;
	}
	@Override
	public int compareTo(NganHangACV acc) {
		int n = this.getTenTaiKhoan().compareToIgnoreCase(acc.getTenTaiKhoan());
		if(n==0)
		{	
			if(this.getSoDu()>acc.getSoDu())
				return 1;
			else if(this.getSoDu()==acc.getSoDu())
					return 0;
			else 
				return 1;
		
		}return n;
	}
}