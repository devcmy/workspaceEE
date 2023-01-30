package com.itwill.user;
/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅,인증, 성능 등)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 *  - 어떤 web이나 session이나 관련된거 갖고있으면 안됨. 의존성낮추는 행위x
 */
public class UserService {
	private UserDao userDao;
	public UserService() throws Exception {
		userDao = new UserDao();
	}
	
	/*
	 * 회원가입
	 */
	public int create(User user)throws Exception{
		/*
		 * -1:아이디중복
		 *  1:회원가입성공
		 */
		if(userDao.countByUserId(user.getUserId())==1){
			//아이디 중복
			return -1;
		}else {
			//아이디 중복x -> 회원가입
			int insertRowCount = userDao.insert(user);
			return insertRowCount;
		}
	}
	
	public int login(String userId,String password) throws Exception{
		int result=-1;
		//1.아이디존재여부
		User user = userDao.findUser(userId);
		if(user==null) {
			//아이디 존재 안함
			result=0;
		}else {
			//아이디 존재함
			if(user.getPassword().equals(password)) {//웹에서 입력한 비번과 같으면
				//user.isMatchPassword(password) 이거 사용해도됨. user.java에 있음.
				//패스워드 일치
				result=2;
			}else {
				//패스워드 불일치
				result=1;
			}
		}
		return result;
	}
	/*
	 * 회원상세보기
	 */
	public User findUser(String userId)throws Exception{
		return userDao.findUser(userId);
	}
	/*
	 * 회원수정
	 */
	public int update(User user)throws Exception{
		
		return userDao.update(user);
	}
	
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId)throws Exception{
		return userDao.delete(userId);
	}
	
}


















