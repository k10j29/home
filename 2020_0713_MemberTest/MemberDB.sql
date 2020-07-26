
--�Ϸù�ȣ ���� ���.. inline view ������ ���� ����Ұ���

MySQL �̳� �ٸ� ���������� ����ϴ� ��� (������ ��������ʰ�)

 (2)

select nvl(max(m_idx),0) + 1 from member


--ȸ�� Table ����� (1)

create table member
(


-- member (m)_

m_idx 				  int,           		  		-- �Ϸù�ȣ
m_id				  varchar2(100) not null,  		-- ���̵�
m_name 				  varchar2(100) not null,		-- �̸�
m_pwd				  varchar2(100) not null, 		-- �н�����
m_zipcode			  varchar2(100) not null,   	-- ���θ��ȣ
m_addr 			      varchar2(500) not null,     	-- ���ּ�
m_ip 			      varchar2(500) not null,     	-- ����� �ּ� 
m_regdate 			  date							-- ��������


)


--�÷� �߰� �Ϲ� / ������ (5)

alter table member add m_grade varchar2(100);


-- �������� 


-- �⺻Ű ���� (3)

alter table member
	add constraint pk_member_m_idx primary key(m_idx)
	
-- unique (4)

	alter table member
	add constraint unique_member_m_id unique(m_id)
	
	
	
--Sample  

	--������ ȸ�� ��� (6)

insert into member values( (select nvl(max(m_idx),0) + 1 from member),
                           'admin',
                           '������',
                           '1234',
                           '12345',
                           '���� ���� �Ÿ���',
                           '127.0.0.1',
                           sysdate,
                           '������'
                    ); 
	
	--�Ϲ� ȸ�� ��� (7)
	
		insert into member values( (select nvl(max(m_idx),0) + 1 from member),
                           'hong',
                           'ȫ�浿',
                           '1234',
                           '12345',
                           '���� ���� �Ÿ�1��',
                           '127.0.0.1',
                           sysdate,
                           '�Ϲ�'
                    ); 
                    
	
	
	select * from member
	
	select * from member where m_idx=2
	
	commit



