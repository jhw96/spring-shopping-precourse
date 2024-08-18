package shopping.product.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ProductService {


    /** 상품명 유효성 검사
     *
     * @param name
     * @return
     */
    public boolean check(String name) {
        String[] swearWords = new String[] {"시발", "새끼", "개새끼", "병신" };
        String regExp = "^[가-힣a-zA-Z0-9\s]*$";
        String[] sign = {"\\(", "\\)" ,"\\[", "\\]", "\\+" ,"\\-", "\\&", "\\/", "\\_"};

        // 최대 15자
        if(name.length() > 15)
            return false;

        // 비속어 필터링
        for(int i=0; i<swearWords.length; i++) {
            if(name.contains(swearWords[i])) {
                return false;
            }
        }

        // 특수문자 검사
        String tmpStr = name;
        if(!Pattern.matches(regExp, name)) {
            for(int i=0; i<sign.length; i++)
                tmpStr = tmpStr.replaceAll(sign[i], " ");
        }

        if(!Pattern.matches(regExp, tmpStr)) {
            return false;
        }

        return true;
    }


}
