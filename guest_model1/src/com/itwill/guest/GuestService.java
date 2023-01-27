package com.itwill.guest;

import java.util.List;

public class GuestService {
	private GuestDao guestDao;
	public GuestService() {
		guestDao = new GuestDao();
	}
	
	/*
	 * 방명록 리스트
	 */
	public List<Guest> findAll() throws Exception{
			return guestDao.findAll();
	}

	/*
	 * 업데이트 service
	 */
	public int updateGuest(Guest updateGuest) throws Exception {
		return guestDao.update(updateGuest);
	}

	/*
	 * 생성 service
	 */
	public int insertGuest(Guest insertGuest) throws Exception {
		return guestDao.insert(insertGuest);
	}

	/*
	 * 삭제 service
	 */
	public int deleteGuest(int no) throws Exception {
		return guestDao.delete(no);
	}
	
	/*
	 * 상세보기 service
	 */
	public Guest selectByNo(int no) throws Exception {
		return guestDao.findByNo(no);
	}
	
	
	
	
}
