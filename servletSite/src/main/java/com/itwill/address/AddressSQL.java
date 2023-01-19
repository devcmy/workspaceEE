package com.itwill.address;

public class AddressSQL { //변경되지 않으니 final(완전상수)로 생성하는게 좋다.~(객체생성x)
	private AddressSQL() { //객체생성못하게
	}
	
	public static final String ADDRESS_INSERT="insert into address values(address_no_seq.nextval,?,?,?)";
	public static final String ADDRESS_UPDATE="update address set name=? , phone=?, address=? where no=?";
	public static final String ADDRESS_DELETE="delete address where no=?";
	public static final String ADDRESS_SELECT_BY_NO_="select no,name,phone,address from address where no=?";
	public static final String ADDRESS_SELECT_ALL="select no,name,phone,address from address";
}
