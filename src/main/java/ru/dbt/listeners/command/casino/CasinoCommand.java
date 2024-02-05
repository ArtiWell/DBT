package ru.dbt.listeners.command.casino;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.Command;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CasinoCommand implements Command {

    private final RandomField randomField;
    @Override
    public void run(MessageReceivedEvent event) {

        event.getChannel().sendFiles(printToScreen(randomField.randomArray(3,3))).queue();
    }



    @SneakyThrows
    private FileUpload printToScreen(int[][] array) {
        BufferedImage imgFon = ImageIO.read(new File("src/main/resources/static/js.png"));

        List<BufferedImage> list = new ArrayList<>();
        list.add(ImageIO.read(new File("src/main/resources/static/1.png")));
        list.add(ImageIO.read(new File("src/main/resources/static/2.png")));
        list.add(ImageIO.read(new File("src/main/resources/static/3.png")));
        list.add(ImageIO.read(new File("src/main/resources/static/4.png")));
        list.add(ImageIO.read(new File("src/main/resources/static/5.png")));

        BufferedImage im = new BufferedImage(array.length * 200 + 10, array[1].length * 200 + 10, BufferedImage.TYPE_INT_ARGB);

        im.getGraphics().drawImage(imgFon, 0, 0, null);

        for (int i = 0, a = 10, b = 10; i < array.length; i++, a += 200) {
            for (int j = 0; j < array[i].length; j++, b += 200) {
                im.getGraphics().drawImage(list.get(array[i][j]), a, b, null);
            }
            b = 10;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(im, "png", bos);
        byte[] data = bos.toByteArray();

        return FileUpload.fromData(data, "result.png");
    }


    @Override
    public String getKey() {
        return "casino";
    }
}
