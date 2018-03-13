import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Aziz Ahmed Chowdhury & Ahmed Dider Rahat
 */

public class LandingPage extends JFrame implements ActionListener {

    public LandingPage() {
        initComponents();
        StartjButton.addActionListener(this);
        ClearHistoryjButton.addActionListener(this);
        DeveloperjMenuItem.addActionListener(this); 
        ClearHistoryjButton.addActionListener(this);
        ExitjMenuItem.addActionListener(this);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getSource() == StartjButton) {
            new Thread() {
                public void run() {
                    try {
                        Game game = new Game();                      
                    } catch (Exception ex) {
                    }
                }
            }.start();
            this.dispose();
        }
        if(button.getSource() == DeveloperjMenuItem)
        {
            DeveloperOption developerOption = new DeveloperOption();
            this.dispose();
        }
        
        if(button.getSource() == ExitjMenuItem)
        {
            this.dispose();
        }
        
        if(button.getSource() == ClearHistoryjButton)
        {
            ClearHistory ch = new ClearHistory();
            //this.dispose();
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StartjButton = new javax.swing.JButton();
        ClearHistoryjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        HomejMenu = new javax.swing.JMenu();
        DeveloperjMenuItem = new javax.swing.JMenuItem();
        ExitjMenu = new javax.swing.JMenu();
        ExitjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StartjButton.setText("Start");
        StartjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartjButtonActionPerformed(evt);
            }
        });

        ClearHistoryjButton.setText("Clear History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ClearHistoryjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(StartjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(ClearHistoryjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Car Racing Game");

        HomejMenu.setText("Home");

        DeveloperjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        DeveloperjMenuItem.setText("Developer");
        HomejMenu.add(DeveloperjMenuItem);

        jMenuBar1.add(HomejMenu);

        ExitjMenu.setText("Exit");

        ExitjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        ExitjMenuItem.setText("Exit");
        ExitjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitjMenuItemActionPerformed(evt);
            }
        });
        ExitjMenu.add(ExitjMenuItem);

        jMenuBar1.add(ExitjMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ExitjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitjMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitjMenuItemActionPerformed

    private void StartjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartjButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartjButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearHistoryjButton;
    private javax.swing.JMenuItem DeveloperjMenuItem;
    private javax.swing.JMenu ExitjMenu;
    private javax.swing.JMenuItem ExitjMenuItem;
    private javax.swing.JMenu HomejMenu;
    private javax.swing.JButton StartjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
