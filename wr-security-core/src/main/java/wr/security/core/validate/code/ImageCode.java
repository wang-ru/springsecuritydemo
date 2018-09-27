package wr.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by wsh10801 on 2018/9/25.
 */
public class ImageCode {
    private BufferedImage image;
    private String code;
    private LocalDateTime exprieTime;


    public ImageCode(BufferedImage image, String code, int inExprieTime) {
        this.image = image;
        this.code = code;
        this.exprieTime = exprieTime.plusSeconds(inExprieTime);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime exprieTime) {
        this.image = image;
        this.code = code;
        this.exprieTime = exprieTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExprieTime() {
        return exprieTime;
    }

    public void setExprieTime(LocalDateTime exprieTime) {
        this.exprieTime = exprieTime;
    }
}
