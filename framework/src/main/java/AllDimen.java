package com.framework.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Hunreally on 2018/7/30 0030.
 * 尺寸适配文件自动生成
 */
public class AllDimen {
    public static int BASE_DPI = 160;

    public static void main(String[] args) {
        float density_xxxhdpi = 640.0f;//480-640
        float density_xxhdpi = 480.0f;//320-480
        float density_xhdpi = 320.0f;//240-320
        float density_hdpi = 240.0f;//160-240
        float density_mdpi = 160.0f;//120-160
        xxxdpi(density_xxxhdpi,"values-xxxhdpi");
		xxxdpi(density_xxhdpi,"values-xxhdpi");
		xxxdpi(density_xhdpi,"values-xhdpi");
        xxxdpi(density_hdpi,"values-hdpi");
        xxxdpi(density_mdpi,"values-mdpi");
    }

    public static void xxxdpi(float desity,String fileName) {
        File file = new File("D:\\ElectronicLabel\\framework\\src\\main\\res\\"+fileName);
        FileWriter fileWritter = null;
        BufferedWriter bufferWritter = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
                file=new File(file,"dimen.xml");
                file.createNewFile();
                fileWritter = new FileWriter("D:\\ElectronicLabel\\framework\\src\\main\\res\\"+fileName+"\\dimen.xml", true);
                bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<resources>\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int px = 1; px < 2000; px++) {
            float dp = px / (desity / BASE_DPI);
            BigDecimal bd = new BigDecimal(Double.parseDouble("" + dp));
            String value = "<dimen name=\"" + "px"+ px + "\">" + bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()
                    + "dp</dimen>" + "\n";
            try {
                bufferWritter.write(value);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error");
            }
        }
        try {
            bufferWritter.write("\n</resources>");
            bufferWritter.flush();
            bufferWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
