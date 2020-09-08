package com.SarkarSiddhant;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String Album_Name;
    private String Artist;
    private ArrayList<Song>SongList;

    public Album(String album_Name, String artist) {
        Album_Name = album_Name;
        Artist = artist;
        SongList=new ArrayList<>();
    }

    /*******
     *
     * @param SongName
     * @param duration
     * @return true or False if Song Added Or not
     */
    public boolean Add_Song(String SongName,double duration){
        Song Temp=new Song(SongName,duration);
        if (Check_If_Exists(SongName)==null){
            this.SongList.add(Temp);
            System.out.println("Song "+SongName+" Added");
            return true;
        }
        System.out.println("Song Withi the Name : "+SongName+" Already Exists ");
        return false;
    }
    /******
     *
     * @param Name
     * @return the object song if it exists in the this.Songlist
     * @return  null if not  present
     *
     */
    public Song Check_If_Exists(String Name){
        for (Song temp:this.SongList) {
            if (temp.getSongName().equals(Name)){
                return temp;
            }
        }
        return null;
    }

    public boolean Add_to_Playlist(String NameOfTheSong, LinkedList <Song> Playlist){
        if (Check_If_Exists(NameOfTheSong)!=null){
            Playlist.add(Check_If_Exists(NameOfTheSong));
            System.out.println("The Song "+NameOfTheSong+" Song Succesfully to the  Playlist");
            return true;
        }
        System.out.println("The Song "+NameOfTheSong+" Already Exists in the Playlist");
        return false;

    }
    public boolean Add_to_Playlist(int index, LinkedList <Song> Playlist){
        index-=1;
        if (index>0&&index<this.SongList.size()){
            Playlist.add(this.SongList.get(index));
            System.out.println("Song at INDEX " +(index+1)+"Added to The Playlist ");
            return true;
        }
        System.out.println("Song NOt Preset in Playlist ");
        return false;
    }

}
