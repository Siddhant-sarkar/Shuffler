package com.SarkarSiddhant;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Album>Albums=new ArrayList<>();


    public static void main(String[] args) {
        Album album=new Album("Im The Thunder","Eagles");
        album.Add_Song("Im The Thunder",4.2);
        album.Add_Song("knsurv",5.3);
        album.Add_Song("farw",6.9);
        album.Add_Song("aergad",7.8);
        album.Add_Song("aergaerg",1.2);
        album.Add_Song("etnu",3.2);
        Albums.add(album);

        LinkedList<Song>Playlist=new LinkedList<>();

        Albums.get(0).Add_to_Playlist("Lightning",Playlist);
        Albums.get(0).Add_to_Playlist("knsurv",Playlist);
        Albums.get(0).Add_to_Playlist("farw",Playlist);
        Albums.get(0).Add_to_Playlist("aergaerg",Playlist);
        Albums.get(0).Add_to_Playlist("etnu",Playlist);
        Albums.get(0).Add_to_Playlist("aergad",Playlist);

        App(Playlist);

    }

    /******
     * This method only works on the linked
     * to perform various function
     * moving iterator forwads,backward,loop on to itsef
     */
    public static void App(LinkedList<Song>Playlist){
        ListIterator<Song>I=Playlist.listIterator();

        System.out.println();
        System.out.println();
        System.out.println("Now Playing Song : "+I.next().getSongName()+" Please Enjoy!!!!");
        System.out.println();
        System.out.println();
        boolean goingForward=true;
        boolean quit=false;
        print_mene();

        while(!quit){
            int i =scanner.nextInt();
            scanner.nextLine();

            switch (i){
                case 0:
                    System.out.println("Closing the Playlist Application");
                    quit=true;
                    break;
                case 1:
                    if(!goingForward){
                        if (I.hasNext()){
                            I.next();
                            goingForward=true;
                        }
                    }
                    System.out.println("Moving Forwards ");
                    System.out.println(I.next().getSongName());
                    break;
                case 2:
                    if(goingForward){
                        if (I.hasPrevious()){
                            I.previous();
                            goingForward=false;
                        }
                    }
                    System.out.println("Moving backwards ");
                    System.out.println(I.previous().getSongName());
                    break;
                case 3:
                    if (goingForward){
                        if (I.hasNext()){
                            System.out.println(I.previous().getSongName());
                            I.next();
                        }
                        else{
                            System.out.println("Sorry Cant go Further more THe end of the List reached");
                        }
                    }
                    else{
                        if(I.hasPrevious()){
                            if (I.hasPrevious()){
                                System.out.println(I.next().getSongName());
                                I.previous();
                            }
                        }
                        else{
                            System.out.println("Sorry Cant go Further more THe beginning of the List reached");

                        }
                    }
                    break;
                case 4:
                    Print_Playlist(Playlist);
                    break;
                case 5:

                    break;


            }
        }
    }

    /*****
     *
     * @param Playlist
     * @return true if list is non-empty And print the list
     * false if nothing in the list
     */
    public static Boolean Print_Playlist(LinkedList <Song>Playlist){
        if (Playlist.isEmpty()){
            System.out.println(" Sorry your Playlist is Empty .... :C");
            return false;
        }
        System.out.println("*******=======*******=======");
        for (Song s:Playlist) {
            System.out.println(s.getSongName());
        }
        System.out.println("*******=======*******=======");
        return true;
    }
    public static void print_mene(){
        System.out.println("***************************************");
        System.out.println("Press 0 : quit " );
        System.out.println("Press 1 : Move Forward");
        System.out.println("Press 2 : Move Backward");
        System.out.println("Press 3 : Replay the Current Song");
        System.out.println("Press 4 : Print The Song Playlist");
        System.out.println("Press 5 : Remove the Song from the Playlist");
        System.out.println("***************************************");
    }
    
}
