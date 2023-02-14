package com.aug.testproj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileService {

    public Boolean compareChecksum(String calculatedChecksum, String preparedChecksum){
        return calculatedChecksum.matches(preparedChecksum);
    }

    public String calculateChecksum(MultipartFile file) throws NoSuchAlgorithmException {


//Use MD5 algorithm
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

//Get the checksum
        String checksum = getFileChecksum(md5Digest, file);

//see checksum

        return checksum;
    }

    private static String getFileChecksum(MessageDigest digest, MultipartFile file)
    {
        //Get file input stream for reading the file content
        try {
            FileInputStream fis = new FileInputStream(convert(file));

            //Create byte array to read data in chunks
            byte[] byteArray = new byte[1024];
            int bytesCount = 0;

            //Read file data and update in message digest
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
            ;

            //close the stream; We don't need it now.
            fis.close();

            //Get the hash's bytes
            byte[] bytes = digest.digest();

            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            //return complete hash
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File convert(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close(); //IOUtils.closeQuietly(fos);
        } catch (IOException e) {
            convFile = null;
        }

        return convFile;
    }
}
