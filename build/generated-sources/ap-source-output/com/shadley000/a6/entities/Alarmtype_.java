package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmdata;
import com.shadley000.a6.entities.Installation;
import com.shadley000.a6.entities.Messagetype;
import com.shadley000.a6.entities.Priority;
import com.shadley000.a6.entities.Subsystems;
import com.shadley000.a6.entities.Systems;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Alarmtype.class)
public class Alarmtype_ { 

    public static volatile SingularAttribute<Alarmtype, Subsystems> idSubsystems;
    public static volatile SingularAttribute<Alarmtype, String> tagname;
    public static volatile SingularAttribute<Alarmtype, Priority> idPriority;
    public static volatile SingularAttribute<Alarmtype, Messagetype> idMessagetype;
    public static volatile CollectionAttribute<Alarmtype, Alarmdata> alarmdataCollection;
    public static volatile SingularAttribute<Alarmtype, Systems> idSystems;
    public static volatile SingularAttribute<Alarmtype, String> description;
    public static volatile SingularAttribute<Alarmtype, Integer> id;
    public static volatile SingularAttribute<Alarmtype, Installation> idInstallation;

}