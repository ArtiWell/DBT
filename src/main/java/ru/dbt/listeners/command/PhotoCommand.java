package ru.dbt.listeners.command;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class PhotoCommand implements Command {
    @Override
    @SneakyThrows
    public void run(MessageReceivedEvent event) {
        String imagePath = "src/main/resources/static/php.jpg";
        String imagePath1 = "src/main/resources/static/js.png";

        File file1 = new File(imagePath);
        File file2 = new File(imagePath1);

        BufferedImage img1 = ImageIO.read(file1);
        BufferedImage img2 = ImageIO.read(file2);

        BufferedImage im = new BufferedImage(2048,1024,BufferedImage.TYPE_INT_ARGB);
        im.getGraphics().drawImage(img2,0,0,null);
        im.getGraphics().drawImage(img1,5,5,null);
        im.getGraphics().drawImage(img1,205,5,null);
        im.getGraphics().drawImage(img1,405,5,null);
        im.getGraphics().drawImage(img1,605,5,null);
        im.getGraphics().drawImage(img1,805,5,null);
        im.getGraphics().drawImage(img1,5,205,null);
        im.getGraphics().drawImage(img1,205,205,null);
        im.getGraphics().drawImage(img1,405,205,null);
        im.getGraphics().drawImage(img1,605,205,null);
        im.getGraphics().drawImage(img1,805,205,null);
        im.getGraphics().drawImage(img1,5,405,null);
        im.getGraphics().drawImage(img1,205,405,null);
        im.getGraphics().drawImage(img1,405,405,null);
        im.getGraphics().drawImage(img1,605,405,null);
        im.getGraphics().drawImage(img1,805,405,null);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", bos );
        byte [] data = bos.toByteArray();

        FileUpload fileUpload = FileUpload.fromData(data,"poistenepizdec.png");

            event.getChannel().sendFiles(fileUpload).queue();


    }

    @Override
    public String getKey() {
        return "photo";
    }
}
