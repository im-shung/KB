--1)
DESC emp;

--2) 
SELECT empno, ename, hiredate, sal 
FROM emp 
WHERE ename LIKE 'K%';

--3)
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp 
WHERE hiredate LIKE '8%';

--4)
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp 
WHERE comm is not null;

--5)
SELECT ename, deptno, sal 
FROM emp 
WHERE deptno = 30 and sal >= 1500;

--6)
SELECT empno, deptno 
FROM emp 
WHERE deptno = 30 
ORDER BY empno;

--7)
SELECT ename, sal 
FROM emp 
ORDER BY sal DESC;

--8)
SELECT ename, deptno, sal 
FROM emp 
ORDER BY deptno ASC, sal DESC;

--9)
SELECT ename, deptno, sal 
FROM emp 
ORDER BY deptno DESC, ename ASC, sal DESC;

--10)
SELECT ename, sal, comm, sal+comm Total 
FROM (SELECT ename, sal, sal*comm/100 comm FROM emp) 
WHERE comm is not null 
ORDER BY Total DESC;

--11) 
SELECT ename, sal, sal*0.13 bonus, deptno 
FROM emp 
where deptno = 10;

--12) 
SELECT ename, sal, ROUND(sal/60,1) "시간당 임금" 
from emp
WHERE deptno = 20;

--13)
SELECT ename, sal, ROUND(sal*0.15, 2) 회비 
FROM emp
WHERE 1500 <= sal and sal <= 3000;

--14)
SELECT ename, sal, sal*0.9 "실 수령액" 
from EMP 
ORDER BY sal;