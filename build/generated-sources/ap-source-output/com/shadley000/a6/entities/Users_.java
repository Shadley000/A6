package com.shadley000.a6.entities;

import com.shadley000.a6.entities.Alarmfile;
import com.shadley000.a6.entities.Userspermissions;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-11T16:44:08")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> userPassword;
    public static volatile CollectionAttribute<Users, Alarmfile> alarmfileCollection;
    public static volatile SingularAttribute<Users, String> nname;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Userspermissions> userspermissionsCollection;

}