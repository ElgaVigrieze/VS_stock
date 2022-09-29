package com.company.springmvcweb.data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        var m = new Message();
        var mes = (Message)m.getMessage(1);
        System.out.println(mes.getText());

//        var repo = new ItemRepository();
//        var repo1 = new ProjectRepository();
//        var f = new FTP();
//
//
////        ftp.uploadFile("D:\\Pictures\\phone 2022_06\\7.jpg");
////        File file = new File("D:\\Pictures\\phone 2022_06\\7.jpg");
////        System.out.println(Arrays.toString(ftp.downloadFtpFile("ftp://192.168.1.2:10000/EON612.jpg")));
//
////        System.out.println(ftp.listFiles("/"));
////
////        ftp.downloadFile("/EON612.jpg", "C:\\Users\\Hilgas\\Downloads\\bildes\\EON612.jpg");
//        f.open();
//

 //       f.downloadFile("/EON612.jpg", "C:\\Users\\Hilgas\\Downloads\\bildes\\EON612.jpg");

//            File file1 = new File("D:\\Pictures\\phone 2022_06\\7.jpg");
 //       File f = new File(newPath);
//        ftp.putFileToPath(f, "/7.jpg");

//        var is = f.downloadFile( "/7.jpg");
//        Image image = ImageIO.read(is);
//        System.out.println(image);
//        f.endDownload();



}

}