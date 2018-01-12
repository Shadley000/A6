package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmtype;
import com.shadley000.a6.entities.Installation;
import com.shadley000.a6.entities.Systems;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Subsystems.class)
public class Subsystems_ { 

    public static volatile SingularAttribute<Subsystems, String> nname;
    public static volatile SingularAttribute<Subsystems, Systems> idSystems;
    public static volatile SingularAttribute<Subsystems, String> description;
    public static volatile CollectionAttribute<Subsystems, Alarmtype> alarmtypeCollection;
    public static volatile SingularAttribute<Subsystems, Integer> id;
    public static volatile SingularAttribute<Subsystems, Installation> idInstallation;

}