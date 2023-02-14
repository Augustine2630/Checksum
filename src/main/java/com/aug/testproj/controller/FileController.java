package com.aug.testproj.controller;

import com.aug.testproj.service.FileService;
import com.aug.testproj.util.ResponseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.NoSuchAlgorithmException;

@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    //Пользователь вводит файл и данный ему хеш

    @PostMapping("/file")
    @ApiOperation(value = "check file checksum", response = ResponseModel.class)
    public ResponseEntity<ResponseModel> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                          @RequestParam("checksum") String checksum) throws NoSuchAlgorithmException {
        //можно было бы добавить кастомный валидатор для файла(расширение, кодировка)
        ResponseEntity.ok(HttpStatus.OK);
        //responseEntity вернет: пользовательский хеш, посчитанный хеш и бул значение после сравнения
        return ResponseEntity.ok(new ResponseModel(checksum,
                fileService.calculateChecksum(file),
                fileService.compareChecksum(checksum, fileService.calculateChecksum(file))));
    }


}
