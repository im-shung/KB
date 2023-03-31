--### Equi join ###
--1) EMP와 DEPT Table을 JOIN하여 부서번호, 부서명, 이름, 급여를 출력하라.
SELECT d.deptno 부서번호, dname 부서명, ename 이름, sal 급여
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--2) 이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT ename 이름, d.dname 부서명
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND
ename = 'SMITH';

--### Outer join ###
--3) dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여
--모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT dname
FROM dept;

SELECT e.ename, e.deptno, d.dname, e.sal
FROM dept d, emp e
WHERE d.deptno(+) = e.deptno;

--### Self join###
--4) EMP Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라.
--‘SMTH의 매니저는 FORD이다
SELECT e.ename 이름, m.ename 매니저이름 
FROM (SELECT ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno
AND
e.ename = 'SMITH'
ORDER BY 1;

--### Sub Query ###
--1) 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서번호, 입사일,
--급여를 출력하라.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE sal>(SELECT AVG(sal) FROM emp);

--2) 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 급여를 검색..급여가 많은 순으로
--출력하라.
SELECT * FROM emp WHERE deptno=10;

SELECT empno, ename, sal
FROM emp
WHERE job IN (SELECT job FROM emp WHERE deptno=10)
ORDER BY 3 DESC;

--3) 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서번호,
--업무, 입사일을 출력하라.
SELECT empno, ename, deptno, jon, hiredate
FROM emp

--4) ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 출력하라.
--5) 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 출력하라.
--6) SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색하라.
--2가지 방법을 사용 1) 서브쿼리 2) 테이블 알리야스 사용
--6-1)
--6-2)
--7) 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색하라.
--8) 부하직원을 거느린 사원을 검색하라 .
--이때 상사이름과 상사의 사원번호가 검색되도록 한다.
--(얄리야스는 상사이름, 상사사원번호)
