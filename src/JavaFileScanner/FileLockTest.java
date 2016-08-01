package JavaFileScanner;

/**
 * Created by namrataojha on 7/9/16.
 * This program is may be wrong .Check it out
 * The above program tries to lock a file called “FileToBeLocked” by calling the lock() method on the associated File Channel object.
 * The lock() method blocks the thread until it gets a lock on the file. Then, in order to ensure that the file is locked,
 * the method accessTheLockedFile() is called which tries to read the file contents. Since the lock acquired is an exclusive lock,
 * an IOException is thrown.
 */
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile file = null;
        FileLock fileLock = null;
        try
        {
            file = new RandomAccessFile("/Users/namrataojha/Documents/Java/source.txt", "rw");
            FileChannel fileChannel = file.getChannel();

            fileLock = fileChannel.tryLock();
            if (fileLock != null){
                System.out.println("File is locked");
                accessTheLockedFile();
            }
        }finally{
            if (fileLock != null){
                fileLock.release();
            }
        }
    }

    static void accessTheLockedFile(){

        try{
            FileInputStream input = new FileInputStream("/Users/namrataojha/Documents/Java/source.txt");
            int data = input.read();
            System.out.println("data : "+data);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}