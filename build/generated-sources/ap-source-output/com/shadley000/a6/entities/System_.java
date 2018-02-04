package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-03T07:08:55")
@StaticMetamodel(System.class)
public class System_ { 

    public static volatile SingularAttribute<System, String> nname;
    public static volatile SingularAttribute<System, String> description;
    public static volatile CollectionAttribute<System, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<System, Integer> id;
    public static volatile SingularAttribute<System, Installation> idInstallation;

}