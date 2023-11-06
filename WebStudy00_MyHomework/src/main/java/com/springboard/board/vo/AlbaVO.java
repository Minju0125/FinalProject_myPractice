package com.springboard.board.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.springboard.validate.grouphint.InsertGroup;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "alId")
public class AlbaVO implements Serializable{
   @NotBlank(groups = InsertGroup.class)
   private String alId;
   @NotBlank(groups = InsertGroup.class)
   private String alName;
   @NotNull(groups = InsertGroup.class)
   @Min(0)
   private Integer alAge;
   @NotBlank
   private String alZip;
   @NotBlank
   private String alAddr1;
   @NotBlank
   private String alAddr2;
   @NotBlank
   @Pattern(regexp = "010-\\d{3,4}-\\d{4}")
   private String alHp;
   @NotBlank
   private String grCode;
   @NotBlank
   private String alGen;   // M,F
   @NotBlank
   @Email
   private String alMail;

   private String alCareer;
   private String alSpec;
   private String alDesc;
   
   private String alImg;
   private MultipartFile alImage;

   //has a 관계(1:1)
   private GradeVO grade;
   
   //has many 관계(1:N)
   private List<LicAlbaVO> licAlbaList;
   
}