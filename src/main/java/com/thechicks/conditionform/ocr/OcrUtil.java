package com.thechicks.conditionform.ocr;

import com.thechicks.conditionform.model.OcrResult;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

//Ocr 기능을 담당
@Component
public class OcrUtil {

    private ITesseract iTesseract;

    public OcrUtil() {
        iTesseract = new Tesseract();
        iTesseract.setLanguage("kor");
    }

    public List<OcrResult> getOcrProcessingResult(File file) {

        try {
            String result = iTesseract.doOCR(file);  //Ocr 수행

            System.out.println(result);  //Ocr 결과 출력

            //post processing
            Filter filter = new Filter(result);
            filter.divideTextToLine();
            filter.divideLineToResult();

            filter.print();  //post processing 결과 출력

            return filter.getOcrResults();  //post processing 결과 반환
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
