package tuan3;

public class DanhSachTK 
{
	public int dem=0;
	NganHangACV ds[];
	public DanhSachTK(int n) 
	{
		ds=new NganHangACV[n];
		// TODO Auto-generated constructor stub
	}
	public NganHangACV timTk(long stk)
	{
		for(int i=0;i<dem;i++)
		{
			if(ds[i].getSoTaiKhoan()==stk)
				return ds[i];
		}
		return null;
	}
	public int vtTK(long stk)
	{
		for(int i=0;i<dem;i++)
		{
			if(ds[i].getSoTaiKhoan()==stk)
				return i;
		}
		return -1;
	}
	private void tangKichThuocMang()
	{
		NganHangACV [] temp= new NganHangACV[(int)(ds.length*2)];
		for(int i=0;i<ds.length;i++)
			temp[i]=ds[i];
		ds=temp;
	}
	public boolean ThemTk(NganHangACV a)
	{
		if(timTk(a.getSoTaiKhoan())!=null)
			return false;
		if(dem==ds.length)
			tangKichThuocMang();
		ds[dem]=a;
		dem++;
		return true;
		
	}
	public void suaTk( NganHangACV a)
	{
		for(int i=0;i<dem;i++)
		{
			if(ds[i].getSoTaiKhoan()==a.getSoTaiKhoan())
			{
				 ds[i]=a;
				 break;
			}
		}
	}
	public NganHangACV	 [] getAllTK()
	{
	    return ds;	
	}
	public double tongTienAllAcc()
	{
		double tongTien=0;
		for (int i = 0; i < dem; i++) 
		{
			tongTien+=ds[i].getSoDu();
		}
		return tongTien;
	}
	public void xoaTK(long stk)
	{
		int i=vtTK(stk);
		for(int j=i;j<ds.length;j++)
		{
			ds[j]=ds[j+1];
		}
		dem--;
	}
}