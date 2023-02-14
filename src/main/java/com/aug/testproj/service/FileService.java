package com.aug.testproj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileService {

    public Boolean compareChecksum(String calculatedChecksum, String preparedChecksum){
        return (calculatedChecksum).matches(preparedChecksum.toLowerCase());
    }

    public String calculateChecksum(MultipartFile file) throws NoSuchAlgorithmException {

        //MD5 алгоритм хеширования
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");

        //получение хеша
        String checksum = getFileChecksum(md5Digest, file);

        return checksum;
    }

    private static String getFileChecksum(MessageDigest digest, MultipartFile file)
    {
        //Получение файла в стрим
        try {
            FileInputStream fis = new FileInputStream(convert(file));

            //Создание байтового массива для чтения данных частями
            byte[] byteArray = new byte[1024];
            int bytesCount = 0;

            //Чтение данных файла и обновление в дайджесте сообщения
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }
            //Закрытие стрима
            fis.close();

            //Получение байтов хеша
            byte[] bytes = digest.digest();

            //bytes[] содержит байты в десятичном формате;
            //Преобразование в шестнадцатеричный формат
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

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
