CALL ALARM_PIVOT_UPDATE("2018-01-01", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-02", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-03", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-04", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-05", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-06", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-07", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-08", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-09", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-10", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-11", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-12", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-13", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-14", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-15", 2);
CALL ALARM_PIVOT_UPDATE("2018-01-16", 2);



select distinct ALARM_DATE, ID_INSTALLATION from ALARM_DATA;

select sum(ALARM_COUNT) from ALARM_PIVOT;

select count(*) from  ALARM_DATA;


select ID, ID_ALARM_FILE, ID_ALARM_TYPE, ALARM_STATUS, ALARM_TIME  
from ALARM_DATA 
where ID_INSTALLATION = 2 
and ALARM_TIME >= '2018-01-01' 
AND ALARM_TIME < '2018-01-31' 
ORDER BY ALARM_TIME ASC