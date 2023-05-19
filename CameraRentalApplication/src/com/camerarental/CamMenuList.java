package com.camerarental;

import java.util.ArrayList;
import java.util.Scanner;

public class CamMenuList {

    static Scanner sc = new Scanner( System.in );

    static ArrayList< CamDetails > camList = new ArrayList<>( );
    

    static MyWallet wallet = new MyWallet( );
    public static void intialvalue(){
        camList.add(new CamDetails("Canon", "EOS2D", 1000.0));
        camList.add(new CamDetails("Nikon", "D3500", 1255.0));
        camList.add(new CamDetails("Kodak", "D2500", 2500.0));
        camList.add(new CamDetails("Canon", "D6500", 4000.0));
        camList.add(new CamDetails("Canon", "D3700", 5000.0));
    }
    public static void menuList( ) {
    	
    	System.out.println("---------------------"); 
        System.out.println( "        MENU       " );
        System.out.println("---------------------");
        System.out.println( "1. MY CAMERA" );
        System.out.println( "2. RENT A CAMERA" );
        System.out.println( "3. VIEW ALL CAMERAS" );
        System.out.println( "4. MY WALLET" );
        System.out.println( "5. EXIT" );
        System.out.println("---------------------");
        //System.out.println("Enter Your Choice:-");
        int ch = Integer.parseInt( sc.nextLine( ) );
        switch ( ch ) {
            case 1:
                myCamOpt( );
                break;

            case 2:
                displayCam();
                System.out.println( "ENTER THE CAMERA ID IF YOU WANT TO RENT - " );
                int cId = Integer.parseInt(sc.nextLine( ));
                rentCam( cId, wallet );
                break;

            case 3:
                displayCam();
                menuList();
                break;

            case 4:
                walletCam( wallet );
                break;

            case 5:
                System.exit( 0 );
                break;

            default:
                System.out.println( "WRONG CHOICE!!" );

        }

    }


	private static void myCamOpt( ) {
		System.out.println("---------------------"); 
        System.out.println( "1. ADD" );
        System.out.println( "2. REMOVE" );
        System.out.println( "3. VIEW MY CAMERAS" );
        System.out.println( "4. GO TO PREVIOUS MENU");
        System.out.println("---------------------"); 
        //System.out.println("Enter Choice");
        int choice = Integer.parseInt( sc.nextLine( ) );
        switch ( choice ) {
            case 1:
                addCam( );
                break;

            case 2:
                displayCam();
                System.out.println( "ENTER THE CAMERA ID TO REMOVE - " );
                int cId = Integer.parseInt(sc.nextLine( ));
                removeCam( cId );
                break;

            case 3:
                displayCam();
                myCamOpt( );
                break;

            case 4:
                menuList( );
                break;

            case 5:
                System.exit( 0 );
                break;

            default:
                System.out.println( "WRONG CHOICE!!" );
        }
    }

   /* Add camera in list*/
    private static void addCam( ) {
         try{
             System.out.println( "ENTER THE CAMERA BRAND - " );
             String brand = sc.nextLine( );
             System.out.println( "ENTER THE CAMERA MODEL - " );
             String model = sc.nextLine( );
             System.out.println( "ENTER THE PER DAY PRICE (INR) - " );
             double price = Integer.parseInt( sc.nextLine( ) );
             if ( camList.add( new CamDetails( brand, model, price ) ) ) {
                 System.out.println( "YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST." );
                 myCamOpt( );
             }
         }
         catch (Exception e){
             System.out.println("Enter valid price");
             myCamOpt( );
         }

    }
    /* Add camera in list*/
    private static void displayCam() {
        if ( camList.isEmpty( ) ) {
            System.out.println( "NO DATA PRESENT AT THIS MOMENT." );
            return;
        }

        System.out.println( "FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) - " );
        System.out.println("---------------------------------------------------------------------------------");
        System.out.print( "|  CAMERA ID   "+ "|   BRAND   " + "|   MODEL   " + "|  PRICE(PER DAY)   " + "|    STATUS    |\n");
        System.out.println("----------------------------------------------------------------------------------");
        for ( CamDetails camera : camList ) {
            if ( camera.getStatus( ) ) {
                System.out.println("|"+"    "+    camera.getCamId( )  +"        "+" |  " +"   "+ camera.getBrand( ) + "  |   " + camera.getModel( ) + "  |  "+"    "+ camera.getPricePerDay( ) +"      "+ " |  " + "AVAILABLE"+"   "+"|" );
                continue;
            }
            System.out.println("|"+"    "+ camera.getCamId( ) +"        "+" |  " +"   "+ camera.getBrand( ) +"  |   " + camera.getModel( )  + "  |  "+"    "+ camera.getPricePerDay( )+"      "+ " |  " +"RENTED"+"    "+"|" );
        }
        return;
    }
    /* Remove camera list*/
    private static void removeCam( int cId ) {

        ArrayList< CamDetails > tempList = new ArrayList<>( );
        for ( CamDetails c : camList ) {
            if ( c.getCamId( ) == cId ) {
                continue;
            }
            tempList.add( c );
        }
        camList = tempList;
        System.out.println( "CAMERA SUCCESSFULLY REMOVED FROM THE LIST." );
        myCamOpt( );
    }
    /* Rent Camera list*/
    private static void rentCam( int cId, MyWallet wallet ) {

        for ( CamDetails c : camList ) {
            if ( c.getCamId( ) == cId && c.getPricePerDay( ) <= wallet.getRupees( ) ) {
                c.setStatus( false );

                wallet.setRupees(wallet.getRupees()- c.getPricePerDay());
                System.out.println( "YOUR TRANSACTION FOR CAMERA " + " " + c.getBrand( ) + " " + c.getModel( )+ " " +" with rent INR."
                        + c.getPricePerDay( ) + " " + " HAS SUCCESSFULLY COMPLETED." );
                menuList( );
                return;
            }
        }
        System.out.println( "ERROR : TRANSACTION FAILED DUE TO INSUFFICIENT BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET." );
        menuList( );
    }
    /* Wallet camera list*/
    private static void walletCam( MyWallet wallet ) {
        try {
            System.out.println( "YOUR CURRENT WALLET BALANCE IS - " + wallet.getRupees( ) );

            System.out.println( "DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO) - " );
            int dec = Integer.parseInt( sc.nextLine( ) );
            if ( dec == 1 ) {
                System.out.println( "ENTER THE AMOUNT (INR) - " );
                int newAmount = Integer.parseInt( sc.nextLine( ) );
                wallet.setRupees( wallet.getRupees( )+newAmount );
                System.out.println( "YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR." + wallet.getRupees( ) );
            }
            menuList( );
        }
        catch (Exception e){
            System.out.println("Insert Numeric Value");
            menuList( );
        }
        }

}
