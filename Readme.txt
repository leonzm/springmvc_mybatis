mysql sql脚本
 1.sql建表
 CREATE TABLE user_info(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   uname VARCHAR(25) NOT NULL,
   unumber INT NOT NULL
 );
 CREATE TABLE course_info(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   cname VARCHAR(25) NOT NULL,
   caddress VARCHAR(255) NOT NULL
 );
 CREATE TABLE course_user_info(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   uid INT,
   cid INT,
   FOREIGN KEY(uid) REFERENCES user_info(id),
   FOREIGN KEY(cid) REFERENCES course_info(id)
 );
 CREATE TABLE photo(
   id INT NOT NULL PRIMARY KEY,
   NAME VARCHAR(25) NOT NULL,
   size INT,
   datas LONGBLOB
 );

2.插入数据
 INSERT INTO user_info(uname, unumber) VALUES ('张三', 1);
 INSERT INTO user_info(uname, unumber) VALUES ('李四', 2);
 INSERT INTO user_info(uname, unumber) VALUES ('王五', 3);

 INSERT INTO course_info(cname, caddress) VALUES ('高数', '一号楼');
 INSERT INTO course_info(cname, caddress) VALUES ('计算机', '综合楼');
 INSERT INTO course_info(cname, caddress) VALUES ('英语', '外教楼');

 INSERT INTO course_user_info(uid, cid) VALUES (1, 1);
 INSERT INTO course_user_info(uid, cid) VALUES (1, 2);
 INSERT INTO course_user_info(uid, cid) VALUES (1, 3);
 INSERT INTO course_user_info(uid, cid) VALUES (2, 1);
 INSERT INTO course_user_info(uid, cid) VALUES (2, 2);
 INSERT INTO course_user_info(uid, cid) VALUES (3, 3);

API
 1.访问单个用户
 http://localhost:8080/springmvc_mybatis/user/showInfo/1.htmls
 2.返回所有用户的json
 http://localhost:8080/springmvc_mybatis/user/showInfos.htmls

 参考：
 https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=spring%20mybatis%20mysql%20maven&oq=spring%20mybatis%20mysql&rsv_pq=d0b24cfd002a3d0b&rsv_t=ff3bu5iVeyfZsfZNTPLEgMAM%2F72GoHGYHhDNOQLgOdbcQqMzV%2BXPgpF26BM&rsv_enter=0&inputT=1199&rsv_sug3=16&rsv_sug1=6&rsv_sug7=100&rsv_sug2=0&rsv_sug4=1199