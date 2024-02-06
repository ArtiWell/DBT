package ru.dbt.listeners.command.casino;

import lombok.SneakyThrows;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.Command;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class CasinoCommand implements Command {

    public CasinoCommand(RandomField randomField) {
        this.randomField = randomField;
    }

    private final RandomField randomField;
    private final Map<Integer, BufferedImage> mapImg = loadPicture();


    @Override
    public void run(MessageReceivedEvent event) {

        event.getChannel().sendFiles(printToScreen(randomField.randomArray(3, 3))).queue();
    }

    @SneakyThrows
    private Map<Integer, BufferedImage> loadPicture() {
        Map<Integer, BufferedImage> map = new HashMap<>();
        map.put(0 ,ImageIO.read(new File("src/main/resources/static/black Fon.jpg")));
        map.put(1, ImageIO.read(new File("src/main/resources/static/1111.png")));
        map.put(2, ImageIO.read(new File("src/main/resources/static/111.png")));
        map.put(3, ImageIO.read(new File("src/main/resources/static/333.png")));
        map.put(4, ImageIO.read(new File("src/main/resources/static/444.png")));
        map.put(5, ImageIO.read(new File("src/main/resources/static/55.png")));

       return map;
    }


    @SneakyThrows
    private FileUpload printToScreen(int[][] array) {
        BufferedImage im = new BufferedImage(array.length * 200 + 10, array[1].length * 200 + 10, BufferedImage.TYPE_INT_ARGB);

        im.getGraphics().drawImage(mapImg.get(0), 0, 0, null);

        for (int i = 0, xBorder = 10; i < array.length; i++, xBorder += 200) {
            for (int j = 0,yBorder = 10; j < array[i].length; j++, yBorder += 200) {

                im.getGraphics().drawImage(mapImg.get(array[i][j]), xBorder, yBorder, null);
            }
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

    @Override
    public String description() {
        return null;
    }

    @Override
    public Boolean checkRole() {
        return null;
    }
}
