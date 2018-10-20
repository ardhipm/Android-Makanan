package com.example.t.makanan;

/**
 * Created by t on 8/22/2018.
 */

public class MakananActivity extends KoneksiActivity {
    String URL = "https://kemasanmakanan.000webhostapp.com";
    // /String URL = "https://kemasanmakanan.000webhostapp.com";
    String url = "";
    String response = "";

    public String tampilMakanan(){
        try {
            url = URL + "?operasi=view";
            System.out.println("URL Tampil Makanan :" +url);
            response = call(url);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String insertMakanan(String nama_makanan, String asal, String bahan_utama, String kemasan, String ph, String aktivitas_air,
                                String nilai_sterilitas, String kadar_air, String kadar_abu, String protein, String lemak, String karbohidrat,
                                String energi, String timbalpb, String kadmium, String tembaga, String seng, String timahsn, String raksa,
                                String arsen, String alt, String aerob, String coliform, String salmonella, String saureus, String perfringens,
                                String anaerob, String bacilius, String aflatoksin, String aflatoksin_total, String fraksi_larut, String mitra_ukm,
                                String foto_produk, String kondisi_proses){
        try{
            url = URL + "?operasi=insert&nama_makanan=" + nama_makanan +"&asal=" + asal + "&bahan_utama=" + bahan_utama +
                    "&kemasan=" + kemasan + "&ph=" + ph + "&aktivitas_air=" + aktivitas_air + "&nilai_sterilitas=" + nilai_sterilitas + "&kadar_air=" + kadar_air +
                    "&kadar_abu=" + kadar_abu + "&protein=" + protein + "&lemak=" + lemak + "&karbohidrat=" + karbohidrat + "&energi=" + energi + "&timbalpb=" + timbalpb +
                    "&kadmium=" + kadmium + "&tembaga=" + tembaga + "&seng=" + seng + "&timahsn=" + timahsn + "&raksa=" + raksa + "&arsen=" + arsen +
                    "&alt=" + alt + "&aerob=" + aerob + "&coliform=" + coliform + "&salmonella=" + salmonella + "&saureus=" + saureus + "&perfringens=" + perfringens +
                    "&anaerob=" + anaerob + "&bacilius=" + bacilius + "&aflatoksin=" + aflatoksin + "&aflatoksin_total=" + aflatoksin_total +
                    "&fraksi_larut=" + fraksi_larut + "&mitra_ukm=" + mitra_ukm + "&foto_produk=" + foto_produk + "&kondisi_proses=" + kondisi_proses;
            System.out.println("URL Insert Makanan : " +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String insertGambar(String foto_produk, String no){
        try{
            url = URL + "?operasi=insertgambar&no=" + no +"&foto_produk=" + foto_produk;
            System.out.println("URL Insert Makanan : " +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String getlastno(){
        try{
            url = URL + "?operasi=getlastno";
            System.out.println("URL Insert Makanan : " +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String getMakananById(int no){
        try {
            url = URL + "?operasi=viewbyid&id=" +no;
            System.out.println("URL getById : " +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String getMakananByBahan (String bahan){
        try{
            url = URL + "?operasi=viewbybahan&bahan_utama=" +bahan;
            System.out.println("URL getByBahan :" +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String getMaxValue (String field) {
        try {
            url = URL + "?operasi=viewmax&field=" + field;
            System.out.println("URL getMaxValue" + url);
            response = call(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getMinValue (String field) {
        try {
            url = URL + "?operasi=viewmin&field=" + field;
            System.out.println("URL getMinValue" + url);
            response = call(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getMakananByKarakteristik(String field,String data1, String data2) {
        try{
            url = URL + "?operasi=viewbykarakteristik1&field1="+field+"&data11="+data1+"&data12="+data2;
            System.out.println("URL getByKarakteristik :" +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String updateMakanan(String no, String nama_makanan, String asal,String bahan_utama, String kemasan, String ph,	String aktivitas_air,
                                String nilai_sterilitas,	String kadar_air,	String kadar_abu,	String protein, String lemak,	String karbohidrat,
                                String energi,  String timahpb,	String kadmium,	String tembaga,	String seng,	String timahsn,	String raksa,
                                String arsen,	String alt, String aerob,	String coliform,	String salmonella, String saureus,	String perfringens,
                                String anaerob,	String bacilius,String aflatoksin,	String aflatoksin_total, String fraksi_larut,	String mitra_ukm,
                                String foto_produk,String kondisi_proses){
        try{
            url = URL + "?operasi=update&no=" +no+ "&nama_makanan=" +nama_makanan+"&asal=" +asal+ "&bahan_utama=" +bahan_utama+
            "&kemasan=" +kemasan+ "&ph=" +ph+ "&aktivitas_air=" +aktivitas_air+ "&nilai_sterilitas=" +nilai_sterilitas+ "&kadar_air=" +kadar_air+
                    "&kadar_abu=" +kadar_abu+ "&protein=" +protein+ "&lemak=" +lemak+ "&karbohidrat=" +karbohidrat+ "&energo=" +energi+ "&timahpb=" +timahpb+
                    "&kadmium=" +kadmium+ "&tembaga=" +tembaga+ "&seng=" +seng+ "&timahsn=" +timahsn+ "&raksa=" +raksa+ "&arsen=" +arsen+
                    "&alt=" +alt+ "&aerob=" +aerob+ "&coliform=" +coliform+ "&salmonella=" +salmonella+ "&saureus=" +saureus+ "&perfringens=" +perfringens+
                    "&anaerob=" +anaerob+ "&bacilius=" +bacilius+ "&aflatoksin=" +aflatoksin+ "&aflatoksin_total=" +aflatoksin_total+
                    "&fraksi_larut=" +fraksi_larut+ "&mitra_ukm=" +mitra_ukm+ "&foto_produk=" +foto_produk+ "&kondisi_proses=" +kondisi_proses;
            System.out.println("URL Update Makanan :" +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public String deleteMakanan(String no){
        try {
            url = URL + "?operasi=delete&no=" +no;
            System.out.println("URL Delete Makanan :" +url);
            response = call(url);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
