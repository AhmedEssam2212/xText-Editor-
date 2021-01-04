
package project;

import com.ozten.font.JFontChooser;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;


public class fnotebad extends javax.swing.JFrame {


    int code = -1;
    String name = "-1";
    String data = "-1";
    String date = "-1";
    String fontcolor = "-1";
    String fontstyle = "Arial,Arial,plain,18";
    String pos = "-1";
    String bacegroundcolor = "-1";

    public fnotebad() {
        initComponents();
        this.setVisible(true);
        jTextArea1.requestFocusInWindow();
        String[] newdate = fontstyle.split(",");
        int x = 0;
        if (newdate[2].equalsIgnoreCase("plain")) {
            x = 0;
        } else if (newdate[2].equalsIgnoreCase("Bold")) {
            x = 1;
        } else if (newdate[2].equalsIgnoreCase("italic")) {
            x = 2;
        }
        Font font = new Font(newdate[1], x, Integer.valueOf(newdate[3]));
        jTextArea1.setFont(font);
       jButton9.setVisible(false);
        jTextArea1.setColumns(160);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new Insets(10, 10, 10, 10));
        jTextArea1.requestFocusInWindow();
    }
    public fnotebad(int code) {
        initComponents();
        this.setVisible(true);
        jTextArea1.setColumns(160);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new Insets(10, 10, 10, 10));
        jTextArea1.requestFocusInWindow();
        notebad mm = new notebad();
        int loc = mm.search(code);
        fontstyle = mm.datas.get(loc).getFontstyle();
        this.code = code;
        name = mm.datas.get(loc).getName();
        data = mm.datas.get(loc).getData();
        date = date();
        fontcolor = mm.datas.get(loc).getFontcolor();
        pos = mm.datas.get(loc).getPos();
        bacegroundcolor = mm.datas.get(loc).getBackgroundcolor();

        if (pos.equalsIgnoreCase("left")) {
            jButton5.doClick();
        } else if (pos.equalsIgnoreCase("right")) {
            jButton2.doClick();
        }

        if (!fontstyle.equalsIgnoreCase("-1")) {
            String[] newdates = fontstyle.split(",");
            int x = 0;
            if (newdates[2].equalsIgnoreCase("plain")) {
                x = 0;
            } else if (newdates[2].equalsIgnoreCase("Bold")) {
                x = 1;
            } else if (newdates[2].equalsIgnoreCase("italic")) {
                x = 2;
            }
            Font font = new Font(newdates[1], x, Integer.valueOf(newdates[3]));
            jTextArea1.setFont(font);
        }
        if (!bacegroundcolor.equalsIgnoreCase("-1")) {
            String[] newdate = bacegroundcolor.split(",");
            Color myWhite = new Color(Integer.parseInt(newdate[0]), Integer.parseInt(newdate[1]), Integer.parseInt(newdate[2]));
            jTextArea1.setBackground(myWhite);
        }
        if (!fontcolor.equalsIgnoreCase("-1")) {
            String[] newdate1 = fontcolor.split(",");
            Color myWhite1 = new Color(Integer.parseInt(newdate1[0]), Integer.parseInt(newdate1[1]), Integer.parseInt(newdate1[2]));
            jTextArea1.setForeground(myWhite1);
        }
        jTextArea1.setText(data);
        jButton7.setVisible(false);
    }

    class color extends DefaultHighlighter.DefaultHighlightPainter {

        public color(Color co) {
            super(co);
        }
    }
    Highlighter.HighlightPainter my = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);

    public void highlight(JTextComponent text, String patren) throws BadLocationException {
        Highlighter hilit = text.getHighlighter();
        Document doc = text.getDocument();
        String txt = text.getText(0, doc.getLength());
        int pos = 0;
        while ((pos = txt.toUpperCase().indexOf(patren.toUpperCase(), pos)) >= 0) {
            hilit.addHighlight(pos, pos + patren.length(), my);
            pos = pos + patren.length();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        anew = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        old = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("font");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton7.setText("save");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("-------");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel25.setText("background");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setText("-------");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("right");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setText("left");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setText("search");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setText("replace");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel24.setText("color");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton8.setText("ok");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        anew.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        anew.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anew.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        anew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anewActionPerformed(evt);
            }
        });
        anew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anewKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anewKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("->");

        old.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        old.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        old.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        old.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldActionPerformed(evt);
            }
        });
        old.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                oldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                oldKeyReleased(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton9.setText("update");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton10.setText("open");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel25)
                                .addGap(16, 16, 16)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(old, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anew, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(564, 564, 564))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(old, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(anew, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public String date() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
        return s.format(d);
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (!jTextArea1.getText().equalsIgnoreCase("")) {
            notebad m = new notebad();
            String anser = JOptionPane.showInputDialog(null, "please enter name", "");
            if (anser != null && !anser.equalsIgnoreCase("")) {
                data = jTextArea1.getText();
                m.insert(anser, data, date(), fontcolor, fontstyle, pos, bacegroundcolor);
                this.dispose();
                fnotebad mm = new fnotebad();
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFontChooser fc = new JFontChooser();
        JOptionPane.showMessageDialog(null, fc, "please choose font", JOptionPane.INFORMATION_MESSAGE);
        Font font = fc.getPreviewFont();
        jTextArea1.setFont(font);
        fontstyle = font.toString();
        fontstyle = fontstyle.substring(21, fontstyle.length() - 1);
        fontstyle = fontstyle.replaceAll("name=", "");
        fontstyle = fontstyle.replaceAll("style=", "");
        fontstyle = fontstyle.replaceAll("size=", "");
        fontstyle = fontstyle.replaceAll("]", "");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
        if (newColor != null) {
            fontcolor = newColor.toString();
            jTextArea1.setForeground(newColor);
            fontcolor = fontcolor.replaceAll("javax.swing.plaf.ColorUIResource", "java.awt.Color");
            fontcolor = fontcolor.substring(15, fontcolor.length() - 1);
            fontcolor = fontcolor.replaceAll("r=", "");
            fontcolor = fontcolor.replaceAll("g=", "");
            fontcolor = fontcolor.replaceAll("b=", "");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
        if (newColor != null) {
            bacegroundcolor = newColor.toString();
            jTextArea1.setBackground(newColor);
            bacegroundcolor = bacegroundcolor.replaceAll("javax.swing.plaf.ColorUIResource", "java.awt.Color");
            bacegroundcolor = bacegroundcolor.substring(15, bacegroundcolor.length() - 1);
            bacegroundcolor = bacegroundcolor.replaceAll("r=", "");
            bacegroundcolor = bacegroundcolor.replaceAll("g=", "");
            bacegroundcolor = bacegroundcolor.replaceAll("b=", "");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pos = "right";
        jTextArea1.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jTextArea1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jTextArea1.setAlignmentX(JTextArea.LEFT_ALIGNMENT);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pos = "left";
        jTextArea1.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jTextArea1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jTextArea1.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton6.doClick();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!jTextField1.getText().equalsIgnoreCase("")) {
            try {
                // TODO add your handling code here:
                String ss = jTextArea1.getText();
                jTextArea1.setText("");
                jTextArea1.setText(ss);
                highlight(jTextArea1, jTextField1.getText());
            } catch (BadLocationException ex) {
                Logger.getLogger(fnotebad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (bacegroundcolor.equalsIgnoreCase("-1") && fontcolor.equalsIgnoreCase("-1")) {
                String ss = jTextArea1.getText();
                jTextArea1.setText("");
                jTextArea1.setText(ss);
            } else {
                String[] newdate = bacegroundcolor.split(",");
                Color myWhite = new Color(Integer.parseInt(newdate[0]), Integer.parseInt(newdate[1]), Integer.parseInt(newdate[2]));
                String[] newdate1 = fontcolor.split(",");
                Color myWhite1 = new Color(Integer.parseInt(newdate1[0]), Integer.parseInt(newdate1[1]), Integer.parseInt(newdate1[2]));
                String ss = jTextArea1.getText();
                jTextArea1.setText("");
                jTextArea1.setText(ss);
                jTextArea1.setBackground(myWhite);
                jTextArea1.setForeground(myWhite1);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (!anew.getText().equalsIgnoreCase("") && !old.getText().equalsIgnoreCase("")) {
            jTextArea1.setText(jTextArea1.getText().replaceAll(old.getText(), anew.getText()));

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void anewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anewActionPerformed

    private void anewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anewKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton8.doClick();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_anewKeyPressed

    private void anewKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anewKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_anewKeyReleased

    private void oldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldActionPerformed

    private void oldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            anew.requestFocusInWindow();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_oldKeyPressed

    private void oldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_oldKeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!jTextArea1.getText().equalsIgnoreCase("")) {
            notebad m = new notebad();
            String anser = name;
            int selectedOption = JOptionPane.showConfirmDialog(null, "are you want to update name?", "Choose", 0);
            if (selectedOption == 0) {
                anser = JOptionPane.showInputDialog(null, "please enter name of file", name);
            }
            if (anser == null) {
                anser = name;
            }
            if (anser != null && !anser.equalsIgnoreCase("")) {
                data = jTextArea1.getText();
                m.update(code, anser, data, date(), fontcolor, fontstyle, pos, bacegroundcolor);
                this.dispose();
                fnotebad nn = new fnotebad();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        saved m = new saved();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(fnotebad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fnotebad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fnotebad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fnotebad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fnotebad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anew;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField old;
    // End of variables declaration//GEN-END:variables
}
