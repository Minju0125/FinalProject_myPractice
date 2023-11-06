package com.springboard.board.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"alId", "licCode"})
public class LicAlbaVO implements Serializable {
   @NotBlank
   private String alId;
   @NotBlank
   private String licCode;
   @NotBlank
   @DateTimeFormat(iso = ISO.DATE)
   private LocalDate licDate;

   private byte[] licImg;   // BLOB
   private MultipartFile licImage;

   //has a 관계(1:1)
   private LicenseVO license;
   
   //has a 관계(1:1)
   private AlbaVO alba;

}

