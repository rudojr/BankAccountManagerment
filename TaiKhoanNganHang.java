package tuan3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaiKhoanNganHang 
{
	public static String tieude() {
		String s = "";
		s += s.format("%s%15s%30s", "S? tài kho?n", "Tên tài kho?n", "S? ti?n trong tài kho?n");
		return s;
	}
	static double  nhapTien()
	{
		double	addMoney=0; 
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Nh?p s? ti?n>0: ");
			addMoney = input.nextDouble();
		} while (addMoney < 0);
		return addMoney;
	}
	public static NganHangACV nhapThongTin() 
	{
		long sTK;
		String tTK;
		double soDu;
		Scanner input = new Scanner(System.in);
		System.out.println("S? tài kho?n: ");
		sTK = input.nextLong();
		System.out.println("Tên tài kho?n: ");
		input.nextLine();// them vao cho so qua chu
		tTK = input.nextLine();
		System.out.println("S? ti?n trong tài kho?n: ");
		soDu = input.nextDouble();
		NganHangACV acc= new NganHangACV(sTK, tTK, soDu);
		return acc;	
	}
	static  void xuatDanhSach( NganHangACV [] ds , int sptThat)
	{
		for (int i = 0; i < sptThat; i++) 
		{
			System.out.println(ds[i]);	
		}
	}
	static NganHangACV SuaTk(DanhSachTK ds) throws Exception
	{
		long stk=0;
		int chon;
		String suaTen;
		double suaTien;
		NganHangACV a;
		Scanner inc = new Scanner(System.in);
		System.out.println("Nh?p s? tài kho?n b?n mu?n s?a: ");
		stk=inc.nextLong();
		a=ds.timTk(stk);
		if(a!=null)
		{
			System.out.println("Thông tin tài kho?n: ");
			System.out.println(a);
			System.out.println("S?a tên nh?n s? 1");
			System.out.println("S?a s? du nh?n s? 2");
			System.out.println("m?i b?n nh?n");
			chon=inc.nextInt();
			switch (chon) {
			case 1:
				System.out.println("Nh?p tên m?i");
				inc.nextLine();
				suaTen= inc.nextLine();
				a.setTenTaiKhoan(suaTen);
				break;
			case 2:
				System.out.println("Nh?p ti?n m?i");
				suaTien= inc.nextDouble();
				a.setSoDu(suaTien);
				break;

			default:
				break;
			}
			System.out.println("S?a Thành Công!");
		}
		else
		{
			System.out.println("Tài kho?n không t?n t?i!!\n");
		}
		return a;
	}
	static void xoaTk(DanhSachTK ds)
	{
		long stk=0;
		int chon;
		NganHangACV a;
		Scanner inc = new Scanner(System.in);
		System.out.println("Nh?p s? tài kho?n b?n mu?n xoa: ");
		stk=inc.nextLong();
		a=ds.timTk(stk);
		if(a!=null)
		{
			System.out.println(tieude());
			System.out.println(a);
			System.out.println("\n B?n có ch?c ch?n xóa??");
			System.out.println("\n1.YES\t2.NO\n");
			chon=inc.nextInt();
			switch (chon) {
			case 1:
				ds.xoaTK(stk);
				System.out.println("Xóa Thành Công!");
				break;
			default:
				break;
			}
		}
		else
		{
			System.out.println("Tài kho?n không t?n t?i!!\n");
		}

	}
	static int meNu()
	{
		int c;
		System.out.println("1.Nh?p danh sách các tài kho?n.");
		System.out.println("2.In danh sách các tài kho?n.");
		System.out.println("3.N?p ti?n vào tài kho?n.");
		System.out.println("4.Rút ti?n.");
		System.out.println("5.Chuy?n ti?n.");
		System.out.println("6.Ðáo h?n.");
		System.out.println("7.Thông tin tài kho?n.");
		System.out.println("8.S?a thông tin tài kho?n.");
		System.out.println("9.Xóa tài kho?n.");
		System.out.println("10.Xem t?ng ti?n c?a các tài kho?n.");
		System.out.println("11.S?p x?p.");
		System.out.println("12. Thoát.");
		System.out.println("M?i b?n ch?n d?ch v?: ");
		Scanner scn = new Scanner(System.in);
		c=scn.nextInt();
		return c;		
	}
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("Chuong trình Ngân hàng c?a Thành!!!!");
		int kt = 0,n;
		long soTaiKhoan;
		double tienNap;
		double tienRut;
		NganHangACV acsua,acnhan;
		DanhSachTK ds=new DanhSachTK(10);
		do 
		{
			try {
				kt=meNu();
				switch (kt)
				{
				case 1: 
				{
					System.out.println("So tai khoan ban muon nhap thong tin: ");
					Scanner scn= new Scanner(System.in);
					n=scn.nextInt();
					for(int i=0;i<n;i++)
					{
						NganHangACV a=nhapThongTin();
						ds.ThemTk(a);
					}
				}
				break;
				case 2:
				{
					System.out.println(tieude());
					xuatDanhSach(ds.getAllTK(), ds.dem);
				}
				break;
				case 3:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("S? tài kho?n c?n n?p: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						//						System.out.println(acsua);
						tienNap=nhapTien();
						acsua.napTien(tienNap);
						System.out.println("N?p ti?n thành công!");
						//						System.out.println(acsua);
					}
					else
					{
						System.out.println("Tài kho?n không t?n t?i!!\n");
					}
				}
				break;
				case 4:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("\n");
					System.out.println("S? tài kho?n c?n rút: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(acsua);
						tienRut=nhapTien();
						acsua.rutTien(tienRut);
						System.out.println("Ðã rút!");
						System.out.println(acsua);
					}
					else
					{
						System.out.println("Tài khoan không t?n t?i!!\n");
					}
				}
				break;
				case 5:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("S? tài kho?n chuy?n ti?n: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					System.out.println("S? tài kho?n nh?n ti?n: ");
					soTaiKhoan=scn.nextLong();
					acnhan=ds.timTk(soTaiKhoan);
					if(acsua!=null&&acnhan!=null)
					{
						System.out.println(acsua);
						System.out.println(acnhan);
						tienNap=nhapTien();
						acsua.chuyenTien(acnhan, tienNap);
						System.out.println("Chuy?n thành công!");
						System.out.println(acsua);
						System.out.println(acnhan);					
					}
					else
					{
						System.out.println("Tài khoan không t?n t?i!!\n");
					}
				}
				break;
				case 6:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("S? tài kho?n dáo h?n: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(acsua);
						acsua.daoHan();
						System.out.println("Ðáo h?n thành công!\n");
						System.out.println(acsua);
					}
					else
					{
						System.out.println("Tài kho?n không t?n t?i!!\n");
					}

				}
				break;
				case 7:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("Nh?p s? tài kho?n b?n mu?n xem thông tin: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(tieude());
						System.out.println(acsua);
					}
					else
					{
						System.out.println("Tài kho?n không t?n t?i!!\n");
					}
				}
				break;
				case 8:
					SuaTk(ds);
					break;
				case 9:
					xoaTk(ds);
					break;
				case 10:
				{
					System.out.println("T?ng ti?n trong t?t c? tài kho?n là: \n");
					System.out.println(ds.tongTienAllAcc());
				}
				break;
				case 11:
				{
					Arrays.sort(ds.getAllTK(),0,ds.dem);
				}
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Ch? du?c nh?p s?!!!\n"+e.getMessage());
				// TODO: handle exception
			}
			catch(Exception e)
			{
				System.out.println("Có L?i x?y ra!"+e.getMessage());
			}
		}while(kt<12);

	}

}
