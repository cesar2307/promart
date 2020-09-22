package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.ventaZapatos;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshots extends ventaZapatos {

    public static void capturarEvidencia(){
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        //Si no existe la ruta la creará
        String path="C:\\evidencias\\";
        String nombre=formato.format(fecha)+"_screenshot.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(path+nombre));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
