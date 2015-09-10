import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.tools.javac.util.StringUtils;
import org.junit.Test;
import sun.awt.image.ImageDecoder;
import sun.swing.SwingUtilities2;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class convertTests {
    @Test
    public void compressTiffTest(){
        System.out.println("start test");
        String srcFilePath = "/Users/bob.zhu/Desktop/screenshot_1441766215569.tiff";
        String destFilePath = "/Users/bob.zhu/Desktop/screenshot_1441766215569_compress.jpg";
        //String srcFilePath = "/Users/bob.zhu/Desktop/bf.png";
        //String destFilePath = "/Users/bob.zhu/Desktop/bf_compress.jpg";
        //compress_no_good(srcFilePath, destFilePath);
        try {
            compress_no_good_too(srcFilePath, destFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void compress_no_good_too(String srcFillePath, String destFilePath) throws IOException {
        ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(srcFillePath));
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
        ImageReader ir = readers.next();
        ir.setInput(iis);
        int frameCount = ir.getNumImages(true);
        ImageIO.write(ir.read(0), "jpg", new File(destFilePath));
    }
    private void compress_no_good(String srcFilePath, String destFilePath) {
        File file = null;
        BufferedImage src = null;
        FileOutputStream out = null;
        ImageWriter imgWrier;
        ImageWriteParam imgWriteParams;
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
        imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
        imgWriteParams.setCompressionQuality((float)0.1);
        imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
        ColorModel colorModel = ColorModel.getRGBdefault();
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel
                .createCompatibleSampleModel(16, 16)));
        try
        {
            file = new File(srcFilePath);
            src = ImageIO.read(file);
            out = new FileOutputStream(destFilePath);
            imgWrier.reset();
            // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
            imgWrier.setOutput(ImageIO.createImageOutputStream(out));
            // 调用write方法，就可以向输入流写图片
            imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
            out.flush();
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

