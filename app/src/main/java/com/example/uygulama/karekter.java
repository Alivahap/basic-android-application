package com.example.uygulama;

import android.os.Parcel;
import android.os.Parcelable;

public class karekter implements Parcelable {
    int kilo;
    int hareketsayisi;
    int saldirigucu;
    String isim ="lütfen karekter ismini giriniz ";
    public String yemek(){
        if(hareketsayisi>0){
            kilo++;
            hareketsayisi--;
            return"yemek yedi ve kilosu arttı";
        }
       else
            return"yeterli hareketiniz yok";
    }
    public String uyumak(){
        if(hareketsayisi>0){

            hareketsayisi--;
            return"karekter uyudu";
        }
        else
            return"yeterli hareketiniz yok";
    }
    public String savas(){
        if(hareketsayisi>0){

            hareketsayisi--;
            saldirigucu++;
            return"karekter savaştı";
        }
        else
            return"yeterli hareketiniz yok";
    }
public String tostring(){

return   " "+ isim
        +" \n kilo"+kilo
        +"\n haraket sayisi :" + hareketsayisi
        +"\n saldırı gücü : " +saldirigucu;





}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.kilo);
        dest.writeInt(this.hareketsayisi);
        dest.writeInt(this.saldirigucu);
        dest.writeString(this.isim);
    }

    public karekter() {
    }

    protected karekter(Parcel in) {
        this.kilo = in.readInt();
        this.hareketsayisi = in.readInt();
        this.saldirigucu = in.readInt();
        this.isim = in.readString();
    }

    public static final Parcelable.Creator<karekter> CREATOR = new Parcelable.Creator<karekter>() {
        @Override
        public karekter createFromParcel(Parcel source) {
            return new karekter(source);
        }

        @Override
        public karekter[] newArray(int size) {
            return new karekter[size];
        }
    };



}
