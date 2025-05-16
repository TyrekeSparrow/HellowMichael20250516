package com.michael.hellomichael.download;

import android.util.Log;

import com.michael.hellomichael.tag.Tag;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DownloadUtil {
    /**
     * get byteArray from path
     * @return
     */
    public static byte[] getByteArrayNew(String path) {
        byte[] byteArray = null;

        File file = new File(path);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            long length = file.length();
            byteArray = new byte[(int) length];


            byteArray = getByteArray(inputStream, byteArray);


        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    Log.d(Tag.REUSE_IMAGE_VIEW, "----------------- finally close inputStream");
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }

        return byteArray;
    }


    private static byte[] getByteArray(InputStream inputStream, byte[] byteArray) {
        if (inputStream != null) {
            ByteArrayOutputStream outputStream = null;
            try {
                outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[50 * 1024];
                int total = 0;
                int len = -1;
                while ((len = inputStream.read(buffer)) != -1) {
                    if (Thread.interrupted()) {
                        outputStream.close();
                        return null;
                    }
                    outputStream.write(buffer, 0, len);
                    System.arraycopy(buffer, 0, byteArray, total, len);
                    total += len;

                    // onProgressUpdate
//                    notifyProgress(onProgressListener, byteArray, total, false);
                }
//                notifyProgress(onProgressListener, byteArray, total, true);
                byteArray = outputStream.toByteArray();
                outputStream.close();
                return byteArray;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }





    /*
    public static byte[] getByteArray(String url) {
        if (isRegular(url)) {
//            String path = getPath(url);
            String path = url;
            File file = new File(path);
            if (file != null && file.exists() && file.isFile()) {
                FileInputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(file);
                    // TODO content length
                    long length = file.length();
                    if (length > Integer.MAX_VALUE) {
                        inputStream.close();
                        return null;
                    }
                    byte[] byteArray = new byte[(int) length];
                    byteArray = getByteArray(inputStream, byteArray, "");
                    inputStream.close();
                    return byteArray;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    */




    public static boolean isRegular(String url) {
        if (url != null && url.length() > 5) {
            return true;
        }
        return false;
    }


}
