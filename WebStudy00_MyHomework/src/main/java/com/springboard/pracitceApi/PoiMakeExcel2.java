package com.springboard.pracitceApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.springboard.board.service.AlbaService;
import com.springboard.board.service.AlbaServiceImpl;
import com.springboard.board.vo.AlbaVO;

/** DB를 사용하지 않은 경우*/
public class PoiMakeExcel2 {
	private static AlbaService service = new AlbaServiceImpl();
	
	private static List<AlbaVO> getAlbaList(){
		return service.retrieveAlbaList();
	}
	
	public static String filePath = "C:\\02.testApi"; // 엑셀 파일이 저장될 경로
	public static String fileName = "poi_making_file_test_db(1).xlsx"; //저장될 엑펠 파일명.확장자명
	public static void main(String[] args) {
		List<AlbaVO> albaList = getAlbaList();
		System.out.println(albaList);
		
		// 빈 workbook 생성 (=엑셀파일)
		XSSFWorkbook workbook = new XSSFWorkbook();

		// 빈 sheet 생성
		XSSFSheet sheet = workbook.createSheet(fileName);

		// sheet 를 채우기위한 데이터를 Map 에 저장
		Map<String, Object[]> data = new TreeMap<>();
		data.put("1", new Object[] { "ID", "NAME", "PHONE_NUMBER" });
		data.put("2", new Object[] { "1", "cookie", "010-1111-1111" });
		data.put("3", new Object[] { "2", "sickBBang", "010-2222-2222" });
		data.put("4", new Object[] { "3", "workingAnt", "010-3333-3333" });
		data.put("5", new Object[] { "4", "wow", "010-4444-4444" });

		
		
		// data에서 keySet를 가져온다. 이 Set 값들을 조회하면서 데이터들을 sheet에 입력한다.
		// set collection 특징 1. 값의 저장 순서 X, 2. 값의 중복 저장X
		Set<String> keySet = data.keySet();
		int rowNum = 0;
		
		// TreeMap을 통해 생성된 keySet는 for를 조회시, 키값이 오름차순으로 조회된다. (위에서 map 에 키값을 숫자 오름차순으로 주었음)
		for (String key : keySet) {
			// 열
			Row row = sheet.createRow(rowNum++);
			Object[] objArr = data.get(key);
			int cellNum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellNum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(filePath, fileName));
			workbook.write(out);
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close(); //파일 출력하다가 오류 나도 위에서 열어뒀던 workbook은 닫아야함
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
