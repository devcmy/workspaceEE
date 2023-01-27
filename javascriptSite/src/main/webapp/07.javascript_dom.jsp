<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function access_form() {
		let formE=document.getElementById('f');
		formE.id.value='guard';
		formE.irum.value='가아드';
		formE.style.border='1px dashed orange';
		formE.style.color='blue';
	}
	function access_div() { //div에 접근해서 내용 바꾸기.
		let div1E=document.getElementById('div1');
		let div1Content = div1E.innerHTML; //innerText(tag빼고 가져옴)
		console.log('div1content:'+div1Content);
		
		let name='송혜교';
		/*
		 template literal(``)을 사용하면 자바스트립트값을출력할수있어요
		 ex>  
				let name = '김경호';
				let msg  = ` ${name}님안녕하세요!!`;
		*/
		/*	div1E.innerHTML+="<ol>";
			div1E.innerHTML+="<li>ABC</li>";
			div1E.innerHTML+="<li>DEF</li>";
			div1E.innerHTML+="</ol>";  누적해서작성해야함 */
		
		div1E.innerHTML=`
			<ol>
				<li>박연진</li>
				<li>문동은</li>
				<li>${name}</li>
			</ol>
			<img src='penguin1.gif'>
			<img src='penguin2.gif'>
			<img src='penguin3.gif'>
		`; //`(back 키) => line에 관계없이 기술하면 된다. ,  => template literal "반드시 함수의 실행결과로 값(식) 이어야한다."
		
	}
	let count = 0;
	function access_img() {
		
		
		count = count%3;
		count++; //0이라서 처음부터 증가시켜줌
		let imgE = document.getElementById('img1');
		imgE.src='penguin'+count+'.gif';


	}
	function form_display() {
		let f=document.getElementById('f');
		
		if(f.style.visibility=='hidden'){
		f.style.visibility='visible';
		}
		
		else{
		f.style.visibility='hidden';
		}
		
	}
</script>

</head>
<body onmouseover="access_img();">
	<h1 onmouseover="form_display();">javascript dom[document object model]</h1>
	<hr>
	<form action="" name='f' id='f'>
		아이디:<input type="text" name="id" id="id"><br> 
		이 름:<input type="text" name="irum" id="irum"><br>
	</form>
	<div id="div1">div1 content</div>
	<div>
		<img id="img1" width="100" height="100" src='penguin1.gif' /> 
		<span id="span1">span1 content</span>
	</div>

	<div>
		<input type="button" value="access form" onclick="access_form();">
		<input type="button" value="access div" onclick="access_div();">
		<input type="button" value="access img" onclick="access_img();">
		<input type="button" value="form display" onclick="form_display();">
	</div>

</body>
</html>