--1) 30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT ROUND(AVG(sal), 3) ���, MAX(sal) �ְ�, MIN(sal) ����, COUNT(empno) �ο���
FROM emp
WHERE deptno = 30;
--2) �� �μ��� �޿��� ���(�Ҽ� ���� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno �μ�, CEIL(AVG(sal)) ���, MAX(sal) �ְ�, MIN(sal) ����, COUNT(empno) �ο���
FROM emp
GROUP BY deptno;
--3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno �μ�, job ����, COUNT(empno) �ο���
FROM emp
GROUP BY GROUPING SETS(deptno, job)
ORDER BY 1;
--4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο����� ����϶�.
SELECT job ����, COUNT(empno) �ο���
FROM emp
GROUP BY job
HAVING COUNT(job) >= 2;
--5) �� �μ��� ��� ����(�Ҽ� ���� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ���
--������ ���� ������ ����϶�.
SELECT deptno �μ�, TRUNC(AVG(sal)) "��� ����", SUM(sal) "��ü ����", MAX(sal) "�ְ� ����", MIN(sal) "���� ����"
FROM emp
GROUP BY deptno
ORDER BY TRUNC(AVG(sal)) DESC;
--6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �� �޿���
--�Ұ�� ������ ����϶�. �μ��� �����Ѵ�.
SELECT deptno �μ���ȣ, job ����, SUM(sal) "������ �� �޿�"
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1;
--7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno �μ�, COUNT(empno) �ο���
FROM emp
GROUP BY deptno
HAVING 5 <= COUNT(empno);
--8) �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���� ������
--��ȸ������� ���ܽ�Ų��.
SELECT deptno �μ�, MAX(sal) �ִ�޿�, MIN(sal) �ּұ޿�
FROM emp
GROUP BY deptno
HAVING  MAX(sal) != MIN(sal)
ORDER BY 1;

--9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
--�������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
--��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
--�μ� ���� ��µǵ��� �ؾ� �Ѵ�.
SELECT deptno �μ�, AVG(sal) "��� �޿�"
FROM emp
WHERE deptno IN (10, 20, 30) AND sal BETWEEN 2500 AND 5000
GROUP BY deptno
HAVING AVG(


