import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ProgramTabPanel extends JPanel {

    private static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 3;
    private static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 3;

    private JButton startButton;
    private JButton stopButton;
    private boolean analysing = true;

    private JPanel canvas;
    private JTextPane textPane;
    private JTextPane currentSizePane;
    private JSlider slider;
    private JPanel toolbar;

    private int size;


    private ColorGetter getter = new SinglePixelGetter();


    public ProgramTabPanel() {
        super();
        //sets attributes for the frame
        this.setSize(WIDTH, HEIGHT);


        this.setLayout(new BorderLayout());

        //sets toolbar
        toolbar = new JPanel();
        toolbar.setBackground(new Color(200, 200, 200));
        FlowLayout l = new FlowLayout();
        l.setHgap(WIDTH / 25);
        toolbar.setLayout(l);
        toolbar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        toolbar.setPreferredSize(new Dimension(WIDTH, HEIGHT / 10));

        //sets start and stop button
        startButton = new JButton("START");
        startButton.setToolTipText("Start the analysing of colors");
        stopButton = new JButton("PAUSE");
        stopButton.setToolTipText("Stop the analysing of colors");
        startButton.setBackground(Color.WHITE);
        stopButton.setBackground(Color.WHITE);

        //sets textpane
        size = 0;

        currentSizePane = new JTextPane();
        currentSizePane.setEditable(false);
        currentSizePane.setText("radius: 0");
        currentSizePane.setToolTipText("Displays the current radius of the tool");


        //set canvas
        canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        canvas.setLayout(new BoxLayout(canvas, BoxLayout.PAGE_AXIS));
        canvas.setToolTipText("Displays the analysed color");
        canvas.setPreferredSize(new Dimension(WIDTH, (int) (HEIGHT * 0.9)));


        //set textpane
        textPane = new JTextPane();
        //align text
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        //set font
        Font font = new Font("NoName", Font.PLAIN, canvas.getPreferredSize().height / 6);
        textPane.setFont(font);

        textPane.setText("#ffffff");
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        textPane.setEditable(false);
        textPane.setBackground(Color.WHITE);
        textPane.setPreferredSize(new Dimension(canvas.getPreferredSize().width / 3, canvas.getPreferredSize().height / 4));
        textPane.setToolTipText("Displays the hex-code\n of the analysed color");


        //set slider
        slider = new JSlider();
        slider.setMinimum(0);
        slider.setMaximum(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setValue(0);
        slider.setUI(new BasicSliderUI());
        slider.setToolTipText("Adjust the radius of the tool");
        slider.setBackground(new Color(200, 200, 200));

        toolbar.add(startButton);
        toolbar.add(stopButton);
        toolbar.add(currentSizePane);
        toolbar.add(slider);


        canvas.add(textPane);
        canvas.setBorder(BorderFactory.createEmptyBorder((canvas.getPreferredSize().height - textPane.getPreferredSize().height) / 2, (canvas.getPreferredSize().width - textPane.getPreferredSize().width) / 2, (canvas.getPreferredSize().height - textPane.getPreferredSize().height) / 2, (canvas.getPreferredSize().width - textPane.getPreferredSize().width) / 2));


        this.add(toolbar, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);


        //Listener
        startButton.addActionListener(event ->
                analysing = true
        );
        stopButton.addActionListener(event ->
                analysing = false
        );

        slider.addChangeListener((event) -> {
            size = slider.getValue();
            currentSizePane.setText("radius: " + size);

            if (slider.getValue() == 0) {
                getter = new SinglePixelGetter();
            } else {
                getter = new MultiPixelGetter();
            }
        });
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        textPane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        toolbar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        stopButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        startButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        slider.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        currentSizePane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (analysing) {
                    update();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    private void update() {
        Color g = getter.getColor(size);
        canvas.setBackground(g);
        textPane.setText(ColorGetter.getHEX(g));
    }

}
