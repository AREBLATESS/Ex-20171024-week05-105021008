import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JMenuBar jmb= new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jmg = new JMenu("games");
    private JMenu jma = new JMenu("about");

    private JMenuItem jMenuItemExit = new JMenuItem("Exit");
    private JMenuItem jMenuItemLoterry = new JMenuItem("Lottery");

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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        jmb.add(jmf);
        jmb.add(jmg);
        jmb.add(jma);
        jmf.add(jMenuItemExit);
        jmg.add(jMenuItemLoterry);
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

    }
}
//System.get(CurrentTime.Milli());