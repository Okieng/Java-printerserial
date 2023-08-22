/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testprint;
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.*;
import java.util.logging.*;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;


/**
 *
 * @author yogi
 */
public class TestPrint {
    public static void main(String[] args) {
        SerialPort serialPort = SerialPort.getCommPort("COM4");
        
        if (serialPort.openPort()) {
            System.out.println("Port serial terbuka.");
            
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin mencetak?", "Konfirmasi Cetak", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
                printData(serialPort);
            } else {
                System.out.println("Cetak dibatalkan.");
            }
            
            serialPort.closePort();
        } else {
            System.out.println("Gagal membuka port serial.");
        }
}
    public static void printData(SerialPort serialPort) {
        try {
            OutputStream outputStream = serialPort.getOutputStream();
            
            // Data yang ingin dicetak
            String dataToPrint = "Hello, Printer!\r\n";
            
            // Konversi string ke array byte dan kirim ke printer
            byte[] dataBytes = dataToPrint.getBytes();
            outputStream.write(dataBytes);
            outputStream.flush();
            
            System.out.println("Data berhasil dikirim ke printer.");
            
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

