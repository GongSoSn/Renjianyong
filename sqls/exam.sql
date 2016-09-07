use test;

/*查询工资在2000到2500的员工情况*/
select * from emp where sal between 2000 and 2500;
select * from emp where sal >= 2000 and sal <= 2500;

/*显示首字母为S的员工的姓名和工资*/
select ename '姓名',sal '工资' from emp where ename like 'S%';

/*显示empno为123,345,800..的雇员情况*/
select * from emp where empno in (123,345,880);

/*显示员工最低和最高工资*/
select min(sal) '最低工资',max(sal) '最高工资' from emp;

/*显示员工平均工资和总工资*/
select avg(sal) '平均工资',sum(sal) '总工资' from emp;

/*（高级）显示高于平均工资雇员的姓名和工资,并显示平均工资*/
select ename,sal from emp where sal > (select avg(sal) from emp);
select ename,sal,avg(sal) from emp where sal > (select avg(sal) from emp);
select avg(sal) s from emp;

select ename '雇员姓名', sal '工资' , avg_sal.s '平均工资' from emp,(select avg(sal) s from emp) avg_sal where sal > avg_sal.s;

/*显示员工人数*/
select count(*) from emp;
select count(empno) from emp;

/*显示每个部门的平均工资和最高工资*/
select deptno '部门编号',avg(sal) '平均工资',max(sal) '最高工资' from emp group by deptno;
select d.deptno '部门编号',d.dname '部门名称', avg(e.sal) '平均工资',max(e.sal) '最高工资' from emp e right join dept d on e.deptno = d.deptno group by d.deptno; 

/*显示每个部门的每种岗位的平均工资和最低工资*/
select e.job '工作岗位',avg(e.sal) '平均工资',min(sal) '最低工资' from emp e right join  dept d on e.deptno = d.deptno group by e.job;
select ename,d.dname from emp full join dept d;

/*显示平均工资低于2000的部门和他的平均工资*/
select deptno '部门编号',avg(sal) '平均工资' from emp group by deptno having avg(sal) < 2000;

/*显示部门号为10的部门名，员工名和工资*/
select dname '部门名',ename '员工名',sal '工资' from emp e inner join dept d on d.deptno = e.deptno where d.deptno = 10;
select dname '部门名',ename '员工名',sal '工资' from emp e left join dept d on d.deptno = e.deptno where d.deptno = 10;

/*显示雇员名，雇员工资及所在部门的名字，并按部门排序*/
select ename '雇员名',sal '雇员工资',e.deptno '部门编号',dname '部门名' from emp e inner join dept d on e.deptno = d.deptno order by e.deptno;

/*显示某员工的上级领导的姓名，比如“FORD”的上级*/
select e1.ename '员工',e2.ename '领导' from emp e1 ,emp e2 where e1.mgr = e2.empno and e1.ename = 'FORD';


/*显示公司每个员工名字和他上级的名字*/
select e1.ename '员工',e2.ename '领导' from emp e1 ,emp e2 where e1.mgr = e2.empno;
select e1.ename '员工',e2.ename '领导' from emp e1 left join emp e2 on e1.mgr = e2.empno;
select * from emp;

/*显示与SMITH同一部门的所有员工(单行子查询)*/
select * from emp where deptno = (select deptno from emp where ename = 'SMITH');

/*显示和部门10的工作相同的雇员名字，岗位，工资和部门号。（多行子查询）（部门包括10）*/
select ename '员工姓名',job '岗位',sal '工资',deptno '部门号' from emp where job in (select job from emp where deptno = 10);

/*显示和部门10的工作相同的雇员名字，岗位，工资和部门号。（多行子查询）（部门不包括10）*/
select ename '员工姓名',job '岗位',sal '工资',deptno '部门号' from emp where job in (select job from emp where deptno = 10) and deptno <> 10;

/*显示高于部门平均工资的员工信息。*/
select avg(s.dept_sal) from (select avg(sal) dept_sal from emp group by deptno) s;
select * from emp where sal > (select avg(s.dept_sal) from (select avg(sal) dept_sal from emp group by deptno) s);

/*显示第5到第10入职雇员（按时间的先后）*/
desc emp;
select * from emp order by hiredate limit 4,6;

/*显示公司每位员工和他的上级名字，没有上级的名字也要显示*/
select e1.ename '员工',e2.ename '领导' from emp e1 left join emp e2 on e1.mgr = e2.empno;

