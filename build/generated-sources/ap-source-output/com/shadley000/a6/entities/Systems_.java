package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import com.shadley000.a6.entities.Subsystems;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Systems.class)
public class Systems_ { 

    public static volatile CollectionAttribute<Systems, Subsystems> subsystemsCollection;
    public static volatile SingularAttribute<Systems, String> nname;
    public static volatile SingularAttribute<Systems, String> description;
    public static volatile CollectionAttribute<Systems, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<Systems, Integer> id;
    public static volatile SingularAttribute<Systems, Installation> idInstallation;

}