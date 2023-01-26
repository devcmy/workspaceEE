/**
 * common.js
 */
function isSame(v1,v2){
	if(v1===v2){//type과 값이 모두 일치하면
		return true;
	}
	return false;
} //모든 페이지에 쓰는 공통 스크립트 -> common.js으로 나누는게 좋다.