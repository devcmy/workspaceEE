/**
 * common.js
 */
function isSame(v1,v2){
	if(v1===v2){//type과 값이 모두 일치하면
		return true;
	}
	return false;
} //모든 페이지에 쓰는 공통 스크립트 -> common.js으로 나누는게 좋다.


function isValidId(v1){
	if(v1.length>=5 && v1.length<=10){
		return true;
	}
	return false;
}

function isStartsWithId(v1){
	let firstStr = v1.charCodeAt(0);
	
	if(firstStr>= 65 & firstStr <= 90){
	  return true;	
	}
	if(firstStr>= 97 & firstStr <= 122){
	  return true;	
	}
	return false;
}

let idReg = /^[A-za-z0-9]{5,10}$/g;

function isValidIdinclude(v1){
	if(idReg.test(v1) === true){
		return true;
	}
	return false;
}


