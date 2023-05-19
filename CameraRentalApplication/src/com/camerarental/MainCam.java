package com.camerarental;


import java.util.Scanner;

public class MainCam {

    static Scanner sc = new Scanner ( System.in );



    public static void main ( String[] args ) {

    	System.out.println("--------------------------------");
        System.out.println ("| WELCOME TO CAMERA RENTAL APP  |" );
        System.out.println("--------------------------------");
        System.out.println ( "PLEASE LOGIN TO CONTINUE - " );
        System.out.println ( "USERNAME - " );
        String userName = sc.next ( );
        System.out.println ( "PASSWORD - " );
        String password = sc.next ( );

        Admin ad = new Admin ( );
        if ( ad.accountVerify ( userName , password ) ) {
            CamMenuList cm = new CamMenuList ( );
            /*Call the predefined array list*/
            cm.intialvalue();

            cm.menuList ( );
        } else {
            System.out.println ( "USERNAME OR PASSWORD INCORRECT." );
        }
    }
}
