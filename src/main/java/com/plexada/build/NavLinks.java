/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.build;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAP Training
 */
public class NavLinks {
    private static List<Link> list;
    private static Link link = new Link();
    
    public List<Link> registrationSidebarLinks(){
        list =  new ArrayList();
        link.setHref("/account/");
        link.setValue("Particulars for business (for MDAs, public and private companies)");
        list.add(link);
        link = new Link();
        link.setHref("/account/second-page");
        link.setValue("Total Emolument");
        list.add(link);
        link = new Link();
        link.setHref("/account/third-page"); 
        link.setValue("Business sector categories");
        list.add(link);
        link = new Link();
        link.setHref("/account/fourth-page"); 
        link.setValue("Particulars of owner(s) of organization (for  partnership & sole proprietorship)");
        list.add(link);
        link = new Link();
        link.setHref("/account/fifth-page");
        link.setValue("Declaration by employer or authorized person");
        list.add(link);
        link = new Link();
        link.setHref("/account/preview");
        link.setValue("Preview Registration");
        list.add(link);
        return list;
    }
    
    public static List<Link> occupationSidebarLinks(){
        list =  new ArrayList();
        link.setHref("/notification/occupational-disease/employee");
        link.setValue("Employee Details");
        list.add(link);
        link = new Link();
        link.setHref("/notification/occupational-disease/disease");
        link.setValue("Occupational Disease");
        list.add(link);
        link = new Link();
        link.setHref("/notification/occupational-disease/attestation");
        link.setValue("Attestation");
        list.add(link);
        return list;
    }
    
    public static List<Link> accidentSidebarLinks(){
        list =  new ArrayList();
        link.setHref("/notification/accident/employee");
        link.setValue("Employee Details");
        list.add(link);
        link = new Link();
        link.setHref("/notification/accident/accident");
        link.setValue("Accident");
        list.add(link);
        link = new Link();
        link.setHref("/notification/accident/attestation");
        link.setValue("Attestation");
        list.add(link);
        return list;
    }
    
    public static List<Link> ECSSidebarLinks(){
        list =  new ArrayList();
        link.setHref("/ecs/dashboard");
        link.setValue("Dashboard");
        list.add(link);
        link = new Link();
        link.setHref("/ecs/notification-type");
        link.setValue("Notification of Occupation diseases / Accident ");
        list.add(link);
        link = new Link();
        link.setHref("/compensation/step1");
        link.setValue("Compensation Request");
        list.add(link);
        link = new Link();
        link.setHref("/ecs/subscription");
        link.setValue("Subscription");
        list.add(link);
        link = new Link();
        link.setHref("/password/recovery");
        link.setValue("Change Password");
        list.add(link);
        return list;
    }
    
    public static List<Link> ECSLoginSidebarLinks(){
        list =  new ArrayList();
        link.setHref("/ecs/login");
        link.setValue("Login");
        link.add(link);
        return list;
    }
    
    /*
     Employer and Employee Details


Attachments
Bank Details & Attestion
    */
    public static List<Link> claimsSidebarLink(){
        list =  new ArrayList();
        link.setHref("/compensation/step1");
        link.setValue("Employer and Employee Details");
        list.add(link);
        link = new Link();
        link.setHref("/compensation/step2");
        link.setValue("Details of Treatment Bill");
        list.add(link);
        link = new Link();
        link.setHref("/compensation/step3");
        link.setValue("Attachments");
        list.add(link);
        link = new Link();
        link.setHref("/compensation/step4");
        link.setValue("Bank Details & Attestion");
        list.add(link);
        link = new Link();
        link.setHref("/password/recovery");
        link.setValue("Change Password");
        list.add(link);
        return list;
    }
}
