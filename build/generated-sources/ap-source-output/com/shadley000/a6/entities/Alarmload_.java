package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Installation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Alarmload.class)
public class Alarmload_ { 

    public static volatile SingularAttribute<Alarmload, String> tagname;
    public static volatile SingularAttribute<Alarmload, String> alarmStatus;
    public static volatile SingularAttribute<Alarmload, String> system;
    public static volatile SingularAttribute<Alarmload, String> messagetype;
    public static volatile SingularAttribute<Alarmload, Date> alarmTime;
    public static volatile SingularAttribute<Alarmload, String> subsystem;
    public static volatile SingularAttribute<Alarmload, String> description;
    public static volatile SingularAttribute<Alarmload, Integer> id;
    public static volatile SingularAttribute<Alarmload, Installation> idInstallation;
    public static volatile SingularAttribute<Alarmload, String> priority;

}