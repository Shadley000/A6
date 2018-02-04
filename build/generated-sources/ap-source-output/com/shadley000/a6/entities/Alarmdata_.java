package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmfile;
import com.shadley000.a6.entities.Alarmstatus;
import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T07:08:55")
@StaticMetamodel(Alarmdata.class)
public class Alarmdata_ { 

    public static volatile SingularAttribute<Alarmdata, Alarmstatus> idAlarmstatus;
    public static volatile SingularAttribute<Alarmdata, Date> alarmtime;
    public static volatile SingularAttribute<Alarmdata, Alarmfile> idFile;
    public static volatile SingularAttribute<Alarmdata, Alarmtype> idAlarmtype;
    public static volatile SingularAttribute<Alarmdata, Integer> id;
    public static volatile SingularAttribute<Alarmdata, Installation> idInstallation;

}