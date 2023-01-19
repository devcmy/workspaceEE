package com.itwill.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
 * Dao(Data Access Object) 클래스
 *    - address테이블에 CRUD(Create,Read,Update,Delete)작업을하는
 *      단위메쏘드를 가지고있는 클래스
 *    
 * 
 */
public class AddressDao {

	/*
	 * DataSource객체를 멤버필드로 가짐
	 * (Connection을 생성하고 해지하는 객체) *(상속은 DataSource의 상위타입이 존재해서 상속으론 받지않는다.)
	 */
	private DataSource dataSource; //멤버필드로 가짐

	public AddressDao() throws Exception {
		/*
		 * dataSource 멤버필드 초기화
		 */
			this.dataSource = new DataSource(); //
	}
	
	public int insert(Address newAddress) throws Exception{
		
		
		
		
		Connection con = dataSource.getConnection(); //
		PreparedStatement pstmt = con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, newAddress.getName());
		pstmt.setString(2, newAddress.getPhone());
		pstmt.setString(3, newAddress.getAddress());
	
		
		
		int rowCount = pstmt.executeUpdate();//비워야한다.
		pstmt.close();
		dataSource.close(con); //무엇을 닫아야할지 넣어줘야한다.
		return rowCount;
	}
	
	public int update(Address updateAddress) throws Exception{
		
		
		
		
		Connection con = dataSource.getConnection(); 
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		
		int rowCount=pstmt.executeUpdate();//비워야한다
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public int delete(int no)throws Exception {
		
		
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, no);
		
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
		
	}
	public Address findByPrimaryKey(int no) throws Exception{
		
		
		
		Address findAddress=null; //로컬변수 선언 및 초기화
		
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_BY_NO_);
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery(); //pstmt는 준비된 statement 라서 넣으면 안된다.
		
		if(rs.next()) {
			int n=rs.getInt("no");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			findAddress = new Address(no, name, phone, address); //한개밖에 반환안되서 객체에 담아야한다.
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findAddress;
		
	}
	
	
	
	
	public List<Address> findAll() throws Exception{
		
		
		
		List<Address> addressList = new ArrayList<Address>();
		
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL); //?가 없어도 PreparedStatement 써라~
		ResultSet rs=pstmt.executeQuery(); //pstmt는 준비된 statement 라서 넣으면 안된다.
			if(rs.next()) {
			
			do{
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("address");
				Address address = new Address(no, name, phone, addr);
				addressList.add(address);
				
			}while(rs.next());
		}
			
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return addressList;
	}
	
}