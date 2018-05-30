package BSTandSST;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

/**
 * created by PATRICK
 * 2018/5/31 1:02
 *
 * 文件相关操作
 *
 **/

public class FileOperations {

    /**
     * 将 filename 文件读取到 words 容器中
     * @param filename 文件名称
     * @param words string 容器
     * @return 是否读取成功
     */
    public static boolean readFile(String filename, Vector<String> words) {

        if (filename == null) {
            System.out.println("filename is null");
            return false;
        }

        Scanner scanner;

        try {
            File file = new File(filename);

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else {
                System.out.println("the " + filename + " doesn't exist");
                return false;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot open the " + filename);
            e.printStackTrace();
            return false;
        }

        // 简单分词
        if (scanner.hasNextLine()) {

            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);

            for (int i = start + 1; i <= contents.length(); ) {
                if  (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                }
                else {
                    ++i;
                }
            }
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start){
        for( int i = start ; i < s.length() ; i ++ )
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }

}
