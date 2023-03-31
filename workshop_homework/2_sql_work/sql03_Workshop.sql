--### Equi join ###
--1) EMP�� DEPT Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿��� ����϶�.
SELECT d.deptno �μ���ȣ, dname �μ���, ename �̸�, sal �޿�
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--2) �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT ename �̸�, d.dname �μ���
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND
ename = 'SMITH';

--### Outer join ###
--3) dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ�
--��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT dname
FROM dept;

SELECT e.ename, e.deptno, d.dname, e.sal
FROM dept d, emp e
WHERE d.deptno(+) = e.deptno;

--### Self join###
--4) EMP Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�.
--��SMTH�� �Ŵ����� FORD�̴�
SELECT e.ename �̸�, m.ename �Ŵ����̸� 
FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno
AND
e.ename = 'SMITH'
ORDER BY 1;

--### Sub Query ###
--1) ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,
--�޿��� ����϶�.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal>(SELECT AVG(sal) FROM emp);

--2) 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������
--����϶�.
SELECT * FROM emp WHERE deptno=10;

SELECT empno, ename, sal
FROM emp
WHERE job IN (SELECT job FROM emp WHERE deptno=10)
ORDER BY 3 DESC;

--3) 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,
--����, �Ի����� ����϶�.
SELECT empno, ename, deptno, jon, hiredate
FROM emp

--4) ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.
--5) �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.
--6) SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻��϶�.
--2���� ����� ��� 1) �������� 2) ���̺� �˸��߽� ���
--6-1)
--6-2)
--7) �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻��϶�.
--8) ���������� �Ŵ��� ����� �˻��϶� .
--�̶� ����̸��� ����� �����ȣ�� �˻��ǵ��� �Ѵ�.
--(�⸮�߽��� ����̸�, �������ȣ)
