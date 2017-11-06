import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private Container cp;
    private JLabel JlabAc = new JLabel("帳號");
    private JLabel JlabPw = new JLabel("密碼");
    private JTextField JTf = new JTextField();
    private JPasswordField JPw = new JPasswordField();
    private JButton JbtnCom = new JButton("送出");
    private JButton JbtnExit = new JButton("離開");
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH = 150;

    public LoginFrame(){
        initComp();
    }



    public void initComp(){
        cp=this.getContentPane();
        this.setBounds(dim.width/2-frmW/2,dim.height/2-frmH/2,frmW,frmH);
//        JTf.setHo
        cp.setLayout(new GridLayout(3,2,2,2));
        cp.add(JlabAc);
        cp.add(JlabPw);
        cp.add(JTf);
        cp.add(JPw);
        cp.add(JbtnCom);
        cp.add(JbtnExit);


        JbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JbtnCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JTf.getText().equals("h304")&&new String(JPw.getPassword()).equals("23323456") ){
                    MainFrame mFrm = new MainFrame();//LoginFrame.this
                    setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
                    mFrm.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                }
            }
        });
    }
}