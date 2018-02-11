package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Userspermissions;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-10T18:59:36")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile SingularAttribute<Permission, String> nname;
    public static volatile SingularAttribute<Permission, Integer> id;
    public static volatile CollectionAttribute<Permission, Userspermissions> userspermissionsCollection;

}