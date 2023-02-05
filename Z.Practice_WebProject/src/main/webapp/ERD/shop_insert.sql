/****************************userinfo insert*******************************/
insert into userinfo(userid,password,name,email) values('cmy0','0000','최민영1','cmy0@itwill.com');
insert into userinfo(userid,password,name,email) values('cmy1','1111','최민영2','cmy1@itwill.com');
insert into userinfo(userid,password,name,email) values('cmy2','2222','최민영3','cmy2@itwill.com');

/**********************product insert************************/
insert into product values(product_p_no_SEQ.nextval, 'T1링', 3260000, 'T1ring.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '인터라킹 서클 링', 700000, 'interlocking-circles-ring.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '올리브 리브 바이패스 링', 2370000, 'olive-leaf-ring.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '네로우 링', 890000, 'narrow-ring.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '러브 링', 1000000, 'lovering.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '바인 서클 펜던트', 10000000, 'vine-circle-pendant.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '티파니 솔리테어 다이아몬드 펜던트', 1920000, 'solitaire-dimond-pendant.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '뱅글', 14400000, 'bangle.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '터코이즈 와이어 브레이슬릿', 4370000, 'turquoise-wire-bracelet.png','상세 정보 등...');
insert into product values(product_p_no_SEQ.nextval, '인터라킹 서클 체인 브레이슬릿', 580000, 'interlocking-bracelet.png','상세 정보 등...');

/**********************cart insert************************/
insert into cart(cart_no,userid,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,'cmy0',1,1);

/**********************orders insert************************/
insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_SEQ.nextval,'T1링외1종',sysdate,3960000,'cmy0');
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

commit;


