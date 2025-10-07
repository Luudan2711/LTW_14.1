package org.ex.ch14_email_java;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserUtil {
    private static  final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("emailListPU");
    public  static  EntityManagerFactory getEmFactory(){
        return  emf;
    }
}
