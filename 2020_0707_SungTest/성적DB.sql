/*

--������(�Ϸù�ȣ ������ü) 

drop   sequence seq_sungtb_no
create sequence seq_sungtb_no

select 
  seq_sungtb_no.nextVal ������, 
  seq_sungtb_no.currVal ���簪
from dual

--���̺� ����
create table sungtb
(
   no 	int,					--�Ϸù�ȣ
   name varchar2(100) not null,	--�̸�
   kor	int default 0,			--����
   eng	int default 0,			--����
   mat	int default 0			--����
)

--��������
--PK
  alter table sungtb
    add constraint pk_sungtb_no primary key(no);
    
--Check
  alter table sungtb
    add constraint ck_sungtb_kor 
                   check(kor between 0 and 100);
                   
  alter table sungtb
    add constraint ck_sungtb_eng 
                   check(eng between 0 and 100);
  
  alter table sungtb
    add constraint ck_sungtb_mat 
                   check(mat between 0 and 100);                                            
    
--sample data
insert into sungtb values(seq_sungtb_no.nextVal,'�ϱ浿',77,88,99);
insert into sungtb values(seq_sungtb_no.nextVal, 
                          '�̱浿',97,98,99);
insert into sungtb values(seq_sungtb_no.nextVal, 
                          '��浿',87,88,89);

select * from sungtb

commit

--�����

create or replace view sungtb_view
as
	select
	  no,name,kor,eng,mat,
	  (kor+eng+mat) as tot,
	  round((kor+eng+mat)/3,1) as avg,
	  rank() over( order by (kor+eng+mat) desc) as rank
	from sungtb
	order by no

select * from sungtb_view

select * from sungtb_view where no=63













*/