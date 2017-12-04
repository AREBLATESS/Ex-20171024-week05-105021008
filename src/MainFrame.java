import jdk.nashorn.internal.scripts.JO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    int[] num = new int[49];
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
    private JMenuItem jmiCate = new JMenuItem("Category");
    private JMenuBar jmb2 = new JMenuBar();
    private JMenu jmn2 = new JMenu("New");
//    private JTextField jtf= new JTextField();
    private JTextArea jta = new JTextArea();
    private JMenuItem jMenuItemFCLoad = new JMenuItem("Load");
    private JMenuItem jMenuItemFCClose= new JMenuItem("Close");
    private Container Cfc ;



    private JFileChooser jfc= new JFileChooser();
    private JScrollPane jsp = new JScrollPane(jta);
//    private JMenu jm = new JMenu();
//    private JMenu jm = new JMenu();

    //-------------------//

    private JMenuItem jMenuItemExit = new JMenuItem("Exit");
    private JMenuItem jMenuItemLoterry = new JMenuItem("Lottery");
    private JMenuItem jMenuItemSettings = new JMenuItem("settings");
    // ---------------------樂透開獎------------------//
    JLabel jlabs[]=new JLabel[6];
    private JPanel jpn1= new JPanel(new GridLayout(1,6,3,3));
    private JInternalFrame jInternalFrame=new JInternalFrame();
    private JDesktopPane jdp = new JDesktopPane();
    private JPanel jpnSou = new JPanel(new GridLayout(1,2,5,5));
    private JButton jbtnLoClose =new JButton("Close");
    private JButton jbtnLoGene = new JButton("Generate");


    //-------------------------------------------------//

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 600,frmH = 600;
    LoginFrame lgf =new LoginFrame();



    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lgf.setVisible(true);
                dispose();
            }
        });
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
        jmLoad.add(jMenuItemFCClose);
        jmLoad.add(jMenuItemFCLoad);


      //------------- settings//
        jpn2.add(jmsFamily);
        jpn2.add(jmsStyle);
        jpn2.add(jmsSize);
        jpn2.add(jmsfamTf);
        jpn2.add(jmsStyCb);
        jpn2.add(jmsSizTf);
      //------------//

        //------------file chooser//
        jmf.add(jmiCate);
        jInternalFrame2.setBounds(0,0,500,500);
        jInternalFrame2.add(jta);
        jmb2.add(jmn2);
        jmn2.add(jMenuItemFCLoad);
        jmn2.add(jMenuItemFCClose);
        jdp.add(jInternalFrame2);
        Cfc=jInternalFrame2.getContentPane();
        Cfc.setLayout(new BorderLayout());
        Cfc.add(jmb2,BorderLayout.NORTH);
        Cfc.add(jta,BorderLayout.CENTER);
        //------------------------//
        jdp.add(jInternalFrame);
        jInternalFrame.setBounds(50,50,200,80 );
        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //----------------------樂透開獎----------------------//
        jMenuItemLoterry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jInternalFrame.setVisible(true);
                jInternalFrame.setLayout(new BorderLayout());

//                for(int i = 0; i < num.length; i++) {
//                    num[i] = i + 1;
//                    System.out.print(num[i]+" ");
//                }
//                int[] Array;
//                Array = getRandom(num);
//                for(int i = 0;i<6;i++){
//                    jlabs[i]=new JLabel(Integer.toString(Array[i]));
//                    jpn1.add(jlabs[i]);
//                }
                jpnSou.add(jbtnLoClose);
                jpnSou.add(jbtnLoGene);
                jInternalFrame.add(jpnSou,BorderLayout.SOUTH);
            }
        });
        jbtnLoClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jInternalFrame.setVisible(false);
            }
        });

        int[] Array;
        Array = getRandom(num);
        for(int i = 0;i<6;i++){
            jlabs[i]=new JLabel(Integer.toString(Array[i]));
//                    jlabs[i].setText(Integer.toString(Array[i]));
            jlabs[i].setOpaque(true);
//            jlabs[i].setSize(30,30);
            jpn1.add(jlabs[i]);
            jInternalFrame.setSize(200,300);
            jInternalFrame.add(jpn1,BorderLayout.CENTER);
            jlabs[i].setBackground(Color.yellow);
        }
        jbtnLoGene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < num.length; i++) {
                    num[i] = i + 1;
//                    System.out.print(num[i]+" ");
                }
                int[] Array;
                Array = getRandom(num);

                for(int i = 0;i<6;i++){

                    jlabs[i].setText(Integer.toString(Array[i]));
                    }
            }
        });

        //-----------------------------------------------------//
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
        //File Chooser
        jmiCate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jInternalFrame2.setVisible(true);
            }
        });

        jMenuItemFCLoad.addActionListener(new ActionListener() {
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
        jMenuItemFCClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jInternalFrame2.setVisible(false);
            }
        });

    }
    public static int[] getRandom(int[] num)
    {
        int[] arr = new int[49];
        int n;
        for(int i = 0; i < arr.length; i++)
        {
//            num[i]=10;
            n = (int)(Math.random()*(49-i));
            arr[i] = num[n];
            for(int j = n; j < num.length - 1; j++)
            {
                num[j] = num[j+1];
            }
        }
        return arr;
    }
}
//
//for(int i=<0;i<6;i++){
//jlabs[i].setText(Integer.toString(rnd.nextInt(48)+1));
//for(int j=0;j<=i;j++){
//if(jlabs[i].equals(jlabs[j])){
//   i--;
// }else{
//}
// }
// }
// }