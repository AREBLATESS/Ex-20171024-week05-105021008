import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainFrame extends JFrame{
    private JMenuBar jmb= new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jmg = new JMenu("games");
    private JMenu jma = new JMenu("about");
    private JMenu jms = new JMenu("settings");
    private JMenu jmLoad = new JMenu("load");
//-------------------------ＡＤＤ settings//
    private JPanel jpn2 = new JPanel(new GridLayout(2,3,3,3));

    private JLabel jmsFamily = new JLabel("Family:");
    private JLabel jmsStyle= new JLabel("Style:");
    private JLabel jmsSize= new JLabel("Size:");

    String data[]={"PLAIN","BOLD","ITALY","BOLD+ITALY"};

    private JTextField jmsfamTf = new JTextField("新細明體");
    private JComboBox jmsStyCb = new JComboBox(data);
    private JTextField jmsSizTf = new JTextField("18");
//----------------------//

    //------------------- ＡＤＤ　file chooser//
    private JInternalFrame jInternalFrame2 = new JInternalFrame();
    private JMenuBar jmb2 = new JMenuBar();

    private JTextField jtf= new JTextField();
    private JTextArea jta = new JTextArea();
    private JButton jbtnDataLoad = new JButton("Load");
    private JFileChooser jfc= new JFileChooser();
    private JButton jbtnDataclose = new JButton("close");
    private JScrollPane jsp = new JScrollPane();
//    private JMenu jm = new JMenu();
//    private JMenu jm = new JMenu();

    //-------------------//

    private JMenuItem jMenuItemExit = new JMenuItem("Exit");
    private JMenuItem jMenuItemLoterry = new JMenuItem("Lottery");
    private JMenuItem jMenuItemSettings = new JMenuItem("settings");

    JLabel labs[]=new JLabel[6];

    private JInternalFrame jInternalFrame=new JInternalFrame();
    private JDesktopPane jdp = new JDesktopPane();
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 600,frmH = 600;




    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(2);
        this.setBounds(dim.width/2-frmW/2,dim.height/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        jmb.add(jmf);
        jmb.add(jmg);
        jmb.add(jma);
        jmb.add(jms);
        jmb.add(jmLoad);

        jmf.add(jMenuItemExit);
        jmg.add(jMenuItemLoterry);
        jms.add(jMenuItemSettings);

      //------------- settings//
        jpn2.add(jmsFamily);
        jpn2.add(jmsStyle);
        jpn2.add(jmsSize);
        jpn2.add(jmsfamTf);
        jpn2.add(jmsStyCb);
        jpn2.add(jmsSizTf);
      //------------//

        //------------file chooser//
        jInternalFrame2.add(jmb2);
//        jmb2.add();


        //------------------------//
        jdp.add(jInternalFrame);
        jInternalFrame.setBounds(50,50,200,80 );
        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenuItemLoterry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jInternalFrame.setVisible(true);

            }
        });
        jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        jMenuItemSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             int result =  JOptionPane.showConfirmDialog(MainFrame.this,jpn2,"settings",JOptionPane.OK_CANCEL_OPTION);
                int fontStyle=0;
                switch(jmsStyCb.getSelectedIndex()){
                    case 0:
                        fontStyle = Font.PLAIN;
                        break;
                    case 1:
                        fontStyle = Font.BOLD;
                        break;
                    case 2:
                        fontStyle = Font.ITALIC;
                        break;
                    case 3:
                        fontStyle = Font.BOLD+Font.ITALIC;
                        break;
                }
               if(result == JOptionPane.OK_OPTION){
                    UIManager.put("Menu.font",new Font(jmsfamTf.getText(),fontStyle,Integer.parseInt(jmsSizTf.getText())));

               }
            }
        });

        jbtnDataLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    try{
                        File inFile = jfc.getSelectedFile();
                        BufferedReader br=new BufferedReader(new FileReader(inFile));
                        String str ="";
                        while((str = br.readLine()) != null){
                            jta.append(str+"\n");
                        }
                        System.out.println("Read file finished");
                    }catch (Exception ioe){
                        JOptionPane.showMessageDialog(null,"Open File error:"+ioe.toString());
                    }
                }
            }
        });
//        jbtnDataclose.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

    }
}
//System.get(CurrentTime.Milli());