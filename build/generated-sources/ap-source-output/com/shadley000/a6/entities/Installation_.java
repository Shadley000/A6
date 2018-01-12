package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmdata;
import com.shadley000.a6.entities.Alarmfile;
import com.shadley000.a6.entities.Alarmstatus;
import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Contractor;
import com.shadley000.a6.entities.Errorlog;
import com.shadley000.a6.entities.Messagetype;
import com.shadley000.a6.entities.Priority;
import com.shadley000.a6.entities.Ship;
import com.shadley000.a6.entities.Subsystem;
import com.shadley000.a6.entities.System;
import com.shadley000.a6.entities.Userspermissions;
import com.shadley000.a6.entities.Vendor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-12T08:22:36")
@StaticMetamodel(Installation.class)
public class Installation_ { 

    public static volatile SingularAttribute<Installation, Ship> idShip;
    public static volatile CollectionAttribute<Installation, Alarmfile> alarmfileCollection;
    public static volatile CollectionAttribute<Installation, Alarmstatus> alarmstatusCollection;
    public static volatile CollectionAttribute<Installation, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<Installation, Contractor> idContractor;
    public static volatile CollectionAttribute<Installation, Userspermissions> userspermissionsCollection;
    public static volatile CollectionAttribute<Installation, Messagetype> messagetypeCollection;
    public static volatile CollectionAttribute<Installation, Priority> priorityCollection;
    public static volatile SingularAttribute<Installation, Vendor> idVendor;
    public static volatile SingularAttribute<Installation, String> datadirectory;
    public static volatile CollectionAttribute<Installation, Alarmdata> alarmdataCollection;
    public static volatile CollectionAttribute<Installation, System> systemCollection;
    public static volatile SingularAttribute<Installation, String> nname;
    public static volatile CollectionAttribute<Installation, Subsystem> subsystemCollection;
    public static volatile SingularAttribute<Installation, Integer> id;
    public static volatile CollectionAttribute<Installation, Errorlog> errorlogCollection;
    public static volatile SingularAttribute<Installation, String> parsername;

}