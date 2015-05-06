create table pages (title varchar,url varchar, primary key(title));
create table categories (category_name varchar, primary key(category_name));
create table category_page (category_name varchar, title varchar, primary key(category_name, title));


insert into pages (title) values ('FORTRAN');
insert into pages (title) values ('LISP');
insert into pages (title) values ('COBOL');
insert into pages (title) values ('Smalltalk');
insert into pages (title) values ('Pascal');
insert into pages (title) values ('C言語');
insert into pages (title) values ('Java');
insert into pages (title) values ('Perl');
insert into pages (title) values ('PHP');
insert into pages (title) values ('Python');
insert into pages (title) values ('Jython');
insert into pages (title) values ('Ruby');
insert into pages (title) values ('JRuby');
insert into pages (title) values ('Scala');
insert into pages (title) values ('Groovy');
insert into pages (title) values ('Clojure');
insert into pages (title) values ('JavaScript');
insert into pages (title) values ('Rhino');

insert into pages (title,url) values ('H2','http://www.h2database.com');
insert into pages (title,url) values ('HSQLDB','http://hsqldb.org/');
insert into pages (title,url) values ('Apache Derby','http://db.apache.org/derby/');

insert into categories (category_name) values ('プログラム言語');
insert into categories (category_name) values ('RDBMS');
insert into categories (category_name) values ('Pure Java RDBMS');

insert into category_page (category_name, title) values ('プログラム言語','FORTRAN');
insert into category_page (category_name, title) values ('プログラム言語','LISP');
insert into category_page (category_name, title) values ('プログラム言語','COBOL');
insert into category_page (category_name, title) values ('プログラム言語','Smalltalk');
insert into category_page (category_name, title) values ('プログラム言語','Pascal');
insert into category_page (category_name, title) values ('プログラム言語','C言語');
insert into category_page (category_name, title) values ('プログラム言語','Java');
insert into category_page (category_name, title) values ('プログラム言語','Perl');
insert into category_page (category_name, title) values ('プログラム言語','PHP');
insert into category_page (category_name, title) values ('プログラム言語','Python');
insert into category_page (category_name, title) values ('プログラム言語','Jython ');
insert into category_page (category_name, title) values ('プログラム言語','Ruby');
insert into category_page (category_name, title) values ('プログラム言語','JRuby');
insert into category_page (category_name, title) values ('プログラム言語','Scala');
insert into category_page (category_name, title) values ('プログラム言語','Groovy');
insert into category_page (category_name, title) values ('プログラム言語','Clojure');
insert into category_page (category_name, title) values ('プログラム言語','JavaScript');
insert into category_page (category_name, title) values ('プログラム言語','Rhino');

insert into category_page (category_name, title) values ('RDBMS','H2');
insert into category_page (category_name, title) values ('RDBMS','HSQLDB');
insert into category_page (category_name, title) values ('RDBMS','Apache Derby');

insert into category_page (category_name, title) values ('Pure Java RDBMS','H2');
insert into category_page (category_name, title) values ('Pure Java RDBMS','HSQLDB');
insert into category_page (category_name, title) values ('Pure Java RDBMS','Apache Derby');

insert into category_page (category_name, title) values ('JVMで動作','Java');
insert into category_page (category_name, title) values ('JVMで動作','Jython');
insert into category_page (category_name, title) values ('JVMで動作','JRuby');
insert into category_page (category_name, title) values ('JVMで動作','Scala');
insert into category_page (category_name, title) values ('JVMで動作','Groovy');
insert into category_page (category_name, title) values ('JVMで動作','Clojure');
insert into category_page (category_name, title) values ('JVMで動作','Rhino');
