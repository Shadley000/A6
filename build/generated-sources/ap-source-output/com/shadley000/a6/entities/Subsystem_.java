package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-12T08:22:36")
@StaticMetamodel(Subsystem.class)
public class Subsystem_ { 

    public static volatile SingularAttribute<Subsystem, String> nname;
    public static volatile SingularAttribute<Subsystem, String> description;
    public static volatile CollectionAttribute<Subsystem, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<Subsystem, Integer> id;
    public static volatile SingularAttribute<Subsystem, Installation> idInstallation;

}