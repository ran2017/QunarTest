/**
 * Created by PC on 2017/1/15.
 */
package com.org.first;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EfficetiveLines {

    public static int count;

    public static void countLine(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                countLine(files[i]);
            }
        } else if ((file.getName().contains(".java")) && (file.exists())) {
            FileReader fin = null;
            try {
                fin = new FileReader(file);
                BufferedReader bin = new BufferedReader(fin);
                String value = null;
                while (null != (value = bin.readLine())) {
                    String singleLineCommentP = "^\\s*//.*?$";
                    String spaceLineCommentP = "\\s*";
                    if ((!value.matches(singleLineCommentP)) && (!value.matches(spaceLineCommentP))) {
                        count++;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        System.out.println("输入文件夹路径");
        String path=in.next();
        File file = new File(path);//"E:\\src"
        countLine(file);
        System.out.println(count);
    }
}