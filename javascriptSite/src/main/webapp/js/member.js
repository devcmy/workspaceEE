/**
 * member.js
 */







function join_form_validation_submit_button(){
			/*
			DOM Tree에있는 form엘레멘트객체에 접근하는방법
				1. window.document.form태그의name속성값
				   ex> window.document.joinForm
				2. window.document.forms배열객체[index]
				   ex> window.document.forms[0]
				3. document객체의 getElementById()메쏘드를 사용해서 form객체검색
				   ex> document.getElementById("form태그id속성값");
				     - HTML Tag
					     <form id='joinForm'>
					     </form>
					     (엘레멘트의 아이디는 HTML파일안에서 유일해야됩니다.)
				     - javascript
				     	 var joinFormObject = document.getElementById('joinForm');
				         (DOM Tree에서 id가 joinForm인 엘레멘트객체를반환) 
				   
			form객체안에있는 input엘레멘트객체접근방법
			    1.form객체.input태그의이름
			       ex> window.document.joinForm.id
			*/
			
			let f = document.getElementById('joinForm'); //유일함 PK검색과 같은것. 그래서 getElementByID(단수형 사용)
			
			if(f.id.value==null || f.id.value==''){
				alert('아이디를 입력하세요');
				f.id.focus();
				return false;
			}
			if(f.password.value==null || f.password.value==''){
				alert('패스워드를 입력하세요');
				f.password.focus();
				return false;
			}
			if(f.repassword.value==null || f.repassword.value==''){
				alert('패스워드 확인을 입력하세요');
				f.repassword.focus();
				return false;
			}
			if(f.name.value==null || f.name.value==''){
				alert('이름을 입력하세요');
				f.name.focus();
				return false;
			}
			if(f.address.value==null || f.address.value==''){
				alert('주소를 입력하세요');
				f.address.focus();
				return false;
			}
			if(f.password.value!==f.repassword.value){
				alert('패스워드 와 패스워드확인을 일치하여야 합니다.');
				f.password.select();
				return false;
			}
			
			
			
			
			
			
			
			
			
			return true;
			
			/*
			1.아이디는 5~10자여야한다
			2.영문알파벳대문자,소문자,숫자만 가능
			3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
			*/
			
		}
		function join_form_validation_button(){
			
			//1.validation
			let f=document.getElementById('joinForm');
			
			if(f.id.value==null || f.id.value==''){
				alert('아이디를 입력하세요');
				f.id.focus();
				return;
			}
			if(f.password.value==null || f.password.value==''){
				alert('패스워드를 입력하세요');
				f.password.focus();
				return;
			}
			if(f.repassword.value==null || f.repassword.value==''){
				alert('패스워드 확인을 입력하세요');
				f.repassword.focus();
				return;
			}
			if(f.name.value==null || f.name.value==''){
				alert('이름을 입력하세요');
				f.name.focus();
				return;
			}
			if(f.address.value==null || f.address.value==''){
				alert('주소를 입력하세요');
				f.address.focus();
				return;
			}
			if(!isSame(f.password.value,f.repassword.value)){ //같으면 밑에 들어가면 안된다.
				alert('패스워드 와 패스워드확인을 일치하여야 합니다.');
				f.password.select();
				return;
			}
			
			if(!isValidId(f.id.value)){
				alert('아이디를 5자이상 10자이하로 입력하시오.')
				f.id.select();
				return;
			}
			
			if(!isStartsWithId(f.id.value)){
				alert('아이디 첫글자는 영대문자 및 영소문자 만 가능합니다.')
				f.id.select();
				return;
			}
			
			if(!isValidIdinclude(f.id.value)){
				alert('아이디는 영문과 숫자만 가능합니다')
				f.id.select();
				return;
			}
			
			
			//2.form.submit();
			f.method='POST';
			f.action='join_ultra_action.jsp';
			f.submit();
			
			return;
			
		}	