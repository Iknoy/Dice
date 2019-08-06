package dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DiceGUI {
    private final JFrame principal;
    private final JPanel show;
    private final JButton dice;
    private int random;
    private final JLabel face;
    private final Timer timer;
    private static int click = 0;

    DiceGUI(){
        principal = new JFrame("Dado");
        show = new JPanel();
        dice = new JButton();
        face= new JLabel("<html><body><center>Hola,<br>presiona el dado <br>para empezar</center></body></html>", SwingConstants.CENTER);
        random=1;
        menuListener listiner = new menuListener();
        dice.addActionListener(listiner);
        timer = new Timer(100, listiner);
    }

    void init(){
        dice.setBackground(Color.white);
        dice.setIcon(new ImageIcon(getClass().getResource("/img/D1.JPG")));
        show.setLayout(new GridLayout(2, 1));
        show.add(dice);
        face.setFont(new java.awt.Font("Tahoma", Font.BOLD, 36));
        show.add(face);
        principal.add(show);
        principal.setResizable(false);
        principal.setVisible(true);
        principal.pack();
        principal.setSize(new Dimension(450, 950));
        principal.setLocationRelativeTo(null);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void select(int random){

        switch (random) {
            case 1:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D1.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            case 2:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D2.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            case 3:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D3.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            case 4:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D4.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            case 5:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D5.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            case 6:
                dice.setIcon(new ImageIcon(getClass().getResource("/img/D6.JPG")));
                face.setText("<html><body><center>Tu resultado es:<br>"+random+" <br>presiona de nuevo para otro resultado</center></body></html>");
                break;
            default:
                break;
        }
    }

    private void startTimer(){
        timer.start();
    }

    private void animation(){
        int ran;
        for (int j = 0; j < 50; j++) {
            ran=(int) (Math.random()*6)+1;
            dice.setIcon(new ImageIcon(getClass().getResource("/img/D"+ran+".JPG")));
            face.setText("Presiona para detener");
        }
    }

    class menuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == dice) {
                if(click==0){
                    startTimer();
                    click=1;
                }else if(click==1){
                    timer.stop();
                    random = (int) (Math.random()*6)+1;
                    select(random);
                    click=0;
                }
            }else if(e.getSource() == timer){
                animation();
            }
        }
    }
}
