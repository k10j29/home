/*

--�Ϸù�ȣ ������ü
create sequence seq_visit_idx

--���� ���̺�
create table visit
(
    idx     int,     					--�Ϸù�ȣ
    name    varchar2(100)  not null,	--�ۼ���
    content varchar2(2000) not null,	--����
    pwd		varchar2(100)  not null,	--��й�ȣ
    ip		varchar2(100)  not null,	--������
    regdate date
)

--�⺻Ű
alter table visit  
  add constraint pk_visit_idx primary key(idx)
  
  
--sample data
insert into visit values(seq_visit_idx.nextVal,
                         '�ϱ浿',
                         '���� 1���̾�~~',
                         '1234',
                         '127.0.0.1',
                         sysdate );

insert into visit values(seq_visit_idx.nextVal,
                         '�̱浿',
                         '�ƽ��� 2���߳�',
                         '1234',
                         '127.0.0.1',
                         sysdate );
 
--update : where�������� ����� ó��

update visit  
         set name   ='���ر�',
             content='~~~',
             pwd='1111',
             ip='192.168.0.222',
             regdate=sysdate
where idx=7
                                                                                                    
                                                                                                                                                    
select * from visit  order by idx desc

rollback

commit
                                              




*/






