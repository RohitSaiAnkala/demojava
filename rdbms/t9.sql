DECLARE
 CURSOR c_dept IS  select d.deptno,d.dname,d.loc,listagg(e.ename,',') as list from emp e,dept d where e.deptno(+)=d.deptno group by d.deptno,d.dname,d.loc order by d.deptno;
 v_deptno dept.deptno%TYPE ;
 v_dname  dept.dname%TYPE  ;
 v_loc    dept.loc%TYPE ;
 v_list  varchar2(100);
begin
    dbms_output.put_line('in begin of deptlist'); 
	dbms_output.put_line('-------------------------------------------------------------------');
	OPEN c_dept; 	
	
	LOOP 
		FETCH c_dept INTO v_deptno,v_dname,v_loc,v_list;
		EXIT WHEN c_dept%notfound; 
		dbms_output.put_line('Data = '  || v_deptno || ', ' ||v_dname || ', ' || v_loc);
		if v_list is null then
		dbms_output.put_line('Employee Not Found'); 
	    else
		dbms_output.put_line('Employees='||v_list);
		end if;
		dbms_output.put_line('-------------------------------------------------------------------');	
	END LOOP; 
END;
/ 