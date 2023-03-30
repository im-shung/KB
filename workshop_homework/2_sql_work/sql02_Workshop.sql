-- ##################  ���ڿ� �Լ� �ǽ� ######################

-- 1) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�. ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,1,3), sal FROM emp;

-- 2) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT ename, LOWER(SUBSTR(ename,1,3)) �̸�
FROM emp
WHERE LENGTH(ename) >= 6;

-- 3) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
select * from emp  where  ename='PARK';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT * FROM emp WHERE TRIM(ename) = 'PARK';

-- ##################  ���� �Լ� �ǽ� ######################

--4)�޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���.
--�̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(sal*.15, 2) ȸ��
FROM emp
WHERE 1500 <= sal and sal <= 3000; -- WHERE sal between 1500, 3000;

-- 5) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���.
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�
SELECT ename, sal, FLOOR(sal*.05) ������
FROM emp
WHERE 2000 <= sal;
-- FLOOR VS TRUNC 

-- ##################  ��¥ �Լ� �ǽ� ######################

-- 6) �Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿���
-- ����϶�.
SELECT ename, hiredate, hiredate+100 "�Ի���100����", sal FROM emp;

--7) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.
--�Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate �Ի���, ADD_MONTHS(hiredate, 6) �Ի���6������, sal �޿� FROM emp;

--8) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT ename, hiredate, LAST_DAY(hiredate) FROM emp; 
SELECT deptno, ename, LAST_DAY(hiredate)-hiredate "�ٹ��ϼ�" FROM emp;

--9) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� ��� �̸�,
--�Ի��� , ��MONDAY���� ����϶�.
SELECT empno, hiredate, NEXT_DAY(hiredate + 100, '������') "MONDAY" FROM emp;
SELECT empno, hiredate, NEXT_DAY(hiredate + 100, 2) "MONDAY" FROM emp;

--10) ������ �̸�, ����, �ټӳ���� ���Ͽ� ����϶�.
SELECT ename, TRUNC((sysdate-hiredate)/365) �ټӳ�� FROM emp;

-- ##################  ��ȯ �Լ� �ǽ� ######################

--11) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
SELECT ename, hiredate FROM emp;
SELECT ename, TO_CHAR(hiredate, 'yyyy-mm-dd') "�Ի���" FROM emp;

--12) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿� �տ� ȭ��ǥ��($), �׸���
--����(,)ǥ��, �Ҽ��� ���� 2�ڸ��� ǥ�õǵ��� �϶�.
SELECT empno, ename, TO_CHAR(sal, '$999,999.99') �޿� FROM emp;

--13) ��� ������ �̸��� �Ի��� ������ ����϶�.
SELECT ename, hiredate �Ի���, TO_CHAR(hiredate, 'DAY') �Ի���� FROM emp;