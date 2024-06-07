package manu;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.concurrent.atomic.AtomicInteger;

public class myTimer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer Example");
        JLabel label = new JLabel("Time remaining: 30 seconds");

        label.setHorizontalAlignment(JLabel.RIGHT); // align the text to the right
        frame.add(label, BorderLayout.NORTH);

        int delay = 1000; // delay in milliseconds
        AtomicInteger remainingTime = new AtomicInteger(10); // remaining time in seconds
        Timer timer = new Timer(delay, e -> {
            remainingTime.getAndDecrement();
            label.setText(remainingTime + " seconds");
            if (remainingTime.get() == 0) {
                ((Timer)e.getSource()).stop();
                frame.dispose(); // close the window
            }
        });
        timer.start();

        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null); // center the window on the screen
        frame.setVisible(true);
    }
}


