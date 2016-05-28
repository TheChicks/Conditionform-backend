package com.thechicks.conditionform.ocr;


import com.thechicks.conditionform.model.OcrResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Filter {
    String text;
    ArrayList<String> lineArrayList;
    ArrayList<OcrResult> ocrResults;

    Filter(String text){
        this.text = text;
        lineArrayList = new ArrayList<>();
        ocrResults = new ArrayList<>();
    }


    public List<OcrResult> getOcrResults() {
        return ocrResults;
    }

    //텍스트를 한줄씩 나눠 lineArrayList(ArrayList)에 넣는다
    public void divideTextToLine(){
        String temp="";
        StringTokenizer st = new StringTokenizer(text, "\n");

        while(st.hasMoreTokens()){
            temp = st.nextToken();		// 띄어쓰기로 한 줄 씩 끊는다
            temp = lineFiltering(temp);		// 한 줄을 필터링한다
            lineArrayList.add(temp);	// 필터링 된 결과 값을 lineArrayList에 넣는다
            temp = "";
        }
    }

    //한 줄(라인)을 가지고 와서 단어별로 나눈 후 필터링을 거치고 필터 객체에 데이터를 넣는 함수
    public void divideLineToResult(){
        for(int s=0; s<lineArrayList.size(); s++){
            StringTokenizer st = new StringTokenizer(lineArrayList.get(s), " ");
            OcrResult ocr = new OcrResult();
            ArrayList<String> word = new ArrayList<String>();

            int count = 0;

            //문자열 분리
            while(st.hasMoreTokens()){
                String temp = st.nextToken();
                word.add(temp);
            }

            //필터링
            for(int i=0; i<word.size(); i++){
                //Todo: 한 라인을 나눠 OCReult 객체에 담는다.

                // 쓰레기 값들을 제거한다.
                if(word.get(i).equals("'") || word.get(i).equals(".") || word.get(i).equals(",") || word.get(i).equals(")")
                        || word.get(i).equals("(") || word.get(i).equals("\"") || word.get(i).equals(":") || word.get(i).equals(";")
                        || word.get(i).equals("`") || word.get(i).equals("TAB") || word.get(i).equals("0000") || word.get(i).equals("T")
                        || word.get(i).equals("CAP") || word.get(i).equals("EA") || word.get(i).equals("^") || word.get(i).equals("<")
                        || word.get(i).equals(">") || word.get(i).equals("7")){
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
                    ocr.setQuantity(Integer.parseInt(word.get(i)));
                    count++;
                } else if (num == 3 && count == 1){ // 하루 섭취량
                    ocr.setOnedayDosage(Integer.parseInt(word.get(i)));
                    count++;
                } else if (num == 3 || num == 4 && count == 2){ // 총 섭취량
                    ocr.setTotalDayDosage(Integer.parseInt(word.get(i)));
                    count = 0;
                }
            }
            ocrResults.add(ocr);
        }
    }

    //한 라인을 필터링 해주는 함수
    public String lineFiltering(String str){
        String fString = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c=='′' || c == '\'' || c == '[' || c == ']' || c == '{' || c == '}' || c == '/' || c == '\"' || c == '^' || c == '`' || c == '〔' || c == '〕' || c=='l'){
                ;
            }
            else{
                fString = fString + String.valueOf(str.charAt(i));
                //System.out.println(fString);
            }
        }
        return fString;
    }

    //보험코드인지 판병하는 함수
    public boolean isChangeLastWordToNumber(String str){
        int lastIndex = str.length();
        String lastchar = str.substring(lastIndex-1);

        //성공 1, 실패 0
        try{
            int num = Integer.parseInt(lastchar);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /* 문자열이 어떤 변수에 할당될 것인지 판별하는 함수
     * String pillNumber : 9
     *String pillName : 10
     *String quantity : 3;
     *String onedayDose : 3;
     *String totalDayDose : 3 or 4;
     */
    public int checkWordType(String str){
        int length = str.length();
        boolean isChangePossible = isChangeLastWordToNumber(str);

        if(length == 9 && isChangePossible == true){
            return 9; //보험 코드
        }
        else if(length >= 2  && isChangePossible == false){
            return 10;
        }
        else if(isChangePossible == true){
            if(length >= 2)
                return 4;
            return 3;
        }
        return 0;
    }

    public void print(){
        for(int i=0; i<ocrResults.size(); i++){
            System.out.println(ocrResults.get(i).getPillInsuranceCode()+ ", " + ocrResults.get(i).getPillName() + ", " + ocrResults.get(i).getQuantity() + ", " + ocrResults.get(i).getOnedayDosage() + ", " + ocrResults.get(i).getTotalDayDosage());
        }
    }
}
