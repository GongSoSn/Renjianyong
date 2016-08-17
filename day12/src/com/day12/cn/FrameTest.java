/**
 *
 */
package com.day12.cn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * @author renjianyong
 *
 */
public class FrameTest implements ActionListener {
    JFrame frame, frame2;
    JButton btnOk;
    JRadioButton rdButton;

    public static void main(String[] args) {
        FrameTest test = new FrameTest();
        test.go();
    }

    public void go() {
        newWidget();
        addwidget();
        setFrame();
        setEvent();
    }

    public void newWidget() {
        frame = new JFrame();
        // frame2 = new JFrame();
        btnOk = new JButton("click");
        rdButton = new JRadioButton("选择");
    }

    public void addwidget() {
        frame.getContentPane().add(BorderLayout.WEST, btnOk);
        // frame2.getContentPane().add(rdButton);
        frame.getContentPane().add(BorderLayout.EAST, rdButton);
    }

    public void setFrame() {
        frame.setSize(700, 500);
        frame.setVisible(true);

        btnOk.setSize(100, 50);
        btnOk.setVisible(true);
    }

    public void setEvent() {
        btnOk.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnOk.setText("已经点击了一下！");
    }
}
