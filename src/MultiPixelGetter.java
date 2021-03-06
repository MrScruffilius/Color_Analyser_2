import java.awt.*;

public class MultiPixelGetter extends ColorGetter {
    public Color getColor(int size) {
        try {
            Robot rob = new Robot();
            Point current = MouseInfo.getPointerInfo().getLocation();
            long r = 0;
            long g = 0;
            long b = 0;
            int pixelAmount;


            Point upperLeft = new Point(0, 0);
            Point lowerRight = new Point(0, 0);


            if (current.x - size < 0) {
                upperLeft.x = 0;
            } else {
                upperLeft.x = current.x - size;
            }
            if (current.y - size < 0) {
                upperLeft.y = 0;
            } else {
                upperLeft.y = current.y - size;
            }

            Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
            if (current.x + size > screenDimension.width) {
                lowerRight.x = screenDimension.width;
            } else {
                lowerRight.x = current.x + size;
            }
            if (current.y + size > screenDimension.height) {
                lowerRight.y = screenDimension.height;
            } else {
                lowerRight.y = current.y + size;
            }


            Color temp;
            for (int x = upperLeft.x; x <= lowerRight.x; x++) {

                for (int y = upperLeft.y; y <= lowerRight.y; y++) {

                    temp = rob.getPixelColor(x, y);
                    r += temp.getRed();
                    g += temp.getGreen();
                    b += temp.getBlue();
                }
            }

            pixelAmount = (size + size + 1) * (size + size + 1);


            r = r / pixelAmount;
            g = g / pixelAmount;
            b = b / pixelAmount;


            return new Color((int) r, (int) g, (int) b);

        } catch (Exception e) {
            System.out.println("error");
            return Color.BLACK;
        }
    }
}
