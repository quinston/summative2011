/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GameFrame.java
 *
 * Created on 20-Dec-2011, 7:55:39 PM
 */
package spaceinvaders3d;

/**
 *
 * @author Stephen Wen
 */
public class GameFrame extends javax.swing.JFrame{

    /** Creates new form GameFrame */
    public GameFrame() {
        initComponents();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel1 = new spaceinvaders3d.ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagePanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imagePanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                imagePanel1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                imagePanel1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout imagePanel1Layout = new javax.swing.GroupLayout(imagePanel1);
        imagePanel1.setLayout(imagePanel1Layout);
        imagePanel1Layout.setHorizontalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        imagePanel1Layout.setVerticalGroup(
            imagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagePanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imagePanel1KeyPressed
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        System.out.println(""+keyCode);
    }//GEN-LAST:event_imagePanel1KeyPressed

    private void imagePanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imagePanel1KeyReleased
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        System.out.println(""+keyCode);
    }//GEN-LAST:event_imagePanel1KeyReleased

    private void imagePanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imagePanel1KeyTyped
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        System.out.println(""+keyCode);
    }//GEN-LAST:event_imagePanel1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GameFrame f = new GameFrame();
				f.setVisible(true);
				f.imagePanel1.addKeyListener(this);

				//spaceinvaders3d.Main.main(new String[0]);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static spaceinvaders3d.ImagePanel imagePanel1;
    // End of variables declaration//GEN-END:variables
}
