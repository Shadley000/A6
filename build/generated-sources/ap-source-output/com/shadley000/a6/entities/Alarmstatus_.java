package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmdata;
import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Alarmstatus.class)
public class Alarmstatus_ { 

    public static volatile CollectionAttribute<Alarmstatus, Alarmdata> alarmdataCollection;
    public static volatile SingularAttribute<Alarmstatus, String> nname;
    public static volatile SingularAttribute<Alarmstatus, String> description;
    public static volatile SingularAttribute<Alarmstatus, Integer> id;
    public static volatile SingularAttribute<Alarmstatus, Installation> idInstallation;

}