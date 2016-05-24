package com.thechicks.conditionform.ocr;


import com.thechicks.conditionform.model.OcrResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Filter {
    String content;
    ArrayList<String> pillInfos;
    ArrayList<OcrResult> ocrArray;


    //Todo: 리팩토링하기
    public Filter(String content){
        this.content = content;
        pillInfos = new ArrayList();
        ocrArray = new ArrayList();
    }

    /* 문자열이 어떤 변수에 할당될 것인지 판별하는 함수
	 *String pillNumber : 9
	 *String pillName : 10
	 *String quantity : 3
	 *String onedayDose : 3
	 *String totalDayDose : 3
	 */

    public List<OcrResult> getOcrReultList() {

        divideTextToLine();
        return ocrArray;

    }


    public int checkWordType(String str){
        int number = str.length();
        int isChangePossible = isChangeLastWordToNumber(str);

        if(number == 9 && isChangePossible == 1){
            return 9; //보험 코드
        }
        else if(number >= 2  && isChangePossible == 0){
            return 10;
        }

        if(isChangePossible == 1){
            return 3;
        }
        return 0;
    }

    //보험코드인지 판병하는 함수
    public int isChangeLastWordToNumber(String str){
        int lastIndex = str.length();
        String lastchar = str.substring(lastIndex-1);

        //성공 1, 실패 0
        try{
            int num = Integer.parseInt(lastchar);
            return 1;
        }catch (NumberFormatException e){
            return 0;
        }
    }

    //텍스트를 한줄씩 나눠 line(ArrayList)에 넣는다
    public void divideTextToLine(){
        StringTokenizer st = new StringTokenizer(content, "\n");
        while(st.hasMoreTokens()){
            pillInfos.add(st.nextToken());
        }

        for(int i=0; i<pillInfos.size(); i++){
            divideLineToResult(pillInfos.get(i));
        }
    }

    //한 줄(라인)을 가지고 와서 단어별로 나눈 후 필터링을 거치고 필터 객체에 데이터를 넣는 함수
    public void divideLineToResult(String line){
        StringTokenizer st = new StringTokenizer(line, " ");
        OcrResult ocr = new OcrResult();
        ArrayList<String> word = new ArrayList<String>();

        int count = 0;
        //문자열 분리
        while(st.hasMoreTokens()){
            word.add(st.nextToken()); //line 한 줄을
        }

        //필터링
        for(int i=0; i<word.size(); i++){
            //Todo: 한 라인을 나눠 OCReult 객체에 담는다.

            // 쓰레기 값들을 제거한다.
            if(word.get(i).equals("'") || word.get(i).equals(".") || word.get(i).equals(",") || word.get(i).equals(")")
                    || word.get(i).equals("(") || word.get(i).equals("\"") || word.get(i).equals(":") || word.get(i).equals(";")
                    || word.get(i).equals("`") || word.get(i).equals("TAB") || word.get(i).equals("0000") || word.get(i).equals("T")
                    || word.get(i).equals("CAP") || word.get(i).equals("EA")){
                word.remove(i);
            }
        }

        // ocr 객체에 값 넣기
        for(int i=0; i<word.size(); i++){
            int num = checkWordType(word.get(i));
            if(num == 9){ // 양품번호
                ocr.setPillInsuranceCode(word.get(i));
            } else if (num == 10){ // 약품이름
                ocr.setPillName(word.get(i));
            } else if (num == 3 && count == 0){ // 약 수량
                ocr.setQuantity(word.get(i));
                count++;
            } else if (num == 3 && count == 1){ // 하루 섭취량
                ocr.setOnedayDosage(word.get(i));
                count++;
            } else if (num == 3 && count == 2){ // 총 섭취량
                ocr.setTotalDayDosage(word.get(i));
                count = 0;
                ocrArray.add(ocr);
            }
        }
    }

    public void print(){

        System.out.println("결과");

        for(int i=0; i<ocrArray.size(); i++){
            System.out.println(ocrArray.get(i).getPillInsuranceCode() + ", " + ocrArray.get(i).getPillName() + ", " + ocrArray.get(i).getQuantity() + ", " + ocrArray.get(i).getOnedayDosage() + ", " + ocrArray.get(i).getTotalDayDosage());
        }
    }

    public ArrayList<OcrResult> getOcrArray() {
        return ocrArray;
    }
}
