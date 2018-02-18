package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Installation;
import com.shadley000.a6.entities.Permission;
import com.shadley000.a6.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-18T15:34:06")
@StaticMetamodel(Userspermissions.class)
public class Userspermissions_ { 

    public static volatile SingularAttribute<Userspermissions, Permission> idPermission;
    public static volatile SingularAttribute<Userspermissions, Integer> id;
    public static volatile SingularAttribute<Userspermissions, Users> idUsers;
    public static volatile SingularAttribute<Userspermissions, Installation> idInstallation;

}