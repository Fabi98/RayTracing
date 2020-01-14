package sample;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

    class Display extends JFrame {
        private int imageWidth;
        private int imageHeight;
        private int[] pixels;
        private BufferedImage image;


        private class MyJPanel extends JPanel {
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(image, 0, 0, null);
            }
        }

        public Display(int imageWidth, int imageHeight, int[] pixels) {
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.pixels = pixels;
            this.setupFrame();
            this.image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        }

        private void setupFrame(){
            this.setResizable(false);
            this.setupPanel();
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
        }

        private void setupPanel(){
            JPanel panel = new MyJPanel();
            panel.setPreferredSize(new Dimension(imageWidth,imageHeight));
            this.add(panel);
            this.pack();
        }

        public void draw(){
            for(int x = 0; x < this.imageWidth; x++) {
                for (int y = 0; y < this.imageHeight; y++) {
                    this.image.setRGB(x,y, this.pixels[(y * this.imageWidth) + x]);
                }
            }
            this.repaint();
            this.setVisible(true);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
