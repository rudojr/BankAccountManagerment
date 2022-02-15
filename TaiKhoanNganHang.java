package tuan3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaiKhoanNganHang 
{
	public static String tieude() {
		String s = "";
		s += s.format("%s%15s%30s", "S? t�i kho?n", "T�n t�i kho?n", "S? ti?n trong t�i kho?n");
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
		System.out.println("S? t�i kho?n: ");
		sTK = input.nextLong();
		System.out.println("T�n t�i kho?n: ");
		input.nextLine();// them vao cho so qua chu
		tTK = input.nextLine();
		System.out.println("S? ti?n trong t�i kho?n: ");
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
		System.out.println("Nh?p s? t�i kho?n b?n mu?n s?a: ");
		stk=inc.nextLong();
		a=ds.timTk(stk);
		if(a!=null)
		{
			System.out.println("Th�ng tin t�i kho?n: ");
			System.out.println(a);
			System.out.println("S?a t�n nh?n s? 1");
			System.out.println("S?a s? du nh?n s? 2");
			System.out.println("m?i b?n nh?n");
			chon=inc.nextInt();
			switch (chon) {
			case 1:
				System.out.println("Nh?p t�n m?i");
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
			System.out.println("S?a Th�nh C�ng!");
		}
		else
		{
			System.out.println("T�i kho?n kh�ng t?n t?i!!\n");
		}
		return a;
	}
	static void xoaTk(DanhSachTK ds)
	{
		long stk=0;
		int chon;
		NganHangACV a;
		Scanner inc = new Scanner(System.in);
		System.out.println("Nh?p s? t�i kho?n b?n mu?n xoa: ");
		stk=inc.nextLong();
		a=ds.timTk(stk);
		if(a!=null)
		{
			System.out.println(tieude());
			System.out.println(a);
			System.out.println("\n B?n c� ch?c ch?n x�a??");
			System.out.println("\n1.YES\t2.NO\n");
			chon=inc.nextInt();
			switch (chon) {
			case 1:
				ds.xoaTK(stk);
				System.out.println("X�a Th�nh C�ng!");
				break;
			default:
				break;
			}
		}
		else
		{
			System.out.println("T�i kho?n kh�ng t?n t?i!!\n");
		}

	}
	static int meNu()
	{
		int c;
		System.out.println("1.Nh?p danh s�ch c�c t�i kho?n.");
		System.out.println("2.In danh s�ch c�c t�i kho?n.");
		System.out.println("3.N?p ti?n v�o t�i kho?n.");
		System.out.println("4.R�t ti?n.");
		System.out.println("5.Chuy?n ti?n.");
		System.out.println("6.��o h?n.");
		System.out.println("7.Th�ng tin t�i kho?n.");
		System.out.println("8.S?a th�ng tin t�i kho?n.");
		System.out.println("9.X�a t�i kho?n.");
		System.out.println("10.Xem t?ng ti?n c?a c�c t�i kho?n.");
		System.out.println("11.S?p x?p.");
		System.out.println("12. Tho�t.");
		System.out.println("M?i b?n ch?n d?ch v?: ");
		Scanner scn = new Scanner(System.in);
		c=scn.nextInt();
		return c;		
	}
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("Chuong tr�nh Ng�n h�ng c?a Th�nh!!!!");
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
					System.out.println("S? t�i kho?n c?n n?p: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						//						System.out.println(acsua);
						tienNap=nhapTien();
						acsua.napTien(tienNap);
						System.out.println("N?p ti?n th�nh c�ng!");
						//						System.out.println(acsua);
					}
					else
					{
						System.out.println("T�i kho?n kh�ng t?n t?i!!\n");
					}
				}
				break;
				case 4:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("\n");
					System.out.println("S? t�i kho?n c?n r�t: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(acsua);
						tienRut=nhapTien();
						acsua.rutTien(tienRut);
						System.out.println("�� r�t!");
						System.out.println(acsua);
					}
					else
					{
						System.out.println("T�i khoan kh�ng t?n t?i!!\n");
					}
				}
				break;
				case 5:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("S? t�i kho?n chuy?n ti?n: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					System.out.println("S? t�i kho?n nh?n ti?n: ");
					soTaiKhoan=scn.nextLong();
					acnhan=ds.timTk(soTaiKhoan);
					if(acsua!=null&&acnhan!=null)
					{
						System.out.println(acsua);
						System.out.println(acnhan);
						tienNap=nhapTien();
						acsua.chuyenTien(acnhan, tienNap);
						System.out.println("Chuy?n th�nh c�ng!");
						System.out.println(acsua);
						System.out.println(acnhan);					
					}
					else
					{
						System.out.println("T�i khoan kh�ng t?n t?i!!\n");
					}
				}
				break;
				case 6:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("S? t�i kho?n d�o h?n: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(acsua);
						acsua.daoHan();
						System.out.println("��o h?n th�nh c�ng!\n");
						System.out.println(acsua);
					}
					else
					{
						System.out.println("T�i kho?n kh�ng t?n t?i!!\n");
					}

				}
				break;
				case 7:
				{
					Scanner scn = new Scanner(System.in);
					System.out.println("Nh?p s? t�i kho?n b?n mu?n xem th�ng tin: ");
					soTaiKhoan=scn.nextLong();
					acsua=ds.timTk(soTaiKhoan);
					if(acsua!=null)
					{
						System.out.println(tieude());
						System.out.println(acsua);
					}
					else
					{
						System.out.println("T�i kho?n kh�ng t?n t?i!!\n");
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
					System.out.println("T?ng ti?n trong t?t c? t�i kho?n l�: \n");
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
				System.out.println("C� L?i x?y ra!"+e.getMessage());
			}
		}while(kt<12);

	}

}
