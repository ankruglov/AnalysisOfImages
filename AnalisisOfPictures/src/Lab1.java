
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class Lab1 {
    static String im1="average.jpg";
    static String im2="human_eye.jpg";
    static String im3="desaturation.jpg";
    static String im4="max_gradation.jpg";
    static String im5="min_gradation.jpg";
    static String im6="components_red.jpg";
    static String im7="components_green.jpg";
    static String im8="components_blue.jpg";
    static String im9="After Equalization.jpg";
    static String im10="Binarization.jpg";
    static String im11="Dots.jpg";
    static String im12="Dilatation.jpg";
    static String im13="Erozian.jpg";
    static BufferedImage result ;

    static StringBuilder s=new StringBuilder("АВЕИКЛМНОРСТУЯ!");
    static int length=s.length();
    static double interval=(double)1/length;
    static int u=0;
    static double stLeft=0;        //исходный интервал
    static double stRight=1;
    static double[] left=new double[length];       //интервалы для букв
    static double[] right=new double[length];

    public Lab1(){
        left[0]=stLeft;
        right[0]=interval;
        while(u<length-1){
            u++;    //задали интервалы для чисел
            left[u]=right[u-1];
            right[u]=right[u-1]+interval;
        }
    }



    public static double[][] average(BufferedImage image) throws IOException {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        double[][] av=new double[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                av[i][j] = (double)((r + g + b) / 3);
                Color newColor = new Color((int)av[i][j], (int)av[i][j], (int)av[i][j]);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        File output = new File(im1);
        ImageIO.write(result, "jpg", output);
        return (av);
    }

    public static void humanEye (BufferedImage image) throws IOException {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                int hE = (int)((r*0.3 + g*0.59 + b*0.11));
                Color newColor = new Color(hE, hE, hE);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        File output = new File(im2);
        ImageIO.write(result, "jpg", output);
    }

    public static void desaturation (BufferedImage image) throws IOException {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                int d = (int) ((Integer.min(b, Integer.min(r, g)) + Integer.max(b, Integer.max(r, g))) / 2);
                Color newColor = new Color(d, d, d);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        File output = new File(im3);
        ImageIO.write(result, "jpg", output);
    }
    public static void max_gradation (BufferedImage image) throws IOException {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                int d = (int) ((Integer.max(b, Integer.max(r, g))));
                Color newColor = new Color(d, d, d);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        File output = new File(im4);
        ImageIO.write(result, "jpg", output);
    }
    public static void min_gradation (BufferedImage image) throws IOException {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                int d = (int) ((Integer.min(b, Integer.min(r, g))) );
                Color newColor = new Color(d, d, d);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        File output = new File(im5);
        ImageIO.write(result, "jpg", output);
    }

    public static void components (BufferedImage image) throws IOException {
        BufferedImage result0 = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        BufferedImage result1 = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        BufferedImage result2 = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int b = color.getBlue();
                int r = color.getRed();
                int g = color.getGreen();
                Color newColor0 = new Color(r, r, r);
                Color newColor1 = new Color(g, g, g);
                Color newColor2 = new Color(b, b, b);
                result0.setRGB(i, j, newColor0.getRGB());
                result1.setRGB(i, j, newColor1.getRGB());
                result2.setRGB(i, j, newColor2.getRGB());
            }
        }
        File output0 = new File(im6);
        ImageIO.write(result0, "jpg", output0);
        File output1 = new File(im7);
        ImageIO.write(result1, "jpg", output1);
        File output2 = new File(im8);
        ImageIO.write(result2, "jpg", output2);
    }

    public static String coding (String str) throws IOException {
        StringBuilder s2=new StringBuilder(str);
        int i=1;
        char[] ch=new char[length];
        int u1=0;
        while(u1<length){               //переписали в массив
            ch[u1]=s.charAt(u1);
            u1++;
        }
        if (s2.length()>0){         //нашли первый интервал
            int j=0;
            while (s2.charAt(0)!=ch[j]) {
                j++;
                if (j>s.length()-1){
                    return ("Не соответствует алфавиту");
                }
            }
            stLeft=left[j];
            stRight=right[j];
        }
        else{
            return ("Пустая строка");
        }
        if ((s2.length()>1)&& (s2.charAt(0)=='!'))
            return ("Неверный формат ввода");
        while(i<s2.length()){           //сужаем интервалы
            int j=0;
            while (s2.charAt(i)!=ch[j]) {       //нашли наше число
                j++;
                if (j>s.length()-1) {
                    return ("Не соответствует алфавиту");
                }
            }
            double NewHigh = stLeft + (stRight - stLeft)*right[j];
            double NewLow = stLeft + (stRight - stLeft)*left[j];
            stRight=NewHigh;
            stLeft=NewLow;

            i++;
        }
        if(i>s2.length()){
            return ("Поставьте знак останова");
        }
        return ("["+stLeft+";"+stRight+")");
    }

    public static String unCoding (String str) throws IOException {
        StringBuilder str1=new StringBuilder();
        StringBuilder str2=new StringBuilder();
        int l=0;
        while (l<str.length()){
            if (!((Character.isDigit(str.charAt(l))) || (str.charAt(l)=='.') ))
                return "Неверный формат ввода";
            else l++;
        }

        char[] buffer = new char[str.length()];
        str.getChars(0,str.length(),buffer,0);
        str1.append(buffer);
        String newStr1=new String (str1);
        if (str.length()==0){
            return("Неверный формат ввода") ;
        }
        Double codeN=Double.valueOf(newStr1);
        if (codeN==0){
            return("Неверный формат ввода");
        }
        StringBuilder s3=new StringBuilder();
        int k=0;
        l=0;
        while (l<length){
            if ((left[l] <= codeN) && (codeN <= right[l])){
                s3.insert(k,s.charAt(l));
                k++;
                break;
            }
            else
                l++;
        }
        if (l==length){
            return ("Неверное значение");
        }
        while ((s3.charAt(k-1)!='!')) {
            codeN = (double) (codeN - left[l]) / (right[l] - left[l]);
            l = 0;
            while (l < length) {
                if ((left[l] <= codeN) && (codeN <= right[l])) {
                    s3.insert(k, s.charAt(l));
                    k++;
                    break;
                } else
                    l++;
            }
            if(l==length){
                return ("Неверный промежуток");
            }
        }
        String s4=new String(s3);
        return (s4);
    }

    public static double[] buildHistogram(BufferedImage image) throws IOException {
        double[] mas=new double[256];
        double[] s = new double[(image.getWidth()) *(image.getHeight())];
        double[][] p;
        p=average(image);
        result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        int l=0;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                s[l] = p[i][j];
                l++;
            }
        }
        int i=0;
        while (i<s.length){         //получили количество
            mas[(int)s[i]]++;
            i++;
        }

        int k=0;
        for (int g = 0; g < image.getWidth(); g++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color newColor = new Color((int) s[k], (int) s[k], (int) s[k]);
                result.setRGB(g, j, newColor.getRGB());
                k++;
            }
        }
        File output = new File(im1);
        ImageIO.write(result, "jpg", output);
        // Histogram.getImage1(result,s);
        return (s);
    }

    public static double[] Equalization(double[] s, BufferedImage image) throws IOException {
        Integer[] mas=new Integer[256];
        int i=0;
        while(i<256){
            mas[i]=0;
            i++;
        }

        i=0;
        while (i<s.length){         //получили количество
            mas[(int)s[i]]++;
            i++;
        }
        Integer[] cdf=new Integer[256];
        int cdf_min;
        double[] f=new double[256];
        int t=1;
        int p=0;
        int min=1;
        while (p<256){          //нашли минимальное
            if((mas[p] < min)&&(mas[p]!=0)){
                min = mas[p];
            }
            p++;
        }
        cdf[0]=mas[0];
        i=1;
        while (i<256){
            while (t<i+1) {

                int h = mas[t] + cdf[i-1];
                cdf[i]=h;
                t++;
            }
            cdf_min=min;
            f[i]=(double)((cdf[i]-cdf_min)*255)/(s.length-1);
            i++;
        }
        while (i<s.length){
            s[i]=f[(int)s[i]];
            i++;
        }
        int k=0;
        for (int g = 0; g < image.getWidth(); g++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color newColor = new Color((int) s[k], (int) s[k], (int) s[k]);
                result.setRGB(g, j, newColor.getRGB());
                k++;
            }
        }
        File output = new File(im9);
        ImageIO.write(result, "jpg", output);
        Histogram.getImage1(result,s);
        return s;
    }


    public void filter(Double[][] filt, int width, int height, BufferedImage image) throws IOException {

        int k=(int)width/2;
        int k1=k;
        int l=(int)height/2;
        int l1=l;
        BufferedImage result1 = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Integer[][] avB=new Integer[image.getWidth()][image.getHeight()];
        Integer[][] avR=new Integer[image.getWidth()][image.getHeight()];
        Integer[][] avG=new Integer[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                avB[i][j] = color.getBlue();
                avR[i][j] = color.getRed();
                avG[i][j] = color.getGreen();
            }
        }
        int i=0;
        int j=0;
        int h=0;
        int p=0;
        double u=0;
        while (h<width){
            p=0;
            while (p<height){
                u=Math.abs(filt[h][p])+u;
                p++;
            }
            h++;
        }
        double[][] gB=new double[image.getWidth()][image.getHeight()];
        double[][] gR=new double[image.getWidth()][image.getHeight()];
        double[][] gG=new double[image.getWidth()][image.getHeight()];

        for (int y=0; y< image.getWidth(); y++) {
            for (int v = 0; v < image.getHeight(); v++) {
                Color newColor = new Color((int) avR[y][v], (int) avG[y][v], (int)  gB[y][v]);
                result1.setRGB(y, v, newColor.getRGB());
            }
        }
        for (int y=0; y< image.getWidth()-width; y++) {
            for (int v = 0; v < image.getHeight()-height; v++) {
                gB[y + k1][v + l1] = 0.0;
                gR[y + k1][v + l1] = 0.0;
                gG[y + k1][v + l1] = 0.0;
            }
        }
        for (int y=0;y<=(image.getWidth()-width); y++){
            for (int v=0; v<=(image.getHeight()-height); v++){
                h=0;
                for (i=y; i<(y+width);i++) {
                    p=0;
                    for(j=v;j<v+height;j++) { //добавление пикселей
                        double kB= gB[y+k1][v+l1];
                        double kR= gR[y+k1][v+l1];
                        double kG= gG[y+k1][v+l1];
                        gB[y+k1][v+l1]=filt[h][p]*avB[i][j]/u+kB;
                        gR[y+k1][v+l1]=filt[h][p]*avR[i][j]/u+kR;
                        gG[y+k1][v+l1]=filt[h][p]*avG[i][j]/u+kG;
                        p++;
                    }
                    h++;
                }
                if (gB[y+k1][v+l1]<0) {
                    gB[y + k1][v + l1] = 0;
                }
                if (gR[y+k1][v+l1]<0) {
                    gR[y + k1][v + l1] = 0;
                }
                if (gG[y+k1][v+l1]<0) {
                    gG[y + k1][v + l1] =0;
                }
                //System.out.println(gR[y+k1][v+l1]);

                Color newColor = new Color((int) gR[y+k1][v+l1], (int) gG[y+k1][v+l1], (int)  gB[y+k1][v+l1]);
                result1.setRGB(y+k1, v+l1, newColor.getRGB());
            }
        }
        Frame nFrame = new Frame();
        nFrame.setSize(750, 900);
        JLabel label = new JLabel(new ImageIcon(result1));
        nFrame.add(label);
        nFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame.setVisible(false);
            }
        });
        nFrame.setVisible(true);
    }

    public BufferedImage ocu(BufferedImage image) throws IOException {
        double[] s = new double[(image.getWidth()) *(image.getHeight())];
        s=buildHistogram(image);
        double min = s[0];
        double max = s[0];
        int size=s.length;

        for (int i = 1; i < size; i++)
        {
            double value = s[i];

            if (value < min)
                min = value;

            if (value > max)
                max = value;
        }
        int histSize =(int)( max - min + 1);
        int[] hist=new int[histSize];


        for (int t = 0; t < histSize; t++)
            hist[t] = 0;


        for (int i = 0; i < size; i++)
            hist[(int)(s[i] - min)]++;

        int m = 0;
        int n = 0;
        for (int t = 0; t <= max - min; t++)
        {
            m += t * hist[t];
            n += hist[t];
        }

        double maxSigma = -1;
        int limit = 0;
        int bin1 = 0;
        int bin1_1 = 0;

        for (int t = 0; t < max - min; t++)
        {
            bin1 += t * hist[t];
            bin1_1 += hist[t];
            double w1 = (double)bin1_1 / n;
            double a = (double)bin1 / bin1_1 - (double)(m - bin1) / (n - bin1_1);
            double sigma = w1 * (1 - w1) * a * a;
            if (sigma > maxSigma)
            {
                maxSigma = sigma;
                limit = t;
            }
        }
        limit+=min;
        BufferedImage result=new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int y=0; y<size;y++){
            if(s[y]>limit){
                s[y]=255;
            }
            else s[y]=0;
        }
        int k=0;
        for (int g = 0; g < image.getWidth(); g++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color newColor = new Color((int) s[k], (int) s[k], (int) s[k]);
                result.setRGB(g, j, newColor.getRGB());
                k++;
            }
        }
        Frame nFrame1 = new Frame();
        nFrame1.setSize(750, 900);
        JLabel label1 = new JLabel(new ImageIcon(image));
        nFrame1.add(label1);

        nFrame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame1.setVisible(false);
            }
        });
        return result;
    }


    public void niblack (double k, int w, BufferedImage image) throws IOException {
        double[][] mas;
        mas=average(image);
        BufferedImage result1=new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        double[][] av=new double[image.getWidth()][image.getHeight()];
        double[][] sigma=new double[image.getWidth()][image.getHeight()];
        double[][] finish=new double[image.getWidth()][image.getHeight()];
        int i=-w;
        int j=-w;
        for (int a=0; a<image.getWidth();a++) {
            for (int b = 0; b < image.getHeight(); b++) {
                av[a][b] = 0.0;
            }
        }
        int n=0;
        int  width=image.getWidth();
        int height=image.getHeight();
        for (int a=0; a<width;a++){
            for (int b=0; b<height;b++){
                while((i<=w)&&(i>=-w)){
                    if ((a+i>=0)) {
                        if (a + i < width) {
                            while ((j <= w) && (j >= -w)) {
                                if ((b + j >= 0)) {
                                    if((b + j < height)) {
                                        av[a][b] = av[a][b] + mas[a + i][b + j];
                                        sigma[a][b] = sigma[a][b] + Math.pow(mas[a][b] - mas[a + i][b + j], 2);
                                        n++;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                j++;
                            }
                        }
                        else {
                            j = -w;
                            break;
                        }
                    }
                    j=-w;
                    i++;
                }
                i=-w;
                av[a][b]=(double)(av[a][b]/n);
                sigma[a][b]=Math.pow((double)(sigma[a][b]/n),0.5);
                finish[a][b]=av[a][b]+k*sigma[a][b];
                if(mas[a][b]>=finish[a][b]){
                    Color newColor = new Color((int)255, (int) 255, (int)255);
                    result1.setRGB(a, b, newColor.getRGB());
                }
                else {
                    Color newColor = new Color((int) 0, (int) 0, (int) 0);
                    result1.setRGB(a, b, newColor.getRGB());
                }
                n=0;
            }
        }

        Frame nFrame = new Frame();
        JLabel label = new JLabel(new ImageIcon(result1));
        nFrame.setSize(750, 900);
        nFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame.setVisible(false);
            }
        });
        nFrame.add(label);
        nFrame.setVisible(true);
        File output = new File(im10);
        ImageIO.write(result1, "jpg", output);

    }



    public BufferedImage dilatation (BufferedImage image1,Double[][] element) throws IOException {
        image1=ocu(image1);
        int width=element[0].length;
        int height=element.length;
        int w;
        int h;
        w=(int)width/2;
        h=(int)height/2;
        if(width==1)
            w=0;
        if (height==1)
            h=0;
        double[][] mas;
        BufferedImage result1 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        int  width_im=image1.getWidth();
        int height_im=image1.getHeight();

        mas=average(image1);
        Frame nFrame1 = new Frame();
        JLabel label1 = new JLabel(new ImageIcon(image1));
        nFrame1.setSize(750, 900);
        nFrame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame1.setVisible(false);
            }
        });
        nFrame1.add(label1);
        nFrame1.setVisible(true);
        double[][] av=new double[image1.getWidth()][image1.getHeight()];
        int i;
        int j;
        int p;
        int u;
        for (int y=0;y<width_im; y++){
            for (int v=0; v<height_im; v++) {
                Color newColor = new Color((int) 255, (int) 255, (int) 255);
                result1.setRGB(y , v, newColor.getRGB());
            }
        }
        for (int y=0;y<=(width_im-width); y++){
            for (int v=0; v<=(height_im-height); v++) {
                u = 0;
                for (i = y; i < (y + width); i++) {
                    p = 0;
                    for (j = v; j < v + height; j++) { //добавление пикселей
                        //System.out.println(p);
                        if (((mas[i][j] == 0) && (element[u][p] == 1.0)) ) {
                            av[y + w][v + h] = 0.0;
                            i=y+width;
                            break;
                        } else {
                            av[y + w][v + h] = 255.0;
                            p++;
                        }

                    }
                    u++;
                }

                // System.out.println("y: "+y+"v: "+v);
                Color newColor = new Color((int) av[y + w][v + h], (int) av[y + w][v + h], (int) av[y + w][v + h]);
                result1.setRGB(y + w, v + h, newColor.getRGB());
            }
        }
        File output = new File(im12);
        ImageIO.write(result1, "jpg", output);
        Desktop dt1 = Desktop.getDesktop();
        dt1.open(output);
        return result1;


    }


    public BufferedImage erosian (BufferedImage image1,Double[][] element) throws IOException {
        image1=ocu(image1);
        int width = element[0].length;
        int height = element.length;
        int w;
        int h;
        w = (int) width / 2;
        h = (int) height / 2;
        if (width == 1)
            w = 0;
        if (height == 1)
            h = 0;
        double[][] mas;
        BufferedImage result1 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        int width_im = image1.getWidth();
        int height_im = image1.getHeight();

        mas = average(image1);
        Frame nFrame1 = new Frame();
        JLabel label1 = new JLabel(new ImageIcon(image1));
        nFrame1.setSize(750, 900);
        nFrame1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame1.setVisible(false);
            }
        });
        nFrame1.add(label1);
        nFrame1.setVisible(true);
        double[][] av = new double[image1.getWidth()][image1.getHeight()];
        int i;
        int j;
        int p;
        int u;
        for (int y = 0; y < width_im; y++) {
            for (int v = 0; v < height_im; v++) {
                Color newColor = new Color((int) 255, (int) 255, (int) 255);
                result1.setRGB(y, v, newColor.getRGB());
            }
        }
        for (int y = 0; y <= (width_im - width); y++) {
            for (int v = 0; v <= (height_im - height); v++) {


                u = 0;
                for (i = y; i < (y + width); i++) {
                    p = 0;
                    for (j = v; j < v + height; j++) { //добавление пикселей
                        //System.out.println(p);
                        if (((mas[i][j] == 255))) {
                            av[y + w][v + h] = 255;
                            i = y + width;
                            break;

                        } else {
                            p++;
                        }
                    }
                    u++;
                }


                Color newColor = new Color((int) av[y + w][v + h], (int) av[y + w][v + h], (int) av[y + w][v + h]);
                result1.setRGB(y + w, v + h, newColor.getRGB());
            }
        }
        File output = new File(im13);
        ImageIO.write(result1, "jpg", output);
        Desktop dt1 = Desktop.getDesktop();
        dt1.open(output);
        return result1;
    }




    public static void main(String[] args){
    }
}
