package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-10T19:17:31")
@StaticMetamodel(Messagetype.class)
public class Messagetype_ { 

    public static volatile SingularAttribute<Messagetype, String> nname;
    public static volatile SingularAttribute<Messagetype, String> description;
    public static volatile CollectionAttribute<Messagetype, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<Messagetype, Integer> id;
    public static volatile SingularAttribute<Messagetype, Installation> idInstallation;

}