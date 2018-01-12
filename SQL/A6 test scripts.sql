

SELECT U.NNAME,C.NNAME, S.NNAME, V.NNAME, I.NNAME, P.NNAME
    FROM USERS U, INSTALLATION I, PERMISSIONS P, USERSPERMISSIONS X, CONTRACTOR C, SHIP S, VENDOR V
    WHERE 
		X.ID_PERMISSIONS = P.ID
        AND X.ID_USERS = U.ID
        AND X.ID_INSTALLATION = I.ID
        AND I.ID_CONTRACTOR = C.ID
        AND I.ID_SHIP = S.ID
		AND I.ID_VENDOR = V.ID
	order by U.NNAME,C.NNAME, S.NNAME, V.NNAME, I.NNAME, P.NNAME;
        
        select * from INSTALLATION;
        
        SELECT V.ID from VENDOR V, INSTALLATION I where i.ID_VENDOR = V.ID;
	
         
        
       
         select * from SYSTEM  order by NNAME;
         select * from SUBSYSTEM order by NNAME;
         select * from MESSAGETYPE order by NNAME;
         select * from PRIORITY order by NNAME;
         
    select * from ALARMLOAD;  
      select COUNT(*) from ALARMDATA;
  select distinct ID_ALARMTYPE from ALARMDATA;
  SELECT * FROM ALARMTYPE;
  