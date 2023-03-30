-- ##################  문자열 함수 실습 ######################

-- 1) 직원 정보 중 사원번호, 이름, 급여를 출력한다. 단, 이름은 앞에서 3글자씩만 출력하라.
SELECT empno, SUBSTR(ename,1,3), sal FROM emp;

-- 2) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 이름만을 출력하라.
SELECT ename, LOWER(SUBSTR(ename,1,3)) 이름
FROM emp
WHERE LENGTH(ename) >= 6;

-- 3) 직원정보를 입력하던중 아래와 같이 입력 되었다.(이름에 공백이 입력됨)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- 이름이 'PARK'인 직원의 정보를 출력하여 보자.
select * from emp  where  ename='PARK';

-- 이름 좌우에 공백이 있더라도 공백을 제거하고 이름이 'PARK'인 직원의 정보를 출력하여 보자.
SELECT * FROM emp WHERE TRIM(ename) = 'PARK';

-- ##################  숫자 함수 실습 ######################

--4)급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다.
--이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
SELECT ename, sal, ROUND(sal*.15, 2) 회비
FROM emp
WHERE 1500 <= sal and sal <= 3000; -- WHERE sal between 1500, 3000;

-- 5) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기 로 하였다.
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라
SELECT ename, sal, FLOOR(sal*.05) 경조비
FROM emp
WHERE 2000 <= sal;
-- FLOOR VS TRUNC 

-- ##################  날짜 함수 실습 ######################

-- 6) 입사일로부터 100일이 지난 후를 구해보자. 사원이름, 입사일, 100일 후의 날, 급여를
-- 출력하라.
SELECT ename, hiredate, hiredate+100 "입사일100일후", sal FROM emp;

--7) 입사일로부터 6개월이 지난 후의 날짜를 구하려고 한다.
--입사일, 6개월 후의 날짜, 급여를 출력하라
SELECT hiredate 입사일, ADD_MONTHS(hiredate, 6) 입사일6개월후, sal 급여 FROM emp;

--8) 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.
SELECT ename, hiredate, LAST_DAY(hiredate) FROM emp; 
SELECT deptno, ename, LAST_DAY(hiredate)-hiredate "근무일수" FROM emp;

--9) 모든 사원의 입사일 기준으로 100일이 지난 후의 월요일의 날짜를 구해서 사원 이름,
--입사일 , ’MONDAY’를 출력하라.
SELECT empno, hiredate, NEXT_DAY(hiredate + 100, '월요일') "MONDAY" FROM emp;
SELECT empno, hiredate, NEXT_DAY(hiredate + 100, 2) "MONDAY" FROM emp;

--10) 직원의 이름, 업무, 근속년수를 구하여 출력하라.
SELECT ename, TRUNC((sysdate-hiredate)/365) 근속년수 FROM emp;

-- ##################  변환 함수 실습 ######################

--11) 모든 직원의 이름과 입사일을 ‘1996-05-14’의 형태로 출력 하라.
SELECT ename, hiredate FROM emp;
SELECT ename, TO_CHAR(hiredate, 'yyyy-mm-dd') "입사일" FROM emp;

--12) 모든 직원의 번호, 이름, 급여를 출력하라. 단, 급여 앞에 화폐표시($), 그리고
--단위(,)표시, 소수점 이하 2자리가 표시되도록 하라.
SELECT empno, ename, TO_CHAR(sal, '$999,999.99') 급여 FROM emp;

--13) 모든 직원의 이름과 입사한 요일을 출력하라.
SELECT ename, hiredate 입사일, TO_CHAR(hiredate, 'DAY') 입사요일 FROM emp;