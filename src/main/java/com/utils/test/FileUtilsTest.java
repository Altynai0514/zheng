/*
 * file name:  FileUtil.java
 * copyright:  Unis Cloud Information Technology Co., Ltd. Copyright 2015,  All rights reserved
 * description:  <description>
 * mofidy staff:  zheng
 * mofidy time:  2015年10月10日
 */
package com.utils.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.CharSetUtils;

/**
 * General file manipulation utilities.
 * 
 * Facilities are provided in the following areas:
 * <ul>
 * <li>writing to a file
 * <li>reading from a file
 * <li>make a directory including parent directories
 * <li>copying files and directories
 * <li>deleting files and directories
 * <li>converting to and from a URL
 * <li>listing files and directories by filter and extension
 * <li>comparing file content
 * <li>file last changed date
 * <li>calculating a checksum
 * 
 * @author  zheng
 * @version  [version, 2015年10月10日]
 * @see  [about class/method]
 * @since  [product/module version]
 */
public class FileUtilsTest {

    public static void main(String[] args) throws IOException {
        //get the path of file
        File file = FileUtils.getFile("/Users/zheng/zhengTest/lalala.txt");
        File file1 = FileUtils.getFile(new File("/Users/zheng/zhengTest"), "lalala.txt");
        
        //get the file,if not exist then create ; if exist then delete
        File file2 = new File("/Users/zheng/zhengTest/ttt.txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        if(file.getName().equals("ttt.txt")){
            file2.delete();
        }
        //get the path and URI of file
        file2.toPath();  //--/Users/zheng/zhengTest/ttt.txt
        file2.toURI();  //--file:/Users/zheng/zhengTest/ttt.txt
        
        //the path to the system/user temporary directory.
        String path = FileUtils.getTempDirectoryPath();
        File file3 = FileUtils.getTempDirectory();
        String path2 = FileUtils.getUserDirectoryPath();
        File file4 = FileUtils.getUserDirectory();
        
        //创建FileInputStream实例对象时，指定的文件应当是存在和可读的。
        //Opens a FileInputStream for the specified file, providing better error messages than simply calling new FileInputStream(file)
        FileInputStream inputStream = FileUtils.openInputStream(new File("/Users/zheng/zhengTest/ttt.txt"));
        byte[] bytes = new byte[inputStream.available()];  //新建一个字节数组
        //char[] buf = new char[1024]; --字符流Reader类和Writer类使用
        int length = inputStream.read(bytes);  //将文件中的内容读取到字节数组中
        inputStream.close();
        String s = new String(bytes, 0, length);  //再将字节数组中的内容转化成字符串形式输出
        
        //创建FileOutputStream实例对象时，如果指定的文件已经存在，这个文件中的原来内容将被覆盖清除(但不能指定一个已被其他程序打开了的文件).
        //Opens a FileOutputStream for the specified file, checking and creating the parent directory if it does not exist.
        FileOutputStream outputStream = FileUtils.openOutputStream(new File("/Users/zheng/zhengTest/tt.txt"));
        outputStream.write(bytes, 0, length);
        outputStream.close();
        
        //Implements the same behaviour as the "touch" utility on Unix.
        //It creates a new file with size 0 or, if the file exists already, it is opened and closed without modifying it, but updating the file date and time.
        FileUtils.touch(new File("/Users/zheng/zhengTest/tt.txt"));
        
        //把相应的文件集合转换成文件数组convertFileCollectionToFileArray(Collection<File> files)
        
        //根据一个过滤规则获取一个目录下的文件innerListFiles(Collection<File> files, File directory,IOFileFilter filter)
        //根据一个IOFileFilter过滤规则获取一个目录下的文件集合listFiles( File directory, IOFileFilterfileFilter, IOFileFilter dirFilter)
        
        //把指定的字符串数组变成后缀名格式字符串数组toSuffixes(String[] extensions)
        
        //Finds files within a given directory (and optionally its subdirectories) which match an array of extensions.
        String[] extensions = {"txt","sh"};
        Collection<File> files1 = FileUtils.listFiles(new File("/Users/zheng/zhengTest"), extensions, true);
        for(File f : files1){
            System.out.println(f.getName());
        }
        
        //查找一个目录下面符合对应扩展名的文件的集合的迭代器Iterator<File> iterateFiles( File directory, String[]extensions, boolean recursive)
        //Allows iteration over the files in a given directory (and optionally its subdirectories) which match an array of extensions. 
        //This method is based on {@link #listFiles(File, String[], boolean)},which supports Iterable ('foreach' loop).
        Iterator<File> files2 = FileUtils.iterateFiles(new File("/Users/zheng/zhengTest"), extensions, true);
        while(files2.hasNext()){
            System.out.println(files2.next().getName());
        }
        
        //Compares the contents of two files to determine if they are equal or not.
        boolean flag = FileUtils.contentEquals(new File("/Users/zheng/zhengTest/tt.txt"), new File("/Users/zheng/zhengTest/ttt.txt"));
        //这里使用了charsetName，用以获取编码后的字符流
        boolean flag1 = FileUtils.contentEqualsIgnoreEOL(new File("/Users/zheng/zhengTest/tt.txt"), new File("/Users/zheng/zhengTest/ttt.txt"), "UTF-8");
        
        //Convert from a URL to a File
        File file5 = FileUtils.toFile(new URL("file:///Users/zheng/zhengTest/ttt.txt"));
        
        //Converts each of an array of File to a URL
        File[] files3 = new File[1];
        files3[0] = new File("/Users/zheng/zhengTest/ttt.txt");
        URL[] urls = FileUtils.toURLs(files3);
        for(URL url : urls){
            System.out.println(url);
        }
        
        //Copies a file to a directory preserving the file date.
        FileUtils.copyFileToDirectory(new File("/Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng"));
        FileUtils.copyFileToDirectory(new File("/Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng/test"), true);
        //Copies a file to a new location preserving the file date.
        FileUtils.copyFile(new File("/Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng/zhengTest/tttaaa.txt"));
        FileUtils.copyFile(new File("/Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng/zhengTest/tttaaa.txt"), true);
        
        //Copy bytes from a File to an OutputStream
        long length1 = FileUtils.copyFile(new File("/Users/zheng/zhengTest/tt.txt"),new FileOutputStream("lalala"));
        //Copies bytes from an InputStream source to a file
        FileUtils.copyInputStreamToFile(new FileInputStream(new File("/Users/zheng/zhengTest/abc.txt")), new File("/Users/zheng/zhengTest/ttt.txt"));
        
        //Copies a directory to within another directory preserving the file dates.  --copy文件夹到某个文件夹
        FileUtils.copyDirectoryToDirectory(new File("/Users/zheng/zhengTest"), new File("/Users/zheng/shanchu"));
        //Copies a whole directory to a new location preserving the file dates. --copy文件夹下的内容到某个文件夹
        FileUtils.copyDirectory(new File("/Users/zheng/zhengTest"), new File("/Users/zheng/shanchu"));
        FileUtils.copyDirectory(new File("/Users/zheng/zhengTest"), new File("/Users/zheng/shanchu"), true);
        
        //Copies bytes from the URL source to a file
        FileUtils.copyURLToFile(new URL("file:///Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng/zhengTest/xsa.txt"));
        FileUtils.copyURLToFile(new URL("file:///Users/zheng/zhengTest/ttt.txt"), new File("/Users/zheng/zhengTest/xsa.txt"), 1000, 2000);
        
        //Deletes a directory recursively. 
        FileUtils.deleteDirectory(new File("/Users/zheng/zhengTest/haha"));
        //Schedules a directory recursively for deletion on JVM exit.
        //FileUtils.deleteDirectoryOnExit(new File("/Users/zheng/zhengTest/haha"));
        //Deletes a file, never throwing an exception. If file is a directory, delete it and all sub-directories.
        FileUtils.deleteQuietly(new File("/Users/zheng/zhengTest/haha"));
        
        //Deletes a file. If file is a directory, delete it and all sub-directories.
        FileUtils.forceDelete(new File("/Users/zheng/zhengTest"));
        //Schedules a file to be deleted when JVM exits. If file is directory delete it and all sub-directories.
        FileUtils.forceDeleteOnExit(new File("/Users/zheng/zhengTest"));
        
        //Determines whether the {@code parent} directory contains the {@code child} element (a file or directory).
        boolean flag2 = FileUtils.directoryContains(new File("/Users/zheng/zhengTest"), new File("/Users/zheng/zhengTest/xsaa.txt"));
        
        //Cleans a directory without deleting it.
        FileUtils.cleanDirectory(new File("/Users/zheng/zhengTest/haha"));
        //Cleans a directory without deleting it.
        //FileUtils.cleanDirectoryOnExit(new File("/Users/zheng/zhengTest/haha"));
        
        //Waits for NFS to propagate a file creation, imposing a timeout.
        //This method repeatedly tests {@link File#exists()} until it returns true up to the maximum time specified in seconds.
        //public static boolean waitFor(File file, int seconds)
        
        //Reads the contents of a file into a String. The file is always closed.
        String str = FileUtils.readFileToString(new File("/Users/zheng/zhengTest/ttt.txt"), "UTF-8");
        //Reads the contents of a file into a byte array. The file is always closed.
        //public static byte[] readFileToByteArray(File file);
        
        //Reads the contents of a file line by line to a List of Strings. The file is always closed.
        List<String> list = FileUtils.readLines(new File("/Users/zheng/zhengTest/ttt.txt"),"UTF-8");
        for(String str2:list){
            System.out.println(str2);
        }
        
        //Returns an Iterator for the lines in a <code>File
        //This method opens an <code>InputStream</code> for the file.When you have finished with the iterator you should close the stream
        //to free internal resources. This can be done by calling the {@link LineIterator#close()} or {@link LineIterator#closeQuietly(LineIterator)} method.
        LineIterator lineIterator = FileUtils.lineIterator(new File("/Users/zheng/zhengTest/ttt.txt"), "UTF-8");
        try {
            while (lineIterator.hasNext()) {
                System.out.println(lineIterator.nextLine());
            } 
        }finally{
            LineIterator.closeQuietly(lineIterator);
        }
        
        //Writes a String to a file creating the file if it does not exist.
        //NOTE: As from v1.3, the parent directories of the file will be created if they do not exist.
        FileUtils.writeStringToFile(new File("/Users/zheng/zhengTest/ttt.txt"), "qwe123", "UTF-8");
        
        //Writes a String to a file creating the file if it does not exist.
        //append if {@code true}, then the String will be added to the end of the file rather than overwriting
        FileUtils.writeStringToFile(new File("/Users/zheng/zhengTest/ttt.txt"), "456789", "UTF-8", true);
        
        //Writes the <code>toString()</code> value of each item in a collection to the specified <code>File</code> line by line, optionally appending.
        //The specified character encoding and the default line ending will be used.
        List<String> list1 = new ArrayList<String>();
        list1.add("123");
        list1.add("456");
        list1.add("789");
        FileUtils.writeLines(new File("/Users/zheng/zhengTest/ttt.txt"), "UTF-8", list1, false);
        
        //Makes a directory, including any necessary but nonexistent parent directories. 
        //If a file already exists with specified name but it is not a directory then an IOException is thrown.
        //If the directory cannot be created (or does not already exist) then an IOException is thrown.
        //public static void forceMkdir(File directory);
        
        //Checks that the given {@code File} exists and is a directory.
        //private static void checkDirectory(File directory);
        
        //Tests if the specified <code>File</code> is newer than the specified Date.
        //public static boolean isFileNewer(File file, Date date) ;
        //Tests if the specified <code>File</code> is older than the specified Date
        //public static boolean isFileOlder(File file, Date date); 
        
        //Tests if the specified <code>File</code> is newer than the reference File.
        //boolean flag6 = FileUtils.isFileNewer(new File("/Users/zheng/zhengTest/tt.txt"), new File("/Users/zheng/zhengTest/ttt.txt"));
        //Tests if the specified <code>File</code> is newer than the reference File
        //public static boolean isFileNewer(File file, File reference);
        //Tests if the specified <code>File</code> is older than the reference File
        //public static boolean isFileOlder(File file, File reference);
         
        //Tests if the specified <code>File</code> is newer than the specified time reference.
        //public static boolean isFileNewer(File file, long timeMillis)
        //Tests if the specified <code>File</code> is older than the specified time reference.
        //public static boolean isFileOlder(File file, long timeMillis);
         
        //Moves a directory.When the destination directory is on another file system, do a "copy and delete".
        FileUtils.moveDirectory(new File("/Users/zheng/zhengTest/haha"), new File("/Users/zheng/zhengTest/123/haha"));
        //Moves a file to another directory.
        //@param createDestDir If {@code true} create the destination directory,otherwise if {@code false} throw an IOException
        //public static void moveDirectoryToDirectory(File src, File destDir, boolean createDestDir);
        //Moves a file to a directory.
        //public static void moveFileToDirectory(File srcFile, File destDir, boolean createDestDir) 
        //Moves a file or directory to the destination directory. When the destination is on another file system, do a "copy and delete".
        //public static void moveToDirectory(File src, File destDir, boolean createDestDir);
        //Moves a file. When the destination file is on another file system, do a "copy and delete".
        FileUtils.moveFile(new File("/Users/zheng/zhengTest/tt.txt"), new File("/Users/zheng/zhengTest/123/tt.txt"));
         
        /**
         * Returns the size of the specified file or directory. If the provided 
         * {@link File} is a regular file, then the file's length is returned.
         * If the argument is a directory, then the size of the directory is
         * calculated recursively. If a directory or subdirectory is security 
         * restricted, its size will not be included.
         */
        long size = FileUtils.sizeOf(new File("/Users/zheng/zhengTest/ttt.txt"));
        //Counts the size of a directory recursively (sum of the length of all files).
        long size1 = FileUtils.sizeOf(new File("/Users/zheng/zhengTest"));
        
        /**
         * Determines whether the specified file is a Symbolic Link rather than an actual file.
         * Will not return true if there is a Symbolic Link anywhere in the path,
         * only if the specific file is.
         * <b>Note:</b> the current implementation always returns {@code false} if the system
         * is detected as Windows using {@link FilenameUtils#isSystemWindows()}
         */
        //public static boolean isSymlink(File file);
    }
}

