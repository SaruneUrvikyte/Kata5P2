package main;

import java.io.IOException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata5P2 {
    
    private static final String fileName = "src\\email.txt";
    private static List <Mail> mailList;
    private static Histogram <String> histogram;
    private static HistogramDisplay histoDisplay;
    private static MailListReader mLR = new MailListReader();
    private static MailHistogramBuilder mHB = new MailHistogramBuilder();
        
    public static void main(String[] args) throws Exception{
        
        Kata5P2 kata4 = new Kata5P2();
        kata4.control();   
    }
    
    private void control() throws IOException{
        input();
        process();
        output();
    }
    
    private void input(){
        mailList = mLR.read(fileName);
    }
    
    private void process(){
        histogram = mHB.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
